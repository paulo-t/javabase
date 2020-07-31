package com.paulo.javabase.module4.task3;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
 */
public class MultiCopy {
    private static final ExecutorService POOL = Executors.newFixedThreadPool(5);

    private static final String SPARATOR = "/";

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            System.out.println("请输入要拷贝的目录");
            String src = sc.next();

            File srcFile = new File(src);
            if (!srcFile.exists()) {
                System.out.println("要拷贝的目录不存在");
                return;
            }

            System.out.println("请输入目标目录");
            String target = sc.next();
            File targetFile = new File(target);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
                System.out.println(target + "创建成功");
            }

            System.out.println("开始拷贝文件...");

            copy(srcFile, targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    /**
     * 拷贝文件
     */
    private static void copy(File srcFile, File targetDir) {
        String targetDirectory = targetDir.getAbsolutePath();

        //拷贝的是文件的话直接拷贝过去
        if (srcFile.isFile()) {
            POOL.execute(new CopyThread(srcFile.getAbsolutePath(), targetDirectory + SPARATOR + srcFile.getName()));
            return;
        }

        File[] files = srcFile.listFiles();

        for (File file : files) {
            //是目录创建目录并拷贝文件
            if (file.isDirectory()) {
                File newDirectory = new File(targetDirectory + SPARATOR + file.getName());
                newDirectory.mkdir();
                copy(file, newDirectory);
            } else { //文件直接拷贝
                POOL.execute(new CopyThread(file.getAbsolutePath(), targetDirectory + SPARATOR + file.getName()));
            }
        }
    }

    private static class CopyThread extends Thread {
        /**
         * 源文件路径
         */
        private String srcPath;
        /**
         * 目标文件路径
         */
        private String targetPath;

        public CopyThread(String srcPath, String targetPath) {
            this.srcPath = srcPath;
            this.targetPath = targetPath;
        }

        @Override
        public void run() {
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(new FileInputStream(srcPath));
                bos = new BufferedOutputStream(new FileOutputStream(targetPath));

                byte[] buffer = new byte[1024];

                int len;

                while (-1 != (len = bis.read(buffer, 0, buffer.length))) {
                    bos.write(buffer,0,len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(null != bis){
                        bis.close();
                    }

                    if(null != bos){
                        bos.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
