/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de1_timer;

/**
 *
 * @author ddom6
 */
public class timer2 implements Runnable {

    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            while (De1_timer.c != 0) {
                if (De1_timer.checkChange == true) {
//                    int dem = 0;
//                    System.out.println("\nc: " + De1_timer.c);
//                    for (int i = 1; i <= De1_timer.c; i++) {
//                        if (De1_timer.c % i == 0) {
//                            dem++;
//                        }
//                    }
//                    if (dem == 2) {
//                        System.out.println(De1_timer.c + " là số nguyên tố");
//                    } else {
//                        System.out.println(De1_timer.c + " không phải là số nguyên tố");
//                    }
//                    dem = 0;
//                    De1_timer.checkChange = false;

//                    int gcd = 1;
//                    for (int i = 1; i <= De1_timer.c && i <= De1_timer.c1; i++) {
//                        if (De1_timer.c % i == 0 && De1_timer.c1 % i == 0) {
//                            gcd = i;
//                        }
//                    }
//                    System.out.printf("\nƯớc chung lớn nhất của %f và %f là: %d", De1_timer.c, De1_timer.c1, gcd);
//                    De1_timer.checkChange = false;
                    float lcm;
                    lcm = (De1_timer.c > De1_timer.c1) ? De1_timer.c : De1_timer.c1;
                    while (true) {
                        if (lcm % De1_timer.c == 0 && lcm % De1_timer.c1 == 0) {
                            System.out.printf("\nBội chung nhỏ nhất của %f và %f là %f.", De1_timer.c, De1_timer.c1, lcm);
                            break;
                        }
                        ++lcm;
                    }
                    De1_timer.checkChange = false;
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
