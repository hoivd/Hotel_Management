package DAO;

import Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class KhachHangDAO {
    Connection con = DataBaseConnection.getConnection();
    public int getCurrentMaKH(){
        int result = -1;
        String sql = "SELECT MAKH_SEQ.NEXTVAL AS VAL FROM DUAL ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                result = rs.getInt("VAL");
                return result;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    public boolean ThemKhachHang(KhachHang kh){       
        String sql = "INSERT INTO KHACHHANG(TenKH, CCCD, GioiTinh, SDT, MALOAIKHACH) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, kh.getMaKH());
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getCCCD());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSDT());
            ps.setString(5, kh.getLoaiKhach());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaKhachHang(KhachHang kh){
        String sql =  "UPDATE KHACHHANG SET ACTIVE = 0 WHERE MAKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, kh.getMaKH());            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaKhachHang(KhachHang kh){
        String sql = "UPDATE KHACHHANG SET TenKH = ?, CCCD = ?, GioiTinh = ?, SDT = ?, MALOAIKHACH = ? WHERE MaKH = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(6, kh.getMaKH());
            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getCCCD());
            ps.setString(3, kh.getGioiTinh());
            ps.setString(4, kh.getSDT());
            ps.setString(5, kh.getLoaiKhach());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<KhachHang> getFilterListKhachHang(KhachHang khachhangInput){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MAKH, TENKH, CCCD, GIOITINH, SDT, DOANHSO, TENLOAIKHACH\n" +
                    "FROM KHACHHANG\n" +
                    "INNER JOIN LOAIKHACH ON KHACHHANG.MALOAIKHACH = LOAIKHACH.MALOAIKHACH\n" +
                    "WHERE UPPER(TENKH) LIKE ? AND UPPER(CCCD) LIKE ? AND UPPER(SDT) LIKE ? AND UPPER(GIOITINH) LIKE ? AND UPPER(KHACHHANG.MALOAIKHACH) LIKE ? AND ACTIVE = 1 ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(khachhangInput.getTenKH());
            System.out.println(khachhangInput.getCCCD());
            System.out.println(khachhangInput.getSDT());
            System.out.println(khachhangInput.getGioiTinh());
            System.out.println(khachhangInput.getLoaiKhach());
            
            ps.setString(1, "%"+ khachhangInput.getTenKH().toUpperCase()+"%");
            ps.setString(2, "%" + khachhangInput.getCCCD().toUpperCase() + "%");
            ps.setString(3, "%" + khachhangInput.getSDT().toUpperCase() + "%");
            ps.setString(4, "%" + khachhangInput.getGioiTinh().toUpperCase() + "%");
            ps.setString(5, "%" + khachhangInput.getLoaiKhach().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MAKH"));
                kh.setTenKH(rs.getString("TENKH"));
                kh.setCCCD(rs.getString("CCCD"));
                kh.setGioiTinh(rs.getString("GIOITINH"));
                kh.setSDT(rs.getString("SDT"));
                kh.setLoaiKhach(rs.getString("TENLOAIKHACH"));
                kh.setDoanhSo(rs.getInt("DOANHSO"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MAKH, TENKH, CCCD, GIOITINH, SDT, DOANHSO, TENLOAIKHACH\n" +
                    "FROM KHACHHANG\n" +
                    "INNER JOIN LOAIKHACH ON KHACHHANG.MALOAIKHACH = LOAIKHACH.MALOAIKHACH\n" +
                    "WHERE ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setCCCD(rs.getString("CCCD"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setSDT(rs.getString("SDT"));
                kh.setDoanhSo(rs.getInt("DoanhSo"));
                kh.setLoaiKhach(rs.getString("TENLOAIKHACH"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public KhachHang getKhachHangByMaKH(int MAKH){
        String sql = "SELECT MAKH, TENKH, CCCD, GioiTinh, SDT, DoanhSo FROM KHACHHANG WHERE MAKH = ? AND ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MAKH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setCCCD(rs.getString("CCCD"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setSDT(rs.getString("SDT"));
                kh.setDoanhSo(rs.getInt("DoanhSo"));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
