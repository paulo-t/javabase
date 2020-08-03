package com.paulo.javabase.module3;

import com.paulo.javabase.module4.task1.AgeException;
import com.paulo.javabase.module4.task1.StuNoException;

import java.io.Serializable;
import java.util.Objects;

/**
 * 学生类
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 617934774695309681L;

    private String studentNo;

    private String name;

    private int age;

    public Student() {
    }

    public Student(String studentNo, String name, int age) throws StuNoException, AgeException {

        setStudentNo(studentNo);
        setAge(age);

        setName(name);
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) throws StuNoException {
        if (null == studentNo || !studentNo.matches("stu[0-9]{3}")) {
            throw new StuNoException("学号格式必须是stu加3位数字");
        }

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

    public void setAge(int age) throws AgeException {
        if (age <= 0 || age > 200) {
            throw new AgeException("年龄必须在(0-200]范围内");
        }
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
