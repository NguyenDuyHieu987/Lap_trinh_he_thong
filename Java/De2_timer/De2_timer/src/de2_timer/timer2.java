/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de2_timer;

/**
 *
 * @author ddom6
 */
public class timer2 extends Thread {

//    public void start() {
//        Thread t = new Thread(this);
//        t.start();
//    }
    @Override
    public void run() {
        try {
            while (De2_timer.s.toLowerCase().equals("thoat") == false) {
                if (De2_timer.checkChange == true) {
                    String nstr = "";
                    char ch;
                    System.out.println("\nOriginal word: " + De2_timer.s);
                    for (int i = 0; i < De2_timer.s.length(); i++) {
                        ch = De2_timer.s.charAt(i); //extracts each character
                        nstr = ch + nstr; //adds each character in front of the existing string
                    }
                    System.out.println("Reversed word: " + nstr);
                    De2_timer.checkChange = false;
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
