/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class NhanVienController {
    public boolean KtraJTextNhanVien(JTextField HoTen, JTextField CCCD, JDateChooser NgaySinh, JTextField SDT, JDateChooser NgayVaoLam){
        if(HoTen.getText().equals("") || CCCD.getText().equals("") || NgaySinh.getDate() == null || SDT.getText().equals("") || NgayVaoLam.getDate() == null){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
            return false;
        }
        if(!isNumberOrNot(CCCD.getText())){
            JOptionPane.showMessageDialog(null, "CMND/CCCD phải là số. Vui lòng nhập lại.");
            return false;
        }
        if(!isNumberOrNot(SDT.getText())){
            JOptionPane.showMessageDialog(null, "Số điện thoại phải là số. Vui lòng nhập lại.");
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
