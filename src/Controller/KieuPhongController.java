/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
/**
 *
 * @author asus
 */
public class KieuPhongController {
    public boolean KtraJtextKieuPhong(JTextField MaLoaiPhg, JComboBox KieuGiuong, JTextField KieuPhong, JTextField GiaPhong){
        if(MaLoaiPhg.getText().equals("") || KieuGiuong.getSelectedItem().equals("") || KieuPhong.getText().equals("") || GiaPhong.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
            return false;
        }
        if(!isNumberOrNot(GiaPhong.getText())){
            JOptionPane.showMessageDialog(null, "Giá phòng phải là số. Vui lòng nhập lại.");
            return false;
        }
        if(!isNumberOrNot((String) KieuGiuong.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Kiểu giường phải là số. Vui lòng nhập lại.");
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
