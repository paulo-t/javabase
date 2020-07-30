package com.paulo.javabase.practice.file;

import java.io.File;
import java.io.IOException;

/**
 * File 关联到本地的一个文件或者文件夹
 * 可以获取文件的属性、创建以及删除文件
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        /*File file = new File("d:/data.txt");

        if(!file.exists()){
            file.createNewFile();
        }

        System.out.println("文件名: " + file.getName());
        System.out.println("文件绝对路径: " + file.getAbsolutePath());
        System.out.println("上次修改时间: " + file.lastModified());
        System.out.println("文件大小: " + file.length());

        System.out.println(file.delete() ? "文件删除成功" : "文件删除失败");

        //*****************************************************************************

        File file1 = new File("d:\\data\\1\\2");

        if(!file1.exists()){
            System.out.println(file1.mkdirs() ? "文件创建成功" : "文件创建失败");
        }

        file1.delete();*/

        //*****************************************************************************
        File file =new File("d:\\data");
        allFile(file);

    }


    private static void allFile(File file){
        if(!file.isDirectory()){
            System.out.println(file.getName());
            return;
        }

        System.out.println("[" + file.getName() + "]");
        File[] files = file.listFiles();
        for (File file1 : files) {
            allFile(file1);
        }
    }
}
