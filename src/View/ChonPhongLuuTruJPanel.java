/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.PhieuDatPhongDAO;
import DAO.ThongTinPhongDAO;
import java.util.ArrayList;
import Model.ThongTinPhong;

/**
 *
 * @author TNo1
 */
public class ChonPhongLuuTruJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChonPhongLuuTruJPanel
     */
    ArrayList<ThongTinPhong> dsphong;
    public ChonPhongLuuTruJPanel() {
        initComponents();
        dsphong = new ThongTinPhongDAO().getListPhongDangSD();
        for (ThongTinPhong p : dsphong)
        {
            jComboBox_DSPhong.addItem(p.getMaPhg());
        }
        
    }
    public int getMaDatPhong()
    {   
        int madp = 0;
        
        return madp;
    }
    public int returnMaDatPhong()
    {
        return new PhieuDatPhongDAO().getMaDatPhongFromMaPHG(jComboBox_DSPhong.getSelectedItem().toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox_DSPhong = new javax.swing.JComboBox<>();

        jLabel1.setText("Chọn phòng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jComboBox_DSPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_DSPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox_DSPhong;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
