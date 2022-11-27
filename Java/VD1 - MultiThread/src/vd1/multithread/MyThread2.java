/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vd1.multithread;

/**
 *
 * @author ddom6
 */
public class MyThread2 implements Runnable {

    public void ChayLuongDi() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
//            System.out.println("This is child Thread 2s");
            while (VD1MultiThread.s.toLowerCase().equals("thoat") == false) {
                if (VD1MultiThread.checkChange == true) {
                    System.out.println("s = " + VD1MultiThread.s);
                    VD1MultiThread.checkChange = false;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("loi: " + e.getMessage());
        }

    }

}
