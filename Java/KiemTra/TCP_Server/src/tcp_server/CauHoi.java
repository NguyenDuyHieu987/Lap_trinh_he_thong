/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_server;

/**
 *
 * @author ddom6
 */
public class CauHoi {

    private String NoiDung;
    private String DapAn1;
    private String DapAn2;
    private String DapAn3;
    private String DapAn4;
    private String DapAnDung;

    public CauHoi(String NoiDung, String DapAn1, String DapAn2, String DapAn3, String DapAn4, String DapAnDung) {
        this.NoiDung = NoiDung;
        this.DapAn1 = DapAn1;
        this.DapAn2 = DapAn2;
        this.DapAn3 = DapAn3;
        this.DapAn4 = DapAn4;
        this.DapAnDung = DapAnDung;
    }

    public CauHoi() {
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getDapAn1() {
        return DapAn1;
    }

    public void setDapAn1(String DapAn1) {
        this.DapAn1 = DapAn1;
    }

    public String getDapAn2() {
        return DapAn2;
    }

    public void setDapAn2(String DapAn2) {
        this.DapAn2 = DapAn2;
    }

    public String getDapAn3() {
        return DapAn3;
    }

    public void setDapAn3(String DapAn3) {
        this.DapAn3 = DapAn3;
    }

    public String getDapAn4() {
        return DapAn4;
    }

    public void setDapAn4(String DapAn4) {
        this.DapAn4 = DapAn4;
    }

    public String getDapAnDung() {
        return DapAnDung;
    }

    public void setDapAnDung(String DapAnDung) {
        this.DapAnDung = DapAnDung;
    }

    @Override
    public String toString() {
        return NoiDung + "\t" + "Đáp án: " + DapAn1 + "\t" + DapAn2 + "\t" + DapAn3 + "\t" + DapAn4 + "\t";
    }
}
