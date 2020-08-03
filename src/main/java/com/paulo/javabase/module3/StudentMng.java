package com.paulo.javabase.module3;

import com.paulo.javabase.module4.task1.AgeException;
import com.paulo.javabase.module4.task1.StuNoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 学生管理系统
 *  使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功 能，根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
 *
 *  其中学生的信息有：学号、姓名、年龄。 要求： 尽量将功能拆分为多个.java 文件。
 */
public class StudentMng {
    private static List<Student> students = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请选择你要进行的操作: 1:添加学生信息 2:修改学生信息 3:查找学生信息 4:遍历学生信息 5:删除学生信息 0:退出");
            int i = sc.nextInt();

            switch (i) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    try {
                        updateStudent(sc);
                    } catch (AgeException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    findStudent(sc);
                    break;
                case 4:
                    listStudent();
                    break;
                case 5:

                default:
                    System.out.println("bye bye~");
                    return;
            }
        }
    }


    /**
     * 添加学生信息
     */
    private static Student addStudent(Scanner sc) {

        Student student = tips(sc);

        if (students.contains(student)) {
            System.out.println("该学生信息已经存在，请进行更新操作!");
            return null;
        }

        students.add(student);
        System.out.println("学生信息添加成功: " + student);

        return student;
    }

    /**
     * 删除学生信息
     */
    private static Student deleteStudent(Scanner sc) {

        Student student = null;
        try {
            System.out.println("请输入学生的学号");

            String stuNO = sc.next();

            int i = students.indexOf(new Student(stuNO, "", 0));

            if(i < 0){
                System.out.println("该学生信息不存在");
                return null;
            }

            student = students.get(i);


            students.remove(student);
        } catch (StuNoException e) {
            e.printStackTrace();
        } catch (AgeException e) {
            e.printStackTrace();
        }

        return student;
    }

    /**
     * 更新学生信息
     */
    private static boolean updateStudent(Scanner sc) throws AgeException {
        Student student = tips(sc);

        int i = students.indexOf(student);

        if (i < 0) {
            System.out.println("系统中不存在当前学生信息!");
            return false;
        }

        Student updateStudent = students.get(i);

        System.out.println("更新前的学生信息为: " + updateStudent);
        updateStudent.setName(student.getName());
        updateStudent.setAge(student.getAge());

        System.out.println("更新后的学生信息为: " + updateStudent);

        return true;
    }

    /**
     * 查找学生信息
     */
    private static Student findStudent(Scanner sc) {

        Student student = null;
        try {
            System.out.println("请输入你要查找的学号");

            String stuNo = sc.next();

            int i = students.indexOf(new Student(stuNo, null, 0));

            if (i < 0) {
                System.out.println("系统中不存在当前学生信息!");
                return null;
            }

            student = students.get(i);
            System.out.println("查找到的学生信息为: " + student);
        } catch (StuNoException e) {
            e.printStackTrace();
        } catch (AgeException e) {
            e.printStackTrace();
        }

        return student;
    }


    /**
     * 遍历学生信息
     */
    private static void listStudent() {
        System.out.println("所有的学生信息如下: ");
        for (Student student : students) {
            System.out.println(student);
        }
    }


    private static Student tips(Scanner sc) {
        Student student = null;
        try {
            System.out.println("请依次输入学生的学号，姓名和年龄");

            String num = sc.next();
            String name = sc.next();
            int age = sc.nextInt();

            student = new Student(num, name, age);
        } catch (StuNoException e) {
            e.printStackTrace();
        } catch (AgeException e) {
            e.printStackTrace();
        }

        return student;
    }
}
