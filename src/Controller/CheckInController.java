/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRTextField;

/**
 *
 * @author asus
 */
public class CheckInController {
    public boolean KtraTextCheckIn(JTextField MaDatPhong, JTextField TenKhachHang, JTextField CCCD,
        JTextField SDT, JDateChooser NgayDat, JDateChooser NgayNhan, JDateChooser NgayTra){
        if(MaDatPhong.getText().equals("") || TenKhachHang.getText().equals("") || CCCD.getText().equals("") || SDT.getText().equals("")
                || NgayDat.getDate() == null || NgayNhan.getDate() == null || NgayTra.getDate() == null){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
            return false;
        }
        if(!isNumberOrNot(SDT.getText())){
            JOptionPane.showMessageDialog(null, "Số điện thoại phải là số. Vui lòng nhập lại.");
            return false;
        }
        if(!isNumberOrNot(CCCD.getText())){
            JOptionPane.showMessageDialog(null, "CCCD phải là số. Vui lòng nhập lại.");
            return false;
        }
        return true;
    }
    private boolean isNumberOrNot(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
