package com.example.buildByQuantity.service;

import com.example.buildByQuantity.exceptions.NotFoundAnnotatedClasses;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Set;

public interface ContainerService {
    Set<Class<?>> getAnnotatedClasses(Class<? extends Annotation> annotation, String packagesPath) throws NotFoundAnnotatedClasses;


}
