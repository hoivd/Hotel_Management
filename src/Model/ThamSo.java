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
public class ThamSo {
    private String MaTS;
    private String TenTS;
    private String GiaTri;

    public ThamSo(String MaTS, String TenTS, String GiaTri) {
        this.MaTS = MaTS;
        this.TenTS = TenTS;
        this.GiaTri = GiaTri;
    }

    public ThamSo() {
    }

    public String getMaTS(){
        return MaTS;
    }
    public void setMaTS(String MaTS){
        this.MaTS = MaTS;
    }
    public String getTenTS(){
        return TenTS;
    }
    public void setTenTS(String TenTS){
        this.TenTS = TenTS;
    }
 
    public String getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(String GiaTri) {
        this.GiaTri = GiaTri;
    }
}
