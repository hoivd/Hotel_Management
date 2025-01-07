/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.KhachHang;
import Model.PhieuDatPhong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.sql.Types;
/**
 *
 * @author TNo1
 */
public class PhieuDatPhongDAO {
    Connection con = DataBaseConnection.getConnection();
    
    public int getCurrentMaDatPhong(){
        int result = -1;
        String sql = "SELECT MADATPHONG FROM PHIEUDATPHONG ORDER BY MADATPHONG DESC FETCH FIRST 1 ROW ONLY";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                result = rs.getInt("MADATPHONG");
                return result+1;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return result+1;
    }
    
    public boolean ThemPhieuDatPhong(PhieuDatPhong pdp){      
        String sql = "INSERT INTO PHIEUDATPHONG(MADATPHONG, MAKH, NGAYNHAN, NGAYTRA, TTNHANPHONG, MANV,  TIENTRATRUOC, PHUPHI) VALUES(?,?,?,?,0,1,?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pdp.getMaDatPhong());
            ps.setInt(2, pdp.getKhachHang().getMaKH());
            ps.setDate(3, new Date(pdp.getNgayNhan().getTime()));
            ps.setDate(4, new Date(pdp.getNgayTra().getTime()));
            ps.setInt(5, pdp.getTienTraTruoc());
            ps.setInt(6, pdp.getPhuPhi());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean ThemChiTietDatPhong(int MaDatPhong, ArrayList<String> ListMaPHG){
        for (String maPHG : ListMaPHG)
        {
            String sql = "INSERT INTO CHITIETDATPHONG(MADATPHONG, MAPHG) VALUES(?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, MaDatPhong);
                ps.setString(2, maPHG);
                if (ps.executeUpdate() <= 0){
                    return false;    
                }
            } catch (Exception e) {
                e.printStackTrace();        
            }            
        }
        return true;        
    }
    
    public boolean TaoPhieuDatPhong(PhieuDatPhong pdp, ArrayList<String> ListMaPHG) throws SQLException
    {
        Connection con = DataBaseConnection.getConnection();
        if (this.ThemPhieuDatPhong(pdp))
        {
            if (this.ThemChiTietDatPhong(pdp.getMaDatPhong(), ListMaPHG))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean XacNhanNhanPhong(int mapdp){      
        String sql = "CALL XacNhanNhanPhong(?)";
        try {
            CallableStatement cp = con.prepareCall(sql);
            cp.setInt(1, mapdp);
            return cp.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean XacNhanThanhToan(int mapdp){      
        String sql = "CALL XacNhanThanhToan(?)";
        try {
            CallableStatement cp = con.prepareCall(sql);
            cp.setInt(1, mapdp);
            return cp.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean HuyDatPhong(int mapdp){      
        String sql = "CALL HUYPHIEUDATPHONG(?)";
        try {
            CallableStatement cp = con.prepareCall(sql);
            cp.setInt(1, mapdp);
            return cp.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getTienThanhToan(int mapdp){      
        String sql = "{ CALL ? := get_TongTien_Thanhtoan(?)}";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.registerOutParameter(1, Types.NUMERIC);
            cs.setInt(2, mapdp);
            if (cs.executeUpdate() > 0)
            {
                return cs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<String> getDSPhongfromPhieuDatPhong(int mapdp)
    {
        String sql = "SELECT MAPHG FROM CHITIETDATPHONG WHERE MADATPHONG = ?";
        ArrayList<String> dsphong = new ArrayList<String>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mapdp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                dsphong.add(rs.getString("MAPHG"));
            }
            return dsphong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsphong;

    }
    
    public PhieuDatPhong getThongTinPhieuDatPhong(int mapdp)
    {
        String sql = "SELECT MADATPHONG, MAKH, NGAYDAT, NGAYNHAN, NGAYTRA, TIENPHONG, TIENTRATRUOC, TIENDV, PHUPHI FROM PHIEUDATPHONG WHERE MADATPHONG = ?";
        PhieuDatPhong pdp = new PhieuDatPhong();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mapdp);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pdp.setMaDatPhong(mapdp);
                KhachHang k = new KhachHangDAO().getKhachHangByMaKH(rs.getInt("MAKH"));
                pdp.setKhachHang(k);
                pdp.setNgayDat(new Date(rs.getDate("NGAYDAT").getTime()));
                pdp.setNgayNhan(new Date(rs.getDate("NGAYNHAN").getTime()));
                pdp.setNgayTra(new Date(rs.getDate("NGAYTRA").getTime()));
                pdp.setDSPhong(this.getDSPhongfromPhieuDatPhong(mapdp));
                pdp.setTienPhong(rs.getInt("TIENPHONG"));
                pdp.setTienTraTruoc(rs.getInt("TIENTRATRUOC"));
                pdp.setTienDV(rs.getInt("TIENDV"));
                pdp.setPhuPhi(rs.getInt("PHUPHI"));
                pdp.setTienThanhToan(this.getTienThanhToan(mapdp));
            }
            return pdp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdp;

    }
    
    public int getMaDatPhongFromMaPHG(String maphg)
    {
        String sql = "SELECT PHIEUDATPHONG.MADATPHONG AS MDP FROM PHIEUDATPHONG, CHITIETDATPHONG WHERE TTNHANPHONG = 1 AND PHIEUDATPHONG.MADATPHONG = CHITIETDATPHONG.MADATPHONG AND MAPHG = ?";
        ArrayList<String> dsphong = new ArrayList<String>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,maphg);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("MDP");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
