/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author asus
 */
public class KieuPhong {
    private String MaLoaiPhg;
    private String KieuPhong;
    private int KieuGiuong;
    private int DonGia;

    public KieuPhong() {
    }

    public KieuPhong(String MaLoaiPhg, String KieuPhong, int KieuGiuong, int DonGia) {
        this.MaLoaiPhg = MaLoaiPhg;
        this.KieuPhong = KieuPhong;
        this.KieuGiuong = KieuGiuong;
        this.DonGia = DonGia;
    }

    public String getMaLoaiPhg() {
        return MaLoaiPhg;
    }

    public void setMaLoaiPhg(String MaLoaiPhg) {
        this.MaLoaiPhg = MaLoaiPhg;
    }

    public String getKieuPhong() {
        return KieuPhong;
    }

    public void setKieuPhong(String KieuPhong) {
        this.KieuPhong = KieuPhong;
    }

    public int getKieuGiuong() {
        return KieuGiuong;
    }

    public void setKieuGiuong(int KieuGiuong) {
        this.KieuGiuong = KieuGiuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
  
  
}
