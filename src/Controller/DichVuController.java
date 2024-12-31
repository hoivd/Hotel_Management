/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class DichVuController {
    public boolean KtraJtextDichVu(JTextField TenDV, JTextField DonGia){
        if(TenDV.getText().equals("") || DonGia.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin.");
            return false;
        }
        if(!isNumberOrNot(DonGia.getText())){
            JOptionPane.showMessageDialog(null, "Đơn giá phải là số. Vui lòng nhập lại.");
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
