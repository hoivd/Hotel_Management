/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.KieuKhach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class KieuKhachDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemKieuKhach(KieuKhach KK){
        String sql = "INSERT INTO LOAIKHACH(MALOAIKHACH, TENLOAIKHACH) VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KK.getMaLoaiKhach());
            ps.setString(2, KK.getLoaiKhach());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaKieuKhach(KieuKhach KK){
        String sql = "DELETE FROM LOAIKHACH WHERE MALOAIKHACH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KK.getMaLoaiKhach().toString());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaKieuKhach(KieuKhach KKCu, KieuKhach KKMoi){
        String sql = "UPDATE LOAIKHACH SET MALOAIKHACH = ?, TENLOAIKHACH = ? WHERE MALOAIKHACH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, KKMoi.getMaLoaiKhach());
            ps.setString(2, KKMoi.getLoaiKhach());
            ps.setString(3, KKCu.getMaLoaiKhach());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<KieuKhach> getListKieuKhach(){
        ArrayList<KieuKhach> listKieuKhach = new ArrayList<>();
        String sql = "SELECT MALOAIKHACH, TENLOAIKHACH FROM LOAIKHACH";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KieuKhach KK = new KieuKhach();
                KK.setMaLoaiKhach(rs.getString("MALOAIKHACH"));
                KK.setLoaiKhach(rs.getString("TENLOAIKHACH"));
                listKieuKhach.add(KK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKieuKhach;
    }
    
    public String getFilterMaLoaiKhach(String TenLoaiKhach){
        String sql = "SELECT MALOAIKHACH FROM LOAIKHACH WHERE TENLOAIKHACH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, TenLoaiKhach);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 return rs.getString("MALOAIKHACH");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
