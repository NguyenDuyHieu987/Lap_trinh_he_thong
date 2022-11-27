/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.vd2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

/**
 *
 * @author ddom6
 */
public class TCP_MyClient {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8888);

        try {
            // Bước 1: Kết nối đến Server
            System.out.println("Kết nối thành công đến server");

            //Bước 2: Gửi nhận thông điệp với server
            // Thực hiện theo kịch bản
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

// Bước 2.1: Gửi 1 chuỗi lên server
            String send = "hello server";
            out.println(send); //Đưa vào bộ đệm
            out.flush();// Đẩy bộ đệm lên server

            // Bước 2.2: Nhận thông điệp từ server
            String message = in.readLine();
            System.out.println("server: " + message);

//          Bước 3: Đóng kết nôi
            in.close();
            out.close();
            s.close();

        } catch (Exception e) {
            s.close();
            System.out.println("Lỗi" + e.getMessage());
        }
    }
}
