/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de3_ct1;

import java.io.*;
import java.net.*;

/**
 *
 * @author ddom6
 */
public class De3_CT1 {

    /**
     * @param args the command line arguments
     */
    public void Output() {

    }

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket clientSocket = new Socket("localhost", 8886);
            System.out.println("Kết nối thành công đến Server");

            Output out = new Output(clientSocket);
            out.Xuat();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
