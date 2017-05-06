package com.zhoulychn.common.utils;

import java.io.*;

/**
 * Created by lewis on 2017/1/11.
 * 文件操作相关
 */
public class FileUtils {

    public static void read(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String temp = null;
        while ((temp = br.readLine()) != null) {// 使用readLine方法，一次读一行
            System.out.println(temp);
        }
        br.close();
    }

    public static void write(String filePath) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        bufferedWriter.write("hello");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
