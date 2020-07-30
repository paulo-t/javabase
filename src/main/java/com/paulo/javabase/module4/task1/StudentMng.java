package com.paulo.javabase.module4.task1;

import com.paulo.javabase.module3.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 基于学生信息管理系统增加以下两个功能：
 * <p>
 * a.自定义学号异常类和年龄异常类，并在该成员变量不合理时产生异常对象并抛出。
 * <p>
 * b.当系统退出时将 List 集合中所有学生信息写入到文件中，当系统启动时读取文件中所 有学生信息到 List 集合中。
 */
public class StudentMng {
    private static List<Student> students = new ArrayList<>();

    /**
     * 保存学生信息的文件路径
     */
    private static final String FILE_PATH = "./data/students.txt";

    public static void main(String[] args) {

        //加载之前学生信息
        initStudents();

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
                    //将学生写入文件
                    writeStudents2File();
                    return;
            }
        }
    }

    /**
     * 读取学生信息
     */
    private static void initStudents() {
        File file = new File(FILE_PATH);

        //文件存在再去读取
        if (file.exists()) {
            InputStream is = null;
            ObjectInputStream ois = null;
            try {
                is = new FileInputStream(FILE_PATH);

                ois = new ObjectInputStream(is);

                Object o = ois.readObject();

                if (null != o) {
                    students = (List<Student>) o;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (null != ois) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        System.out.println("学生信息读取成功: " + students);
    }


    /**
     * 将学生信息写入文件
     */
    private static void writeStudents2File() {
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream(FILE_PATH);

            oos = new ObjectOutputStream(os);

            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
       /*     if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }

        System.out.println("学生信息写入文件成功,文件路径: " + FILE_PATH);
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

        System.out.println("请输入学生的学号");

        String stuNO = sc.next();

        int i = students.indexOf(new Student(stuNO, "", 0));

        if (i < 0) {
            System.out.println("该学生信息不存在");
            return null;
        }

        Student student = students.get(i);


        students.remove(student);

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

        System.out.println("请输入你要查找的学号");

        String stuNo = sc.next();

        int i = students.indexOf(new Student(stuNo, null, 0));

        if (i < 0) {
            System.out.println("系统中不存在当前学生信息!");
            return null;
        }

        Student student = students.get(i);
        System.out.println("查找到的学生信息为: " + student);

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
        System.out.println("请依次输入学生的学号，姓名和年龄");

        String num = sc.next();


        String name = sc.next();


        int age = sc.nextInt();

        Student student = new Student(num, name, age);

        return student;
    }
}
