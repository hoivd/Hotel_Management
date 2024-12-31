/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.DanhMucDichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.hsqldb.Table;
/**
 *
 * @author asus
 */
public class DanhMucDichVuDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public boolean ThemTTDichVu(DanhMucDichVu DichVu){
        String sql = "INSERT INTO DANHMUCDICHVU(TenDV, DonGia) VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, DichVu.getMaDV());
            ps.setString(1, DichVu.getTenDV());
            ps.setInt(2, DichVu.getDonGia());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaTTDichVu(DanhMucDichVu DichVu){
        String sql = "UPDATE DANHMUCDICHVU SET ACTIVE = 0 WHERE MaDV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, DichVu.getMaDV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaTTDichVu(DanhMucDichVu DichVu){
        String sql = "UPDATE DANHMUCDICHVU SET TenDV = ?, DonGia = ? WHERE MaDV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, DichVu.getTenDV());
            ps.setInt(2, DichVu.getDonGia());
            ps.setInt(3, DichVu.getMaDV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<DanhMucDichVu> getListTTDichVu(){
        ArrayList<DanhMucDichVu> listDichVu = new ArrayList<>();
        String sql = "SELECT MADV, TENDV, DONGIA FROM DANHMUCDICHVU WHERE ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DanhMucDichVu DichVu = new DanhMucDichVu();
                DichVu.setMaDV(rs.getInt("MaDV"));
                DichVu.setTenDV(rs.getString("TenDV"));
                DichVu.setDonGia(rs.getInt("DonGia"));
                listDichVu.add(DichVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDichVu;
    }
    
    public ArrayList<DanhMucDichVu> getListTenDV(){
        ArrayList<DanhMucDichVu> listTenDV = new ArrayList<>();
        String sql = "SELECT TENDV FROM DANHMUCDICHVU WHERE ACTIVE = 1";
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DanhMucDichVu ttTenDV = new DanhMucDichVu();
                ttTenDV.setTenDV((rs.getString("TenDV")));
                listTenDV.add(ttTenDV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTenDV;
    }
    
    public int getGiaDV(String TenDV){
        String sql = "SELECT DONGIA FROM DANHMUCDICHVU WHERE TENDV = ? AND ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, TenDV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("DonGia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
