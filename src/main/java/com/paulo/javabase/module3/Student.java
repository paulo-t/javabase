package com.paulo.javabase.module3;

import java.util.Objects;

/**
 * 学生类
 */
public class Student {
    private String studentNo;

    private String name;

    private int age;

    public Student() {
    }

    public Student(String studentNo, String name, int age) {
        this.studentNo = studentNo;
        this.name = name;
        this.age = age;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNo.equals(student.studentNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNo);
    }
}
