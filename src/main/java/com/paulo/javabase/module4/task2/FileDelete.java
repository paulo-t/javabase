package com.paulo.javabase.module4.task2;

import java.io.File;
import java.util.Scanner;

/**
 * 实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
 */
public class FileDelete {

    public static void main(String[] args) {

        Scanner sc = null;
        try {
            sc = new Scanner(System.in);

            System.out.println("请输入你要删除的目录");

            String path = sc.next();

            System.out.println("你要删除的目录为：" + path + "请确认是否删除(y/n)");

            String ensure = sc.next();

            int time = 0;

            while (!ensure.equalsIgnoreCase("y") && !ensure.equalsIgnoreCase("n") && time < 3) {
                System.out.println("你要删除的目录为：" + path + "请确认是否删除(y/n)");
                ensure = sc.next();

                if (!ensure.equalsIgnoreCase("y") && !ensure.equalsIgnoreCase("n")) {
                    time++;
                }
            }

            if (time >= 3) {
                return;
            }

            File file = new File(path);

            if(!file.exists()){
                System.out.println("你要删除的目录不存在!");
                return;
            }

            deleteFiles(file);

            System.out.println(path + "目录删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }


    }

    private static void deleteFiles(File root){

        //文件或者空文奸济恶直接删除
        if(canDelete(root)){
            root.delete();

            return;
        }

        //删除子目录和文件
        File[] files = root.listFiles();

        for (File file : files) {
            deleteFiles(file);
        }

        //删除当前文件夹
        root.delete();
    }


    /**
     * 空文件夹
     */
    private static boolean emptyDirectory(File file){
        return file.isDirectory() && file.listFiles().length == 0;
    }

    /**
     * 是否可以删除
     */
    private static boolean canDelete(File file){
        return file.isFile() || emptyDirectory(file);
    }
}
