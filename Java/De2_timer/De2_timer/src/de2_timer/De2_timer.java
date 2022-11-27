/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de2_timer;

/**
 *
 * @author ddom6
 */
public class De2_timer {

    public static String s = "";
    public static boolean checkChange = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        timer1 t1 = new timer1();
        timer2 t2 = new timer2();

        t1.start();
        t2.start();

    }

}
