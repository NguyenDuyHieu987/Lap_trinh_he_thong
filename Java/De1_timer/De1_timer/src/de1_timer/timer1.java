/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1_timer;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class timer1 extends Thread {

//    public void start() {
//        Thread t = new Thread(this);
//        t.start();
//    }
    @Override
    public void run() {
        try {
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập 1 số: ");
                De1_timer.c = sc.nextFloat();
                System.out.print("Nhập 2 số: ");
                De1_timer.c1 = sc.nextFloat();
                De1_timer.checkChange = true;
                Thread.sleep(5);
            } while (De1_timer.c != 0);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
