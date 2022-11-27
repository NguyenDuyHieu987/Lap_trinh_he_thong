/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapp_serrver;

import java.net.*;
import java.io.*;

/**
 *
 * @author ddom6
 */
public class ChatApp_Serrver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            ServerSocket serverSocket = new ServerSocket(8887);

            System.out.println("Chờ kết nối từ client");
            Socket s_iep = serverSocket.accept();

            InputServer t1 = new InputServer(s_iep);
            OutputServer t2 = new OutputServer(s_iep);

            t1.start();
            t2.start();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
