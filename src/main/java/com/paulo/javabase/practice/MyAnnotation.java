package com.paulo.javabase.practice;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String name() default "";

    int age() default 1;
}
