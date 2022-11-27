/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1;

import java.io.FileWriter;
import java.util.Random;
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
                Random rn = new Random();
                Scanner sc = new Scanner(System.in);
                System.out.println(rn.nextInt(2) + 1);
//                System.out.print("Nhập 1 số: ");
                De1_CT1.c = rn.nextInt(1024) + 1;
                FileWriter myWriter = new FileWriter("D:\\Lap_Trinh_He_Thong\\Java\\On_Tap\\File\\De1.txt");
                myWriter.write(Integer.toString(De1_CT1.c));
                myWriter.close();
                if (De1_CT1.c % 1024 == 0) {
                    break;
                }
            } while (De1_CT1.c > 0);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
