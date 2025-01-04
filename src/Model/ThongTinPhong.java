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
public class ThongTinPhong {
    private String MaPhg;
    private String KieuPhong;
    private int KieuGiuong;
    private int DonGia;
    private String MoTa;
    private int TinhTrang;
    private int SoKhachToiDa;
    private double TyLePhuThu;
  
    public ThongTinPhong() {
    }

    public ThongTinPhong(String MaPhg, String KieuPhong, int KieuGiuong, int DonGia, String MoTa, int SoKhachToiDa) {
        this.MaPhg = MaPhg;
        this.KieuPhong = KieuPhong;
        this.KieuGiuong = KieuGiuong;
        this.DonGia = DonGia;
        this.MoTa = MoTa;
        this.SoKhachToiDa = SoKhachToiDa;
    }
    
    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
    public String getMaPhg() {
        return MaPhg;
    }

    public void setMaPhg(String MaPhg) {
        this.MaPhg = MaPhg;
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

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    public int getSoKhachToiDa() {
        return SoKhachToiDa;
    }

    public void setSoKhachToiDa(int SoKhachToiDa) {
        this.SoKhachToiDa = SoKhachToiDa;
    }
    
    public double getTyLePhuThu(){
        return TyLePhuThu;
    }
    
    public void setTyLePhuThu(double TyLePhuThu){
        this.TyLePhuThu = TyLePhuThu;
    }
}
