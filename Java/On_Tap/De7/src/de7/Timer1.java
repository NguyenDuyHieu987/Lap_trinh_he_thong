/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de7;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Timer1 extends Thread {

    @Override
    public void run() {
        try {
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập 1 ký tự: ");
                De7.c = sc.next().charAt(0);
                Thread.sleep(7);
            } while (De7.c != '!');
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
