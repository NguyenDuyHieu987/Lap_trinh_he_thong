/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1_ct2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddom6
 */
public class Input extends Thread {

    @Override
    public void run() {
        try {
            do {
                File myObj = new File("D:\\Lap_Trinh_He_Thong\\Java\\On_Tap\\File\\De1.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    De1_CT2.c = Integer.valueOf(data);
                    if (Integer.valueOf(data) % 1024 != 0) {
                        System.out.println(data);
                    }
                }

            } while (De1_CT2.c % 1024 != 0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
