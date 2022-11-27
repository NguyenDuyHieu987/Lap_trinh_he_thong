/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de9_ct1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class De9_CT1 {

    /**
     * @param args the command line arguments
     */
    public static void Output(Socket clientSocket) {
        try {
            Scanner sc = new Scanner(System.in);
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            int n;
            do {
                System.out.print("Nhập n: ");
                n = sc.nextInt();
                out.writeInt(n);
                float[] arr = new float[n];

                for (int i = 0; i < arr.length; i++) {
                    System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
                    arr[i] = sc.nextFloat();
                }
                out.writeObject(arr);
            } while (n >= 2);
            out.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket clientSocket = new Socket("localhost", 100);
            System.out.println("Kết nối thành công đến Server");
            Output(clientSocket);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
