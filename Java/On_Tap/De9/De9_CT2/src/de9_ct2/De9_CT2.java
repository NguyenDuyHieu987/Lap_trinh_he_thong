/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de9_ct2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ddom6
 */
public class De9_CT2 {

    /**
     * @param args the command line arguments
     */
    public static void Input(Socket clientSocket) {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            while (true) {
                int n = in.readInt();
                if (n < 2) {
                    break;
                } else {
                    List<Float> arrList = new ArrayList<>();
                    float[] arr = (float[]) in.readObject();
                    for (float x : arr) {
                        arrList.add(x);
                    }
                    Collections.sort(arrList, Collections.reverseOrder());
                    System.out.println("Client: ");
                    System.out.println(arrList.get(0));
                    System.out.println(arrList.get(n - 1));
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(100);
            System.out.println("Chờ kết nối từ client");
            Socket clientSocket = serverSocket.accept();
            Input(clientSocket);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
