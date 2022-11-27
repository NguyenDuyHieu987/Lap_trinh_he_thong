/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vd1.multithread;

/**
 *
 * @author ddom6
 */
public class VD1MultiThread {

    public static String s = "";
    public static boolean checkChange = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This is main Thread");

        MyThread t = new MyThread();
        MyThread2 t2 = new MyThread2();
        t.start();
        t2.ChayLuongDi();

    }

}
