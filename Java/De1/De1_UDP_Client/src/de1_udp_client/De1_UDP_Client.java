/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de1_udp_client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class De1_UDP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            DatagramSocket clientSocket = new DatagramSocket(8889);
            System.out.println("Kết nối thành công đến Server");
            Scanner sc = new Scanner(System.in);
            System.out.print("<< Client >>: ");
            String send = sc.nextLine();
            sendData = send.getBytes();

            InetAddress IpServer = InetAddress.getByName("localhost");
            int PortServer = 8887;
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpServer, PortServer);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String message = new String(receivePacket.getData()).trim();
            System.out.println("<< Server >>: số từ là: " + message);

            clientSocket.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
