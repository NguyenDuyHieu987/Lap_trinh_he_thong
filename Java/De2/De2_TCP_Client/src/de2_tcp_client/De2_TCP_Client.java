/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de2_tcp_client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class De2_TCP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket clientSocket = new Socket("localhost", 8887);
            System.out.println("Kết nối thành công đến Server");

            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            for (int i = 1; i < 3; i++) {
                System.out.print("Nhập số thực thứ " + i + ": ");
                float n = sc.nextFloat();
                out.println(Math.round(n));
                out.flush();

                System.out.print("<< Server >> ");
                String message = in.readLine();
                System.out.println("Number " + i + ": " + message);
            }

//            System.out.println("\nServer: ");
//            for (int i = 1; i < 3; i++) {
//                String message = in.readLine();
//                System.out.println("Number " + i + ": " + message);
//            }
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
