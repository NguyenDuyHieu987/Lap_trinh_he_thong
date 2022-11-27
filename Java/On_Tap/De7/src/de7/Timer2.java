/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de7;

/**
 *
 * @author ddom6
 */
public class Timer2 extends Thread {

    @Override
    public void run() {
        try {
            while (De7.c != '!') {
                java.awt.Toolkit.getDefaultToolkit().beep();
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
