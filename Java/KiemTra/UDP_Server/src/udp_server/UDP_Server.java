/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udp_server;

import java.net.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class UDP_Server {

    /**
     * @param args the command line arguments
     */
    private static boolean find_perfect_num(int n) {
        // flag = 1 => số hoàn hảo
        // flag = 0 => không phải số hoàn hảo

        boolean flag = false;
        int total = 0;

        //Tìm tổng ước số   
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                total += i;//Nếu là ước số thì cộng vào tổng
            }
        }
        //So sánh tổng ước số với số đã cho để tìm ra số hoàn hảo
        if (total == n & n != 0) {
            flag = true;
        }

        return flag;
    }

    public static void main(String[] args) throws SocketException {
        // TODO code application logic here

        try {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

//            DatagramSocket serverSocket = new DatagramSocket(8888);
//            System.out.println("Chờ một gói tin gửi từ client");
//
//            Scanner sc = new Scanner(System.in);
//
//            while (true) {
//                DatagramPacket recievePacket = new DatagramPacket(receiveData, receiveData.length);
//                serverSocket.receive(recievePacket);
//
//                String receiveMessage = new String(recievePacket.getData());
//                System.out.println("                           " + receiveMessage + " :<< Client >>");
//
//                if (receiveMessage.trim().equals("thoat")) {
//                    System.out.println("<< Client >> đã ngắt kết nối ");
//                    serverSocket.close();
//                    break;
//                } else {
//                    System.out.print("<< Server >>: ");
//                    String sendMessage = sc.nextLine();
//                    sendData = sendMessage.getBytes();
//
//                    InetAddress IpClient = recievePacket.getAddress();
//                    int PortClient = recievePacket.getPort();
//
//                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpClient, PortClient);
//                    serverSocket.send(sendPacket);
//                }
//
//            }
            DatagramSocket serverSocket = new DatagramSocket(8888);
            System.out.println("Chờ một gói tin gửi từ client");
            DatagramPacket recievePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(recievePacket);
            String mesage = new String(recievePacket.getData()).trim();
            System.out.println("<< Client >>: " + mesage);
            String send;

            int n = Integer.parseInt(mesage);
            if (find_perfect_num(n)) {
                send = mesage + " Là số hoàn hảo";
            } else {
                send = mesage + " không phải Là số hoàn hảo";
            }
            sendData = send.getBytes();
            InetAddress IpClient = recievePacket.getAddress();
            int PortClient = recievePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpClient, PortClient);
            serverSocket.send(sendPacket);
            serverSocket.close();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

}
