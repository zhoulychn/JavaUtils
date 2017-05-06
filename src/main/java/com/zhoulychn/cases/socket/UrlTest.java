package com.zhoulychn.cases.socket;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by lewis on 2017/2/11.
 * URL类
 */
public class UrlTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");
        InputStream inputStream = url.openStream();
        byte[] bys = new byte[1024];
        while (inputStream.read(bys) != -1) {
            System.out.println(new String(bys, "UTF-8"));
        }
        inputStream.close();
    }
}
