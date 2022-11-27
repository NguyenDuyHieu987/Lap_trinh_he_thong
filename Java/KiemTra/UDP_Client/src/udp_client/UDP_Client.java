/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udp_client;

import java.net.*;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class UDP_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        // TODO code application logic here

        try {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

//            DatagramSocket clientSocket = new DatagramSocket(8889);
//            System.out.println("Kết nối thành công đến server");
//
//            Scanner sc = new Scanner(System.in);
//
//            while (true) {
//                System.out.print("<< Client >>: ");
//                String sendMessage = sc.nextLine();
//                sendData = sendMessage.getBytes();
//
//                InetAddress IpServer = InetAddress.getByName("localhost");
//                int PortServer = 8888;
//                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpServer, PortServer);
//                clientSocket.send(sendPacket);
//
//                if (sendMessage.equals("thoat")) {
//                    System.out.println("Ngắt kết nối đến << Server >>");
//                    clientSocket.close();
//                    break;
//                } else {
//                    DatagramPacket recivePacket = new DatagramPacket(receiveData, receiveData.length);
//                    clientSocket.receive(recivePacket);
//
//                    String receiveMessage = new String(recivePacket.getData());
//                    System.out.println("                           " + receiveMessage + " :<< Server >>");
//                }
//
//            }
            DatagramSocket clientSocket = new DatagramSocket(8889);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập 1 số nguyên ");
            String sendMessage = sc.nextLine();
            sendData = sendMessage.getBytes();

            InetAddress IpServer = InetAddress.getByName("localhost");
            int PortServer = 8888;
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IpServer, PortServer);

            clientSocket.send(sendPacket);
            System.out.println("Góii tin đã được gửi đi");

            DatagramPacket recivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(recivePacket);

            String message = new String(recivePacket.getData());
            System.out.println("\"<< Server >>: " + message);
            clientSocket.close();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

}
