/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de3_ct2;

import java.io.*;
import java.net.*;

/**
 *
 * @author ddom6
 */
public class Input {

    public static int message = 0;
    private final Socket serverSocket;

    public Input(Socket socket) {
        this.serverSocket = socket;
    }

    public void Nhan() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
            int max = 0;
            while (true) {
                message = Integer.valueOf(in.readLine());
                max = Math.max(message, max);
                System.out.println("Client: " + max);
                if (message > 20000 && message % 1024 == 0) {
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        }
    }
}
