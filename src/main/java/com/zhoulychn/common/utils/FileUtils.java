package com.zhoulychn.common.utils;

import java.io.*;
import java.util.Collections;

/**
 * Created by lewis on 2017/1/11.
 * 文件操作相关
 */
public class FileUtils {

    public static final String path = "C:\\Users\\Lewis\\Desktop\\test.txt";

    public static void read(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));


        String temp = null;
        
        while ((temp = br.readLine()) != null) {// 使用readLine方法，一次读一行
            System.out.println(temp);
        }
        br.close();
    }

    public static void write(String filePath, String content, boolean append) {


        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath, append);
             OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write(content);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        write(path, "hello\r\n", true);

        byte[] bytes = "".getBytes();
    }

}
