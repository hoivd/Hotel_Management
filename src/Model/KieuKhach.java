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
public class KieuKhach {
    private String MaLoaiKhach;
    private String LoaiKhach;
    private String TyLePhuThu;


    public KieuKhach() {
    }

    public KieuKhach(String MaLoaiKhach, String LoaiKhach, String TyLePhuThu) {
        this.MaLoaiKhach = MaLoaiKhach;
        this.LoaiKhach = LoaiKhach;
        this.TyLePhuThu = TyLePhuThu;
    }

    public String getMaLoaiKhach() {
        return MaLoaiKhach;
    }

    public void setMaLoaiKhach(String MaLoaiKhach) {
        this.MaLoaiKhach = MaLoaiKhach;
    }

    public String getLoaiKhach() {
        return LoaiKhach;
    }

    public void setLoaiKhach(String LoaiKhach) {
        this.LoaiKhach = LoaiKhach;
    }
  
     public String getTyLePhuThu() {
        return TyLePhuThu;
    }

    public void setTyLePhuThu(String TyLePhuThu) {
        this.TyLePhuThu = TyLePhuThu;
    }
}
