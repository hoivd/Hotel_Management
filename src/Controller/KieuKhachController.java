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
public class KieuKhachController {
    public boolean KtraJtextKieuKhach(JTextField MaLoaiKhach, JTextField KieuKhach){
        if(MaLoaiKhach.getText().equals("") || KieuKhach.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
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
