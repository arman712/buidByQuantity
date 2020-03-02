package com.example.buildByQuantity.core;

import com.example.buildByQuantity.annotations.BuildByQuantity;
import com.example.buildByQuantity.exceptions.ContainerIsEmpty;
import com.example.buildByQuantity.exceptions.NotFoundAnnotatedClasses;
import com.example.buildByQuantity.exceptions.NotFoundClass;
import com.example.buildByQuantity.exceptions.NotFoundObjectByIndex;
import com.example.buildByQuantity.service.ContainerService;
import com.example.buildByQuantity.service.impl.ContainerServiceImpl;

import java.util.HashMap;
import java.util.Set;

public class Container {
    private HashMap<String, HashMap<Integer, Object>> container;

    public Container(String scanPackagePath) throws NotFoundAnnotatedClasses, InstantiationException, IllegalAccessException {
        ContainerService containerService = new ContainerServiceImpl();
        creatContainer(containerService.getAnnotatedClasses(BuildByQuantity.class, scanPackagePath));
    }

    private void creatContainer(Set<Class<?>> annotatedClasses) throws IllegalAccessException, InstantiationException {

        if (annotatedClasses.size() != 0) {

            container = new HashMap<String, HashMap<Integer, Object>>();
            for (Class c : annotatedClasses) {
                BuildByQuantity b = (BuildByQuantity) c.getAnnotation(BuildByQuantity.class);
                String className = c.getSimpleName();
                int objectCount = b.quantity();
                HashMap<Integer, Object> box = new HashMap<Integer, Object>();
                for (int i = 0; i < objectCount; i++) {
                    box.put(i + 1, c.newInstance());
                }
                container.put(className, box);
            }
        }
    }

    public Object getByIndex(String className, int index) throws ContainerIsEmpty, NotFoundClass, NotFoundObjectByIndex {

        if (container == null) {
            throw new ContainerIsEmpty("the container is not initialized because there are no annotated classes");
        }
        if (container.get(className) == null) {
            throw new NotFoundClass("there is no class named " + className + " in the container");
        }

        Object o = container.get(className).get(index);

        if (o == null) {
            throw new NotFoundObjectByIndex("there is no object under such index");
        }
        return o;


    }

    public <T> T getByIndex(Class<T> c, int index) throws ContainerIsEmpty, NotFoundObjectByIndex, NotFoundClass {

        if (container == null) {
            throw new ContainerIsEmpty("the container is not initialized because there are no annotated classes");
        }
        for (HashMap<Integer, Object> box : container.values()) {

            if (box.get(1).getClass() == c) {

                if (box.get(index) != null) {

                    return (T) box.get(index);

                } else  {
                       throw new NotFoundObjectByIndex("there is no object under such index");
                 }
            }
        }
        throw new NotFoundClass("there is no class named " + c.getSimpleName() + " in the container");
    }


}
