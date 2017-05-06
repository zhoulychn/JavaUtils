package com.zhoulychn.cases.netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lewis on 2017/2/9.
 * 时间服务类
 */
public class TimeServer {

    private static int port = 8080;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
