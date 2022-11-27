/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de4_ct2;

import java.io.*;
import java.net.*;

/**
 *
 * @author ddom6
 */
public class De4_CT2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(8889);
            System.out.println("Chờ kết nối từ client");
            Socket clientSocket = serverSocket.accept();

            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                int n = in.readInt();
                if (n <= 0) {
                    break;
                } else {
                    int[] arr = (int[]) in.readObject();
                    System.out.println("Client: ");
                    for (int x : arr) {
                        System.out.println(x);
                    }
                }
            }
            in.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
