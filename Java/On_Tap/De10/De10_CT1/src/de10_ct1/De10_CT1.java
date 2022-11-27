/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de10_ct1;

import java.io.*;
import java.net.*;

/**
 *
 * @author ddom6
 */
public class De10_CT1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket clientSocket = new Socket("localhost", 2014);
            System.out.println("Kết nối thành công đến Server");
            OutputStream output = new FileOutputStream("C:\\Users\\ddom6\\OneDrive\\Hình ảnh\\eternals-deviant.webp");
            InputStream in = clientSocket.getInputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer, 0, buffer.length);
            while ((bytesRead = in.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
