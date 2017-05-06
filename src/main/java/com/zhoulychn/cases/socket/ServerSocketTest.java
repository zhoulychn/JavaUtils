package com.zhoulychn.cases.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * Created by lewis on 2017/2/11.
 * 服务器
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        socket.shutdownInput();
        br.close();
        isr.close();
        inputStream.close();
        socket.close();
        server.close();
    }
}
