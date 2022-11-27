/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapp_client;

import java.net.*;
import java.io.*;

/**
 *
 * @author ddom6
 */
public class ChatApp_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket clientSocket = new Socket("localhost", 8887);
            System.out.println("Kết nối thành công đến Server");

            InputClient t1 = new InputClient(clientSocket);
            OutputClient t2 = new OutputClient(clientSocket);

            t1.start();
            t2.start();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
