/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de3_ct1;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 *
 * @author ddom6
 */
public class Output {

    public static int send = 0;
    private final Socket clientSocket;

    public Output(Socket socket) {
        this.clientSocket = socket;
    }

    public void Xuat() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            do {
                Random rd = new Random();
                send = rd.nextInt(50000) + 1;
                System.out.println("Server: " + send);
                out.println(send);
                out.flush();
            } while (send < 20000 || send % 1024 != 0);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
