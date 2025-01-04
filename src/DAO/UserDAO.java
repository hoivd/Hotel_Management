/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author TNo1
 */
public class UserDAO {
    Connection conn;
    public UserDAO(){
        conn =DataBaseConnection.getConnection();
    }
    public User validateUser(User user){
        try{
            String sql = "SElECT TENTAIKHOAN, MATKHAU, QUYEN, MANV FROM TAIKHOAN WHERE TENTAIKHOAN = ? AND MATKHAU = ?";
            try{
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    User returnUser = new User();
                    returnUser.setUsername(rs.getString("TENTAIKHOAN"));
                    returnUser.setPassword(rs.getString("MATKHAU"));
                    returnUser.setRole(rs.getString("QUYEN"));
                    returnUser.setMaNV(rs.getInt("MANV"));
                    
                    return returnUser;
                }
                else return null;
            }
            catch(Exception event){
                event.printStackTrace();
            }
            conn.close();
            return null;

        }
        catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
