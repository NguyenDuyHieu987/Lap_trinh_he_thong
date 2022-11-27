/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udp_myserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class UDP_MyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            DatagramSocket serverSocket = new DatagramSocket(8888);
            System.out.println("Chờ một gói tin gửi từ client");

            Scanner sc = new Scanner(System.in);

            while (true) {
                DatagramPacket recievePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(recievePacket);

                String receiveMessage = new String(recievePacket.getData());
                System.out.println("                           " + receiveMessage + " :<< Client >>");

                if (receiveMessage.trim().equals("thoat")) {
                    System.out.println("<< Client >> đã ngắt kết nối ");
                    serverSocket.close();
                    break;
                } else {
                    System.out.print("<< Server >>: ");
                    String sendMessage = sc.nextLine();
                    sendData = sendMessage.getBytes();

                    InetAddress IpClient = recievePacket.getAddress();
                    int PortClient = recievePacket.getPort();

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpClient, PortClient);
                    serverSocket.send(sendPacket);
                }

            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

}
