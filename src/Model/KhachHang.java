/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.KhachHangDAO;

/**
 *
 * @author asus
 */
public class KhachHang {
    private int MaKH;
    private String TenKH;
    private String CCCD;
    private String GioiTinh;
    private String SDT;
    private int DoanhSo;
    private String MaLoaiKhach;

    public int getDoanhSo() {
        return DoanhSo;
    }

    public void setDoanhSo(int DoanhSo) {
        this.DoanhSo = DoanhSo;
    }

    public KhachHang(int MaKH, String TenKH, String CCCD, String GioiTinh, String SDT) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.CCCD = CCCD;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
    }
    
     public KhachHang(int MaKH, String TenKH, String CCCD, String GioiTinh, String SDT, String MaLoaiKhach) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.CCCD = CCCD;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.MaLoaiKhach = MaLoaiKhach;
    }
    
    public KhachHang() {
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getMaKH(){
        return MaKH;
    }
    public void setMaKH(int MaKH){
        this.MaKH = MaKH;
    }
    public String getTenKH(){
        return TenKH;
    }
    public void setTenKH(String TenKH){
        this.TenKH = TenKH;
    }
    public String getCCCD(){
        return CCCD;
    }
    public void setCCCD(String CCCD){
        this.CCCD = CCCD;
    }
    public String getSDT(){
        return SDT;
    }
    public void setSDT(String SDT){
        this.SDT = SDT;
    }
    public String getMaLoaiKhach(){
        return MaLoaiKhach;
    }
    public void setMaLoaiKhach(String MaLoaiKhach){
        this.MaLoaiKhach = MaLoaiKhach;
    }
    
    public String getTenLoaiKhach(){
        String TenLoaiKhach = new KhachHangDAO().getTenLoaiKhachByMaKH(MaKH);
        return TenLoaiKhach;
    }

    public String getTyLePhuThu(){
        String TyLePhuThu = new KhachHangDAO().getTyLePhuThuByMaKH(MaKH);
        return TyLePhuThu;
    }
}
