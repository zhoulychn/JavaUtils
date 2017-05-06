package com.zhoulychn.cases.container;

import java.io.*;
import java.net.Socket;

/**
 * Created by lewis on 2017/2/15.
 * http请求
 */
public class HttpSender {

    public static void main(String[] args) {
        try {
            HttpSender.send("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void send(String host, int port) throws IOException, InterruptedException {
        Socket socket = new Socket(host, port);
        OutputStream os = socket.getOutputStream();
        boolean flush = true;
        PrintWriter out = new PrintWriter(os, flush);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("GET /index HTTP/1.1");
        out.println("Host:localhost:8080");
        out.println("Connection:Close");
        out.println();

        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            Thread.currentThread().sleep(50);
        }
        System.out.println(sb.toString());
        socket.close();
    }
}
