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
public class ThamSoController {
    public boolean KtraJtextThamSo(JTextField GiaTri){
        if(GiaTri.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
            return false;
        }
//        if(!isWordOrNot(Hoten.getText())){
//            JOptionPane.showMessageDialog(null, "Họ tên không hợp lệ. Tên không chứa số hoặc kí tự.");
//            return false;
//        }
        if(!isNumberOrNot(GiaTri.getText())){
            JOptionPane.showMessageDialog(null, "Giá trị phải là số vui lòng nhập lại");
            return false;
        }
        return true;
    }
    
    private boolean isNumberOrNot(String input) {
//        try {
//            Long.parseLong(input);
//        } catch (NumberFormatException e) {
//            return false;
//        }
//        return true;
        return input.matches("-?\\d+(\\.\\d+)?");
    }
    
//    private boolean isWordOrNot(String input){
//        return Pattern.matches("[a-zA-Z]+ ", input);
//    }
        
}