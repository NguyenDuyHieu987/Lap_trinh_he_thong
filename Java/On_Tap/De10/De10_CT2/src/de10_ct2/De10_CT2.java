/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de10_ct2;

import java.io.*;
import java.net.*;

/**
 *
 * @author ddom6
 */
public class De10_CT2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(2014);
            System.out.println("Chờ kết nối từ client");
            Socket clientSocket = serverSocket.accept();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
