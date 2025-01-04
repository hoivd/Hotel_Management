/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.KieuPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class KieuPhongDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemKieuPhong(KieuPhong KP){
        String sql = "INSERT INTO LOAIPHONG(MALOAIPHG, KIEUPHONG, KIEUGIUONG, DONGIA, SOKHACHTOIDA, MOTA, TYLEPHUTHU) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KP.getMaLoaiPhg());
            ps.setString(2, KP.getKieuPhong());
            ps.setInt(3, KP.getKieuGiuong());
            ps.setInt(4, KP.getDonGia());
            ps.setInt(5, KP.getSoKhachToiDa());
            ps.setString(6, KP.getMoTaLoaiPhong());
            ps.setDouble(7, KP.getTyLePhuThu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaKieuPhong(KieuPhong KP){
        String sql = "DELETE FROM LOAIPHONG WHERE MALOAIPHG = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KP.getMaLoaiPhg());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaKieuPhong(KieuPhong KPCu, KieuPhong KPMoi){
        String sql = "UPDATE LOAIPHONG SET MALOAIPHG = ?, KIEUPHONG = ?, KIEUGIUONG = ?, DONGIA = ?, SOKHACHTOIDA = ?, MOTA = ?, TYLEPHUTHU = ? WHERE MALOAIPHG = ?";
        try {
            System.out.println(KPMoi.getTyLePhuThu());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KPMoi.getMaLoaiPhg());
            ps.setString(2, KPMoi.getKieuPhong());
            ps.setInt(3, KPMoi.getKieuGiuong());
            ps.setInt(4, KPMoi.getDonGia());
            ps.setInt(5, KPMoi.getSoKhachToiDa());
            ps.setString(6, KPMoi.getMoTaLoaiPhong());
            ps.setDouble(7, KPMoi.getTyLePhuThu());
            ps.setString(8, KPCu.getMaLoaiPhg());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<KieuPhong> getListKieuPhong(){
        ArrayList<KieuPhong> listKieuPhong = new ArrayList<>();
        String sql = "SELECT MALOAIPHG, KIEUPHONG, KIEUGIUONG, DONGIA, SOKHACHTOIDA, MOTA, TYLEPHUTHU FROM LOAIPHONG";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KieuPhong KP = new KieuPhong();
                KP.setMaLoaiPhg(rs.getString("MaLoaiPhg"));
                KP.setKieuPhong(rs.getString("KieuPhong"));
                KP.setKieuGiuong(rs.getInt("KieuGiuong"));
                KP.setDonGia(rs.getInt("DonGia"));
                KP.setSoKhachToiDa(rs.getInt("SOKHACHTOIDA"));
                KP.setMoTaLoaiPhong(rs.getString("MOTA"));
                KP.setTyLePhuThu(rs.getDouble("TYLEPHUTHU"));
                listKieuPhong.add(KP);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKieuPhong;
    }
}
