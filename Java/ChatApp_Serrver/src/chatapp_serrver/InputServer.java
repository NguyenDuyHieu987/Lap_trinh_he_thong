/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp_serrver;

import java.net.*;
import java.io.*;

/**
 *
 * @author ddom6
 */
public class InputServer implements Runnable {

    public static String message = "";
    private final Socket s_iep;
    private Thread t;

    public InputServer(Socket socket) {
        this.s_iep = socket;
    }

    @Override
    public void run() {
        try {
            while (message.toLowerCase().equals("thoat") == false) {
                BufferedReader in = new BufferedReader(new InputStreamReader(s_iep.getInputStream()));
                message = in.readLine();
                System.out.println("                           " + message + " :<< Client >>");
                Thread.sleep(5000);
            }
            s_iep.close();

        } catch (Exception e) {
            System.err.println("Error 2: " + e.getMessage());
        }
    }

    public void start() {
//        if (t == null) {
        t = new Thread(this);
        t.start();
//        }
    }
}
