/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de5_ct2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ddom6
 */
public class Input extends Thread {

    @Override
    public void run() {
        try {
            char c = ' ';
            do {
                File myObj = new File("D:\\Lap_Trinh_He_Thong\\Java\\On_Tap\\File\\De5.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNext()) {
                    c = myReader.next().charAt(0);
                    System.out.println(c);
                    Thread.sleep(10);
                }
                myReader.close();
            } while (c != '!');

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
