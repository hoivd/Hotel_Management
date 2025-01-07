package DAO;

import Model.NhanVien;
import Model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class NhanVienDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public int getCurrentMaNV(){
        int result = -1;
        String sql = "SELECT MANV_SEQ.NEXTVAL AS VAL FROM DUAL ";
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
    public boolean ThemNhanVien(NhanVien nv){      
        String sql = "INSERT INTO NhanVien(TenNV, CCCD, NgaySinh, SDT, GioiTinh, NgayVL, ChucVu) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getCCCD());
            ps.setDate(3, new Date(nv.getNgaySinh().getTime()));
            ps.setString(4, nv.getSDT());           
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new Date(nv.getNgayVaoLam().getTime()));   
            ps.setString(7, nv.getChucVu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean SuaNhanVien(NhanVien nv){
        String sql = "UPDATE NHANVIEN SET TENNV = ?, CCCD = ?, NGAYSINH = ?, SDT = ?, GIOITINH = ?, NGAYVL = ?, CHUCVU = ? WHERE MANV = ?";
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setString(2, nv.getCCCD());
            ps.setDate(3, new Date(nv.getNgaySinh().getTime()));
            ps.setString(4, nv.getSDT());           
            ps.setString(5, nv.getGioiTinh());
            ps.setDate(6, new Date(nv.getNgayVaoLam().getTime()));   
            ps.setString(7, nv.getChucVu());
            ps.setInt(8, nv.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaNhanVien(int MaNV){
        String sql = "UPDATE NHANVIEN SET ACTIVE = 0 WHERE MaNV = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MaNV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<NhanVien> getListNhanVien(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT MANV, TENNV, CCCD, NGAYSINH, SDT, GIOITINH, NGAYVL, CHUCVU FROM NHANVIEN WHERE ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){           
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setSDT(rs.getString("SDT"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setNgayVaoLam(rs.getDate("NgayVL"));
                nv.setChucVu(rs.getString("ChucVu"));
                
                list.add(nv);                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<NhanVien> TimKiemNhanVien(NhanVien nv){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT MANV, TENNV, CCCD, NGAYSINH, SDT, GIOITINH, NGAYVL, CHUCVU FROM NHANVIEN WHERE UPPER(TENNV) LIKE ? "
                + "AND UPPER(CCCD) LIKE ? AND UPPER(SDT) LIKE ? AND ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nv.getTenNV().toUpperCase() + "%");
            ps.setString(2, "%" + nv.getCCCD().toUpperCase() + "%");
            ps.setString(3, "%" + nv.getSDT().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien data = new NhanVien();
                data.setMaNV(rs.getInt("MaNV"));
                data.setTenNV(rs.getString("TenNV"));
                data.setCCCD(rs.getString("CCCD"));
                data.setNgaySinh(rs.getDate("NgaySinh"));
                data.setSDT(rs.getString("SDT"));
                data.setGioiTinh(rs.getString("GioiTinh"));
                data.setNgayVaoLam(rs.getDate("NgayVL"));
                data.setChucVu(rs.getString("ChucVu"));
                list.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public NhanVien TimKiemNhanVienBangMaNV(int MaNV){
        NhanVien nv = new NhanVien();
        String sql = "SELECT TENNV, CCCD, CHUCVU FROM NHANVIEN WHERE MANV = ? AND ACTIVE = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MaNV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nv.setMaNV(MaNV);
                nv.setTenNV(rs.getString("TenNV"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setChucVu(rs.getString("ChucVu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
    
    public boolean DangKiTaiKhoan(User user){
        String sql = "INSERT INTO TAIKHOAN (TENTAIKHOAN, MANV, MATKHAU, QUYEN) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setInt(2, user.getMaNV());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XoaTK(int MaNV){
        String sql = "DELETE FROM TAIKHOAN WHERE MANV = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MaNV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean CheckTKNV(int MaNV){
        int i = 0;
        String sql = "SELECT * FROM TAIKHOAN WHERE MANV = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MaNV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                i++;
            }
            if(i > 0) return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
