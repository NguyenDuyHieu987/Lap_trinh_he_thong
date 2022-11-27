/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de2_tcp_server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ddom6
 */
public class De2_TCP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(8887);
            System.out.println("Chờ kết nối từ Client");
            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//            List<String> listMessage = new ArrayList<>();
            for (int i = 1; i < 3; i++) {
                String message = in.readLine();
                System.out.println("message " + i + ": " + message);
                switch (message) {
                    case "0":
                        out.println("zero");
                        out.flush();
//                        listMessage.add("zero");
                        break;
                    case "1":
                        out.println("one");
                        out.flush();
//                        listMessage.add("one");
                        break;
                    case "2":
                        out.println("two");
                        out.flush();
//                        listMessage.add("two");
                        break;
                    case "3":
                        out.println("three");
                        out.flush();
//                        listMessage.add("three");
                        break;
                    case "4":
                        out.println("four");
                        out.flush();
//                        listMessage.add("four");
                        break;
                    case "5":
                        out.println("five");
                        out.flush();
//                        listMessage.add("five");
                        break;
                    case "6":
                        out.println("six");
                        out.flush();
//                        listMessage.add("six");
                        break;
                    case "7":
                        out.println("seven");
                        out.flush();
//                        listMessage.add("seven");
                        break;
                    case "8":
                        out.println("eight");
                        out.flush();
//                        listMessage.add("eight");
                        break;
                    case "9":
                        out.println("nine");
                        out.flush();
//                        listMessage.add("nine");
                        break;
                    default:
                        out.println("Gia tri khong dung");
                        out.flush();
//                        listMessage.add("Gia tri khong dung");
                        break;
                }

            }

//            for (String msg : listMessage) {
//                out.println(msg);
//                out.flush();
//            }
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
