/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de4_ct1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class De4_CT1 {

    public static int n;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket clientSocket = new Socket("localhost", 8889);
            System.out.println("Kết nối thành công đến Server");

            // ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            do {
                System.out.print("Nhập n: ");
                n = sc.nextInt();
                out.writeInt(n);

                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                    System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
                    arr[i] = sc.nextInt();
                }
                out.writeObject(arr);
            } while (n > 0);

            out.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
