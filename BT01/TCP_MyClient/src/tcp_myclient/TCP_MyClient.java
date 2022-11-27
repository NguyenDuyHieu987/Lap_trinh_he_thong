/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_myclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class TCP_MyClient {

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

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("<< Client >>: ");
                String sendMessage = sc.nextLine();
                out.println(sendMessage);
                out.flush();

                if (sendMessage.equals("thoat")) {
                    System.out.println("Ngắt kết nối đến << Server >>");
                    in.close();
                    out.close();
                    s.close();
                    break;
                } else {
                    String receiveMessage = in.readLine();
                    System.out.println("                           " + receiveMessage + " :<< Server >>");
                }

            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

}
