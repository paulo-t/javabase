package com.paulo.javabase.practice;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person<Integer> person1 = new Person<>();
        person1.setGender(0);

        Person<Boolean> person2 = new Person<>();
        person2.setGender(true);

        list.add(person1);
        list.add(person2);

        System.out.println(list);
    }

    private static class Person<T>{
        private String name;
        private int age;
        private T gender;

        public Person() {
        }

        public Person(String name, int age, T gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public T getGender() {
            return gender;
        }

        public void setGender(T gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}
