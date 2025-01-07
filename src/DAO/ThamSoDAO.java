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
    
    public boolean SuaThamSo(ThamSo ts){
        String sql = "UPDATE THAMSO SET GiaTri = ? WHERE MaTS = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, ts.getMaTS());
            ps.setString(1, ts.getGiaTri());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Hello");
            System.out.println(e);
        }
        return false;
    }
    
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



