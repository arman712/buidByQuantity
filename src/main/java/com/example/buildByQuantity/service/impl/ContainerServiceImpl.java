package com.example.buildByQuantity.service.impl;

import com.example.buildByQuantity.exceptions.NotFoundAnnotatedClasses;
import com.example.buildByQuantity.service.ContainerService;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Set;

public class ContainerServiceImpl implements ContainerService {

    public Set<Class<?>> getAnnotatedClasses(Class<? extends Annotation> annotation, String packagesPath) throws NotFoundAnnotatedClasses {

        Reflections reflections=new Reflections(packagesPath);
        Set<Class<?>> annotatedClasses=reflections.getTypesAnnotatedWith(annotation,true);

        if(annotatedClasses.size()==0){
            throw new NotFoundAnnotatedClasses("classes with  annotation not found");
        }
      return annotatedClasses;
    }


}
