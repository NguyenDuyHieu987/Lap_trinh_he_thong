/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.net.*;
import java.io.*;

/**
 *
 * @author ddom6
 */
public class UDP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            // Bước 1 Khởi tạo socket
            DatagramSocket serverSocket = new DatagramSocket(8888);
            System.out.println("Chờ một gói tin gửi từ client");
            // Bước 2 Nhận 1 gói tin từ client
            DatagramPacket recievePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(recievePacket);
            // Bước 3 Sau khi nhận được gói tin, đọc và xử lý dữ liệu
            String mesage = new String(recievePacket.getData());
            System.out.println("Client: " + mesage);
            String send = mesage.toUpperCase();
            sendData = send.getBytes();
            // Bước 4 Tạo Packet trả thông tin cho client
            InetAddress IpClient = recievePacket.getAddress();
            int PortClient = recievePacket.getPort();

            // Bước 5: Đọc dữ liệu từ gói tin nhận được
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpClient, PortClient);
            serverSocket.send(sendPacket);

            // Bước 5 Đóng kết nối
            serverSocket.close();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

}
