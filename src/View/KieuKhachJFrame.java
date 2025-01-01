/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.KieuKhachController;
import DAO.KieuKhachDAO;
import Model.KieuKhach;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
/**
 *
 * @author asus
 */
public class KieuKhachJFrame extends javax.swing.JFrame {
    private ArrayList<KieuKhach> listKieuKhach;
    
    DefaultTableModel tblKieuKhach;
    /**
     * Creates new form KieuPhongJFrame
     */
    public KieuKhachJFrame() {
        JFrameCenterOfScreen();
        initComponents();
        listKieuKhach = new KieuKhachDAO().getListKieuKhach();
        tblKieuKhach = (DefaultTableModel) Table_KieuKhach.getModel();
        tblKieuKhach.setColumnIdentifiers(new Object[]{"STT","Mã loại phòng", "Kiểu phòng"});
        showTableChiTietDV();
        Button_SuaKieuKhach.setEnabled(false);
        Button_XoaKieuKhach.setEnabled(false);
    }
    public int getRowTableKieuPhong(){
        return Table_KieuKhach.getRowCount();
    }
    public void JFrameCenterOfScreen(){
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/4, size.height/4 - getHeight()/2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Text_LoaiKhach = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        Button_ThemKieuKhach = new javax.swing.JButton();
        Button_SuaKieuKhach = new javax.swing.JButton();
        Button_LamMoi = new javax.swing.JButton();
        Button_XoaKieuKhach = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Text_MaLoaiKhach = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_KieuKhach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý kiểu phòng khách sạn");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Loại Khách");

        Text_LoaiKhach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Button_ThemKieuKhach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemKieuKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Add_Icon.png"))); // NOI18N
        Button_ThemKieuKhach.setText("Thêm");
        Button_ThemKieuKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemKieuKhachActionPerformed(evt);
            }
        });

        Button_SuaKieuKhach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaKieuKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Fix_Icon.png"))); // NOI18N
        Button_SuaKieuKhach.setText("Sửa");
        Button_SuaKieuKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaKieuKhachActionPerformed(evt);
            }
        });

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        Button_XoaKieuKhach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaKieuKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Delete_Icon.png"))); // NOI18N
        Button_XoaKieuKhach.setText("Xóa");
        Button_XoaKieuKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaKieuKhachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Button_SuaKieuKhach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_ThemKieuKhach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaKieuKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemKieuKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_SuaKieuKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaKieuKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã loại khách");

        Text_MaLoaiKhach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Text_MaLoaiKhach, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(Text_LoaiKhach))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Text_MaLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Text_LoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        Table_KieuKhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại khách", "Loại khách"
            }
        ));
        Table_KieuKhach.setShowHorizontalLines(true);
        Table_KieuKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_KieuKhachMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Table_KieuKhach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void showTableChiTietDV(){
        int i = 1;
        ArrayList<KieuKhach> listKieuKhach = new KieuKhachDAO().getListKieuKhach();
        for(KieuKhach KK : listKieuKhach){
            tblKieuKhach.addRow(new Object[]{i++, KK.getMaLoaiKhach(), KK.getLoaiKhach()});
        }
    }
    
    public void updateTable(){
        tblKieuKhach.setRowCount(0);
        this.showTableChiTietDV();
    }
    
    private void Button_ThemKieuKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemKieuKhachActionPerformed
        if(new KieuKhachController().KtraJtextKieuKhach(Text_MaLoaiKhach, Text_LoaiKhach)){
            KieuKhach KK = new KieuKhach();
            KK.setMaLoaiKhach(Text_MaLoaiKhach.getText());
            KK.setLoaiKhach(Text_LoaiKhach.getText());
            if(new KieuKhachDAO().ThemKieuKhach(KK)){
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                listKieuKhach.add(KK);
                updateTable();
                clearJTextKieuPhong();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm không thành công");               
            }
        }
    }//GEN-LAST:event_Button_ThemKieuKhachActionPerformed

    public KieuKhach returnTTKieuKhach(int index){
        String MaLoaiKhach = tblKieuKhach.getValueAt(index, 1).toString();
        String LoaiKhach = tblKieuKhach.getValueAt(index, 2).toString();
        return new KieuKhach(MaLoaiKhach,LoaiKhach);
    }
    
    private void Button_SuaKieuKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaKieuKhachActionPerformed

        if(new KieuKhachController().KtraJtextKieuKhach(Text_MaLoaiKhach, Text_LoaiKhach)){
            int indexTB = Table_KieuKhach.getSelectedRow();
            KieuKhach KKCu = returnTTKieuKhach(indexTB);
            int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn sửa dữ liệu?", "Sữa dữ liệu", JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION){
                KieuKhach KKMoi = new KieuKhach(Text_MaLoaiKhach.getText(),Text_LoaiKhach.getText());
                if(indexTB < tblKieuKhach.getRowCount() && indexTB >= 0){
                    if(new KieuKhachDAO().SuaKieuKhach(KKCu, KKMoi)){   
                        tblKieuKhach.setValueAt(Text_MaLoaiKhach, indexTB, 1);
                        tblKieuKhach.setValueAt(Text_LoaiKhach, indexTB, 2);                     
                        JOptionPane.showMessageDialog(this, "Sửa thành công.");
                        updateTable();
                        clearJTextKieuPhong();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại.");
                    }
                }         
            }
        }
    }//GEN-LAST:event_Button_SuaKieuKhachActionPerformed

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        Button_ThemKieuKhach.setEnabled(true);
        Button_SuaKieuKhach.setEnabled(false);
        Button_XoaKieuKhach.setEnabled(false);
        updateTable();
        clearJTextKieuPhong();
    }//GEN-LAST:event_Button_LamMoiActionPerformed

    public void clearJTextKieuPhong(){
        Text_MaLoaiKhach.setText("");
        Text_LoaiKhach.setText("");
    }
    
    private void Button_XoaKieuKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaKieuKhachActionPerformed
        int indexTB = Table_KieuKhach.getSelectedRow();
        KieuKhach KK = returnTTKieuKhach(indexTB);
        int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tblKieuKhach.getRowCount() && indexTB >= 0){
                if(new KieuKhachDAO().XoaKieuKhach(KK)){
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tblKieuKhach.removeRow(indexTB);
                    clearJTextKieuPhong();
                } else { JOptionPane.showMessageDialog(this, "Xóa thất bại.");}
            }
        }
    }//GEN-LAST:event_Button_XoaKieuKhachActionPerformed

    private void Table_KieuKhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_KieuKhachMouseClicked
        ListSelectionModel listTable_KieuKhach = Table_KieuKhach.getSelectionModel();
        listTable_KieuKhach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Button_ThemKieuKhach.setEnabled(false);
        Button_XoaKieuKhach.setEnabled(true);
        Button_SuaKieuKhach.setEnabled(true);
        int indexTB = Table_KieuKhach.getSelectedRow();
        if (indexTB < tblKieuKhach.getRowCount() && indexTB >= 0){
            Text_MaLoaiKhach.setText(tblKieuKhach.getValueAt(indexTB, 1).toString());
            Text_LoaiKhach.setText(tblKieuKhach.getValueAt(indexTB, 2).toString());
        }
    }//GEN-LAST:event_Table_KieuKhachMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KieuPhongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new KieuPhongJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_SuaKieuKhach;
    private javax.swing.JButton Button_ThemKieuKhach;
    private javax.swing.JButton Button_XoaKieuKhach;
    private javax.swing.JTable Table_KieuKhach;
    private javax.swing.JTextField Text_LoaiKhach;
    private javax.swing.JTextField Text_MaLoaiKhach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
