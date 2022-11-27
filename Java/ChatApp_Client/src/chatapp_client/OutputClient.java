/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp_client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class OutputClient implements Runnable {

    public static String send = "";
    private final Socket s_iep;
    private Thread t;

    public OutputClient(Socket socket) {
        this.s_iep = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s_iep.getOutputStream()));
            Scanner sc = new Scanner(System.in);
            do {
                System.out.print("<< Client >>: ");
                send = sc.nextLine();
                out.println(send);
                out.flush();

//                PrintWriter out = new PrintWriter(new OutputStreamWriter(s_iep.getOutputStream()));
//                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//                System.out.print("<< Client >>: ");
//                send = inFromUser.readLine();
//                out.println(send);
//                out.flush();
            } while (send.toLowerCase().equals("thoat") == false);

            s_iep.close();
//            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void start() {
//        if (t == null) {
        t = new Thread(this);
        t.start();
//        }
    }
}
