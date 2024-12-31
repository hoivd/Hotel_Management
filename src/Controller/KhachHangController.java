/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class KhachHangController {
    public boolean KtraJtextKhachHang(JTextField Hoten, JTextField CCCD, JTextField SDT){
        if(Hoten.getText().equals("") || CCCD.getText().equals("") || SDT.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
            return false;
        }
//        if(!isWordOrNot(Hoten.getText())){
//            JOptionPane.showMessageDialog(null, "Họ tên không hợp lệ. Tên không chứa số hoặc kí tự.");
//            return false;
//        }
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
    
//    private boolean isWordOrNot(String input){
//        return Pattern.matches("[a-zA-Z]+ ", input);
//    }
        
}
