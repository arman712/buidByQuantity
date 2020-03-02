package com.example.buildByQuantity;

import com.example.buildByQuantity.core.Container;
import com.example.buildByQuantity.exceptions.ContainerIsEmpty;
import com.example.buildByQuantity.exceptions.NotFoundAnnotatedClasses;
import com.example.buildByQuantity.exceptions.NotFoundClass;
import com.example.buildByQuantity.exceptions.NotFoundObjectByIndex;
import com.example.buildByQuantity.modelTest.Car;
import com.example.buildByQuantity.modelTest.Doctor;
import com.example.buildByQuantity.modelTest.User;


public class Main {

    public static void main(String[] args) throws NotFoundAnnotatedClasses, IllegalAccessException, InstantiationException, NotFoundObjectByIndex, NotFoundClass, ContainerIsEmpty {


    Container container=new Container("com.example.buildByQuantity.modelTest");
    User user=(User)container.getByIndex("User",5);
    user.setName("John");
    user.setSurname("Smith");

    System.out.println((User)container.getByIndex("User",5));

       User user1=container.getByIndex(User.class,5);
        System.out.println(user1);










    }






}
