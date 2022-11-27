/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import java.net.*;
import java.io.*;

/**
 *
 * @author ddom6
 */
public class UDP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            // Bước 1 Tạo socket kết nối vs Server
            DatagramSocket clientSocket = new DatagramSocket(8889);
            // Bước 2args: Tạo Packet send gửi cho server
            String send = "hello server";
            sendData = send.getBytes();

            InetAddress IpServer = InetAddress.getByName("localhost");
            int PortServer = 8888;
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpServer, PortServer);

            // Bước 3: Gửi gói tin cho server
            clientSocket.send(sendPacket);
            System.out.println("Gói tin đã được gửi đi");

            // Bước 4: Nhận phản hồi từ server
            DatagramPacket recivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(recivePacket);

            // Bước 5: Đọc dữ liệu từ gói tin nhận được
            String message = new String(recivePacket.getData());
            System.out.println("Server: " + message);
            // Bước 6 Đóng kết nối
            clientSocket.close();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

}
