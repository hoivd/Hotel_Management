package DAO;

import Model.ThamSo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class ThamSoDAO {
    Connection con = DataBaseConnection.getConnection();
//    public int getCurrentMaKH(){
//        int result = -1;
//        String sql = "SELECT MATS_SEQ.NEXTVAL AS VAL FROM DUAL ";
//        try{
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next())
//            {
//                result = rs.getInt("VAL");
//                return result;
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//
//    }
//    public boolean ThemQuiDinh(QuiDinh qd){       
//        String sql = "INSERT INTO THAMSO(TenKH, CCCD, GioiTinh, SDT) VALUES(?,?,?,?)";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
////            ps.setInt(1, kh.getMaKH());
////            ps.setString(1, kh.getTenKH());
////            ps.setString(2, kh.getCCCD());
////            ps.setString(3, kh.getGioiTinh());
////            ps.setString(4, kh.getSDT());
//    
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    
//    public boolean XoaQuiDinh(QuiDinh qd){
//        String sql =  "UPDATE KHACHHANG SET ACTIVE = 0 WHERE MAKH = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
////            ps.setInt(1, kh.getMaKH());            
//            return ps.executeUpdate() > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    
    public boolean SuaThamSo(ThamSo ts){
        String sql = "UPDATE THAMSO SET GiaTri = ? WHERE MaTS = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, ts.getMaTS());
            ps.setString(1, ts.getGiaTri());
//            ps.setString(2, kh.getCCCD());
//            ps.setString(3, kh.getGioiTinh());
//            ps.setString(4, kh.getSDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Hello");
            System.out.println(e);
        }
        return false;
    }

//    public ArrayList<QuiDinh> getFilterListKhachHang(QuiDinh quidinhInput){
//        ArrayList<QuiDinh> list = new ArrayList<>();
//        String sql = "SELECT MAKH, TENKH, CCCD, GioiTinh, SDT, DOANHSO FROM KHACHHANG WHERE UPPER(TENKH) LIKE ? AND UPPER(CCCD) LIKE ? AND UPPER(SDT) LIKE ? AND UPPER(GIOITINH) LIKE ? AND ACTIVE = 1 ";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, "%"+ quidinhInput.getTenKH().toUpperCase()+"%");
//            ps.setString(2, "%" + quidinhInput.getCCCD().toUpperCase() + "%");
//            ps.setString(3, "%" + quidinhInput.getSDT().toUpperCase() + "%");
//            ps.setString(4, "%" + quidinhInput.getGioiTinh().toUpperCase() + "%");
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                QuiDinh qd = new QuiDinh();
//                qd.setMaQD(rs.getInt("MaKH"));
//                qd.setTenQD(rs.getString("TenKH"));
//                qd.setGiaTri(rs.getInt("CCCD"));
//                list.add(qd);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    
    public ArrayList<ThamSo> getListThamSo(){
        
        ArrayList<ThamSo> list = new ArrayList<>();
        String sql = "SELECT MATS, TENTS, GIATRI FROM THAMSO WHERE ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThamSo ts = new ThamSo();
                ts.setMaTS(rs.getString("MATS"));
                ts.setTenTS(rs.getString("TENTS"));
                ts.setGiaTri(rs.getString("GIATRI"));
                list.add(ts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ThamSo getThamSobyMaQD(String MaTS){
        ThamSo ts = new ThamSo();
        String sql = "SELECT MaTS, TenTS, GiaTri FROM THAMSO WHERE MaTS = ? AND ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, MaTS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ts.setMaTS(rs.getString("MaTS"));
                ts.setTenTS(rs.getString("TenTS"));
                ts.setGiaTri(rs.getString("GiaTri"));
                return ts;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}



