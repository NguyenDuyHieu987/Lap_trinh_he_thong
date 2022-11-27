/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp_server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ddom6
 */
public class TCP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Chờ kết nối từ client");
            Socket s = serverSocket.accept();
            System.out.println("Có 1 kết nối từ client: " + s.getInetAddress());

            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            List<CauHoi> liscaCauHois = new ArrayList<>();
            liscaCauHois.add(new CauHoi("1 + 1 = ?", "1", "2", "3", "4", "2"));
            liscaCauHois.add(new CauHoi("1 + 2 = ?", "1", "2", "3", "4", "3"));
            liscaCauHois.add(new CauHoi("1 + 3 = ?", "1", "2", "3", "4", "4"));

            for (CauHoi cauhoi : liscaCauHois) {
                out.println(cauhoi.toString()); //Đưa vào bộ đệm
                out.flush();
            }

            List<String> mylList = new ArrayList<String>();
            for (int i = 0; i < 3; i++) {
                String message = in.readLine();
                mylList.add(message);
                System.out.println("client: " + message);

            }

//            List<String> mylList = new ArrayList<String>(Arrays.asList(message.split(" ")));
            int score = 0;
            for (int i = 0; i < mylList.size(); i++) {
                if (mylList.get(i).equals(liscaCauHois.get(i).getDapAnDung())) {
                    score++;
                }
            }
            out.println(String.valueOf(score) + "/3"); //Đưa vào bộ đệm
            out.flush();// Đẩy bộ đệm dến client

//          Bước 4: Đóng kết nối
            in.close();
            out.close();
            s.close();

        } catch (Exception e) {
            System.out.println("Lỗi" + e.getMessage());
        }
    }

}
