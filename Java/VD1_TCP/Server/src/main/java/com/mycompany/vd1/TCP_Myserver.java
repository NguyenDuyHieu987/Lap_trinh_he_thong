/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.vd1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author ddom6
 */
public class TCP_Myserver {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Chờ kết nối từ client");
        Socket s = serverSocket.accept();
        try {
//            InetAddress inet = InetAddress.getByName("youtube.com");
//            System.out.println(inet.getHostName() + ":" + inet.getHostAddress());

            // Server Socket: để tạo Server
            // Socket: Để quản lý phiên lầm việc
            // Bước 1: Khởi tạo Server
//          B3: Thực hiện gửi/ nhận thông điệp với client
            // Bước 2: Chờ kết nối từ client đến server
            System.out.println("Có 1 kết nối từ client: " + s.getInetAddress());

            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

//          Bước 3.1: Nhận dữ liệu từ Client
            String message = in.readLine();
            System.out.println("client: " + message);
            String send = message.toUpperCase();

//             Bước 3.2: Gửi dữ liệu đến Client
            out.println(message); //Đưa vào bộ đệm
            out.flush();// Đẩy bộ đệm dến client

//          Bước 4: Đóng kết nối
            in.close();
            out.close();
            s.close();

//            while (true) {
//                Socket incoming = serverSocket.accept();
//            }
//            Socket clientSocket = new Socket("142.250.66.110", 8888);
        } catch (Exception e) {
            s.close();
            System.out.println("Lỗi" + e.getMessage());

        }

    }
}
