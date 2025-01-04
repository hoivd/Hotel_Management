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
    private int SoKhachToiDa;
    private double TyLePhuThu;
    private String MoTaLoaiPhong;

    public KieuPhong() {
    }

    public KieuPhong(String MaLoaiPhg, String KieuPhong, int KieuGiuong, int DonGia, int SoKhachToiDa,double TyLePhuThu, String MoTaLoaiPhong) {
        this.MaLoaiPhg = MaLoaiPhg;
        this.KieuPhong = KieuPhong;
        this.KieuGiuong = KieuGiuong;
        this.DonGia = DonGia;
        this.SoKhachToiDa = SoKhachToiDa;
        this.MoTaLoaiPhong = MoTaLoaiPhong;
        this.TyLePhuThu = TyLePhuThu;
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
    
    public int getSoKhachToiDa() {
        return SoKhachToiDa;
    }

    public void setSoKhachToiDa(int SoKhachToiDa) {
        this.SoKhachToiDa = SoKhachToiDa;
    }
    
    public String getMoTaLoaiPhong(){
        return MoTaLoaiPhong;
    }
    
    public void setMoTaLoaiPhong(String MoTaLoaiPhong){
        this.MoTaLoaiPhong = MoTaLoaiPhong;
    }
    
    public double getTyLePhuThu(){
        return TyLePhuThu;
    }
    
    public void setTyLePhuThu(double TyLePhuThu){
        this.TyLePhuThu = TyLePhuThu;
    }
}
