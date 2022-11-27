/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de2;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Task1 extends Thread {

    @Override
    public void run() {
        try {
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập 1 chuỗi: ");
                De2.s = sc.nextLine();
            } while (De2.s.toLowerCase().equals("exit") == false);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
