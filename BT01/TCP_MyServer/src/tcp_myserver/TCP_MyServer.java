/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_myserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class TCP_MyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("Chờ kết nối từ client");
            Socket s = serverSocket.accept();
            System.out.println("Có 1 kết nối từ client: " + s.getInetAddress());

            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            Scanner sc = new Scanner(System.in);

            while (true) {
                String receiveMessage = in.readLine();
                System.out.println("                           " + receiveMessage + " :<< Client >>");

                if (receiveMessage.equals("thoat")) {
                    System.out.println("<< Client >> đã ngắt kết nối ");
                    in.close();
                    out.close();
                    s.close();
                    break;
                } else {
                    System.out.print("<< Server >>: ");
                    String sendMessage = sc.nextLine();
                    out.println(sendMessage);
                    out.flush();
                }

            }

        } catch (Exception e) {
            System.out.println("Lỗi" + e.getMessage());

        }
    }

}
