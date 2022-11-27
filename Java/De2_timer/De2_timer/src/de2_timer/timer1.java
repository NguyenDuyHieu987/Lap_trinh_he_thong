/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de2_timer;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class timer1 extends Thread {

    @Override
    public void run() {
        try {
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập chuỗi: ");
                De2_timer.s = sc.nextLine();
                De2_timer.checkChange = true;
                Thread.sleep(5);
            } while (De2_timer.s.toLowerCase().equals("thoat") == false);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
