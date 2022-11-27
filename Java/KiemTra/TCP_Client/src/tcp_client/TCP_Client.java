/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class TCP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            Socket s = new Socket("localhost", 8888);
            System.out.println("Kết nối thành công đến server");

            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            for (int i = 0; i < 3; i++) {
                String message = in.readLine();
                System.out.println("Câu hỏi " + (i + 1) + ": " + message);
            }
            for (int i = 0; i < 3; i++) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập đáp án " + (i + 1) + ": ");
                String send = sc.nextLine();
                out.println(send); //Đưa vào bộ đệm
                out.flush();// Đẩy bộ đệm lên server
            }

            String message2 = in.readLine();
            System.out.println("Ket qua: " + message2);

            in.close();
            out.close();
            s.close();

        } catch (Exception e) {
            System.out.println("Lỗi" + e.getMessage());
        }
    }

}
