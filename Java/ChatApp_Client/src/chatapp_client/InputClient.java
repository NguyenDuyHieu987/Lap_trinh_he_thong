/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp_client;

import java.net.*;
import java.io.*;

/**
 *
 * @author ddom6
 */
public class InputClient implements Runnable {

    public static String message = "";
    private final Socket s_iep;
    private Thread t;

    public InputClient(Socket socket) {
        this.s_iep = socket;
    }

    @Override
    public void run() {
        try {
            while (message.toLowerCase().equals("thoat") == false) {
                BufferedReader in = new BufferedReader(new InputStreamReader(s_iep.getInputStream()));
                message = in.readLine();
                System.out.println("                           " + message + " :<< Server >>");
                Thread.sleep(5000);
            }
            s_iep.close();
        } catch (Exception e) {
            System.err.println("Error 1: " + e.getMessage());
        }
    }

    public void start() {
//        if (t == null) {
        t = new Thread(this);
        t.start();
//        }
    }
}
