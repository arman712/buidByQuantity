package com.example.buildByQuantity.annotations;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BuildByQuantity {

    int quantity() default 1;

}
