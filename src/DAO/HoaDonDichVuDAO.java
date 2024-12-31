/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.ThongTinPhong;
import Model.HoaDonDichVu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author asus
 */
public class HoaDonDichVuDAO {
    static Connection con = DataBaseConnection.getConnection();
    public boolean ThemDichVuPhong(HoaDonDichVu HDDV, int madv){
        String sql = "{CALL INSERT_DON_DV(?,?,?,1)}";
        try {
            CallableStatement cp = con.prepareCall(sql);
            cp.setString(1, HDDV.getMaPHG());
            cp.setInt(2,madv);
            cp.setInt(3,HDDV.getSoLuong());
            return cp.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaDichVuPhong(HoaDonDichVu HDDV, int madv){
        String sql = "{Call DELETE_DON_DV(?,?)}";
        try {
            CallableStatement ps = con.prepareCall(sql);
            ps.setString(1, HDDV.getMaPHG());
            ps.setInt(2, madv);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaDichVuPhong(HoaDonDichVu HDDV){
        return false;
    }
    
    public ArrayList<HoaDonDichVu> getListChiTietHDDV(String MaPhong){
        ArrayList<HoaDonDichVu> listChiTietHDDV = new ArrayList<>();
        String sql = "SELECT TENDV, THOIGIANDAT, SOLUONG, DONGIA FROM HOADONDV, PHIEUDATPHONG, DANHMUCDICHVU WHERE HOADONDV.MADV = DANHMUCDICHVU.MADV AND PHIEUDATPHONG.MADATPHONG = HOADONDV.MADATPHONG AND PHIEUDATPHONG.TTNHANPHONG = 1 AND MAPHG = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaPhong);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDonDichVu hddv = new HoaDonDichVu();
                hddv.setTenDV(rs.getString("TENDV"));
                hddv.setNgaySD(rs.getDate("THOIGIANDAT"));
                hddv.setSoLuong(rs.getInt("SOLUONG"));
                hddv.setDonGia(rs.getInt("DONGIA"));
                listChiTietHDDV.add(hddv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietHDDV;
    }
}
