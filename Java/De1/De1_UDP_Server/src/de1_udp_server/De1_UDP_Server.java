/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de1_udp_server;

import java.net.*;
import java.io.*;

/**
 *
 * @author ddom6
 */
public class De1_UDP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            DatagramSocket serverSocket = new DatagramSocket(8887);
            System.out.println("Chờ kết nối từ client");

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String message = new String(receivePacket.getData()).trim();
            System.out.println("<< Client >>: " + message);
            int numberOfWord = message.split(" ").length - 1;
            sendData = String.valueOf(numberOfWord).getBytes();

            InetAddress IpClient = receivePacket.getAddress();
            int PortClient = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpClient, PortClient);
            serverSocket.send(sendPacket);

            serverSocket.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
