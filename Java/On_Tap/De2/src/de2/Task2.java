/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de2;

/**
 *
 * @author ddom6
 */
public class Task2 extends Thread {

    @Override
    public void run() {
        try {
            while (De2.s.toLowerCase().equals("exit") == false) {
                System.out.println(De2.s);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
