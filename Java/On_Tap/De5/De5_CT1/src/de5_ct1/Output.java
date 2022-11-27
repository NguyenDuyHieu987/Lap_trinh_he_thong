/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de5_ct1;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Output extends Thread {

    @Override
    public void run() {
        try {
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Nhập 1 ký tự: ");
                De5_CT1.c = sc.next().charAt(0);
                FileWriter MyWriter = new FileWriter("D:\\Lap_Trinh_He_Thong\\Java\\On_Tap\\File\\De5.txt");
                MyWriter.write(De5_CT1.c);
                MyWriter.close();
                Thread.sleep(5);
            } while (De5_CT1.c != '!');

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
