/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vd1.multithread;

import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class MyThread extends Thread {

    @Override
    public void run() {
//        System.out.println("This is child Thread");

        do {
            Scanner sc = new Scanner(System.in);
            VD1MultiThread.s = sc.nextLine();
            VD1MultiThread.checkChange = true;
        } while (VD1MultiThread.s.toLowerCase().equals("thoat") == false);
    }

}
