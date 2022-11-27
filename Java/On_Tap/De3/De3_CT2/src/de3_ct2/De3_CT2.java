/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de3_ct2;

import java.io.*;
import java.net.*;

/**
 *
 * @author ddom6
 */
public class De3_CT2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket serverSocket = new ServerSocket(8886);
            System.out.println("Chờ kết nối từ Client");
            Socket clientSocket = serverSocket.accept();

            Input in = new Input(clientSocket);
            in.Nhan();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
