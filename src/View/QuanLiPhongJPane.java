    package View;

import Controller.TTPhongController;
import DAO.ThongTinPhongDAO;
import Model.ThongTinPhong;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author asus
 */
public class QuanLiPhongJPane extends javax.swing.JPanel {
    private ArrayList<ThongTinPhong> listChiTietTTPhong;
    DefaultTableModel tblChiTietTTPhong;
    Date date = new Date();

    public JTextField getText_MaPhong() {
        return Text_MaPhong;
    }

    public void setText_MaPhong(JTextField Text_MaPhong) {
        this.Text_MaPhong = Text_MaPhong;
    }
   
    public QuanLiPhongJPane() {      
        initComponents();   
        Table_ChiTietTTPhong.setShowGrid(true);
        Table_ChiTietTTPhong.setShowHorizontalLines(true);
        listChiTietTTPhong = new ThongTinPhongDAO().getListChiTietTTPhong();
        tblChiTietTTPhong = (DefaultTableModel) Table_ChiTietTTPhong.getModel();
        tblChiTietTTPhong.setColumnIdentifiers(new Object[]{"STT","Mã phòng", "Kiểu phòng", "Kiểu giường", "Giá phòng", "MoTa"});
        showTableChiTietTTPhong();
        showComboBox_KieuPhong();
        showText_GiaPhong(ComboBox_KieuPhong.getSelectedItem().toString(), Integer.parseInt(ComboBox_KieuGiuong.getSelectedItem().toString()));
        Button_SuaCTTTPhong.setEnabled(false);
        Button_XoaCTTTPhong.setEnabled(false);
        Table_ChiTietTTPhong.setDefaultEditor(Object.class, null);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Text_MaPhong = new javax.swing.JTextField();
        Text_GiaPhong = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        Button_ThemCTTTPhong = new javax.swing.JButton();
        Button_SuaCTTTPhong = new javax.swing.JButton();
        Button_LamMoi = new javax.swing.JButton();
        Button_XoaCTTTPhong = new javax.swing.JButton();
        Button_QuanLiKieuPhong = new javax.swing.JButton();
        ComboBox_KieuPhong = new javax.swing.JComboBox<>();
        ComboBox_KieuGiuong = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Text_MoTa = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_ChiTietTTPhong = new javax.swing.JTable();

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel6.setForeground(new java.awt.Color(153, 153, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã phòng");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Kiểu phòng");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Kiểu giường");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Giá phòng");

        Text_MaPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_GiaPhong.setEditable(false);
        Text_GiaPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Button_ThemCTTTPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemCTTTPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Add_Icon.png"))); // NOI18N
        Button_ThemCTTTPhong.setText("Thêm");
        Button_ThemCTTTPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemCTTTPhongActionPerformed(evt);
            }
        });

        Button_SuaCTTTPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaCTTTPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Fix_Icon.png"))); // NOI18N
        Button_SuaCTTTPhong.setText("Sửa");
        Button_SuaCTTTPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaCTTTPhongActionPerformed(evt);
            }
        });

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        Button_XoaCTTTPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaCTTTPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Delete_Icon.png"))); // NOI18N
        Button_XoaCTTTPhong.setText("Xóa");
        Button_XoaCTTTPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaCTTTPhongActionPerformed(evt);
            }
        });

        Button_QuanLiKieuPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Button_QuanLiKieuPhong.setText("Quản lý kiểu phòng");
        Button_QuanLiKieuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_QuanLiKieuPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_QuanLiKieuPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Button_SuaCTTTPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_ThemCTTTPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_XoaCTTTPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemCTTTPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_SuaCTTTPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaCTTTPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_QuanLiKieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        ComboBox_KieuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_KieuPhongActionPerformed(evt);
            }
        });

        ComboBox_KieuGiuong.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ComboBox_KieuGiuongPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        Text_MoTa.setColumns(20);
        Text_MoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text_MoTa.setRows(5);
        jScrollPane4.setViewportView(Text_MoTa);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Mô tả");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_GiaPhong)
                                    .addComponent(ComboBox_KieuPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboBox_KieuGiuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(Text_MaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(126, 126, 126))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Text_MaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ComboBox_KieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(ComboBox_KieuGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Text_GiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        Table_ChiTietTTPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phòng", "Loại phòng", "Loại giường", "Giá phòng"
            }
        ));
        Table_ChiTietTTPhong.setShowHorizontalLines(true);
        Table_ChiTietTTPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ChiTietTTPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_ChiTietTTPhong);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void showTableChiTietTTPhong(){
        int i = 1;
        listChiTietTTPhong = new ThongTinPhongDAO().getListChiTietTTPhong();
        for(ThongTinPhong ttPhong : listChiTietTTPhong){
            tblChiTietTTPhong.addRow(new Object[]{i++, ttPhong.getMaPhg(), ttPhong.getKieuPhong(), ttPhong.getKieuGiuong(), 
                ttPhong.getDonGia(), ttPhong.getMoTa()});          
        }
    }
    
    public void updateTable(){
        tblChiTietTTPhong.setRowCount(0);
        this.showTableChiTietTTPhong();       
    }
    
    private void Button_ThemCTTTPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemCTTTPhongActionPerformed
        if(new TTPhongController().KtraText_MaPhong(Text_MaPhong)){
            ThongTinPhong ttPhong = new ThongTinPhong();
            ttPhong.setMaPhg(Text_MaPhong.getText());
            ttPhong.setKieuPhong(ComboBox_KieuPhong.getSelectedItem().toString());
            ttPhong.setKieuGiuong(Integer.parseInt(ComboBox_KieuGiuong.getSelectedItem().toString()));
            ttPhong.setMoTa(Text_MoTa.getText());
            //ttPhong.setDonGia(Integer.parseInt(Text_GiaPhong.getText()));
            if(new ThongTinPhongDAO().ThemChiTietTTPhong(ttPhong)){
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                listChiTietTTPhong.add(ttPhong);
                //showResult();
                updateTable();
            }
        }
    }//GEN-LAST:event_Button_ThemCTTTPhongActionPerformed

    private void Table_ChiTietTTPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ChiTietTTPhongMouseClicked
        ListSelectionModel listTable_CTTTPhong = Table_ChiTietTTPhong.getSelectionModel();
        listTable_CTTTPhong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        Button_ThemCTTTPhong.setEnabled(false);
        Button_XoaCTTTPhong.setEnabled(true);
        Button_SuaCTTTPhong.setEnabled(true);
        
        int indexTB = Table_ChiTietTTPhong.getSelectedRow();
        if(indexTB < tblChiTietTTPhong.getRowCount() && indexTB >=0 ){
            Text_MaPhong.setText(tblChiTietTTPhong.getValueAt(indexTB, 1).toString());
            ComboBox_KieuPhong.setSelectedItem(tblChiTietTTPhong.getValueAt(indexTB, 2));
            ComboBox_KieuGiuong.setSelectedItem(tblChiTietTTPhong.getValueAt(indexTB, 3).toString());
            Text_GiaPhong.setText(tblChiTietTTPhong.getValueAt(indexTB, 4).toString());
            if(tblChiTietTTPhong.getValueAt(indexTB, 5) == null){
                Text_MoTa.setText("");
            }else{
                Text_MoTa.setText(tblChiTietTTPhong.getValueAt(indexTB, 5).toString());
            }
            
        }
    }//GEN-LAST:event_Table_ChiTietTTPhongMouseClicked
    
    public ThongTinPhong returnTTPhong(int index){
        String MaPhong = tblChiTietTTPhong.getValueAt(index, 1).toString();
        String KieuPhong = tblChiTietTTPhong.getValueAt(index, 2).toString();
        int KieuGiuong = (int) tblChiTietTTPhong.getValueAt(index, 3);
        int DonGia = (int) tblChiTietTTPhong.getValueAt(index, 4);
        String MoTa;
        if(tblChiTietTTPhong.getValueAt(index, 5) == null){
            MoTa = "";
        }else{
            MoTa = tblChiTietTTPhong.getValueAt(index, 5).toString();
        }
        return new ThongTinPhong(MaPhong, KieuPhong, KieuGiuong, DonGia, MoTa);
    }
    
    private void Button_XoaCTTTPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaCTTTPhongActionPerformed
        int indexTB = Table_ChiTietTTPhong.getSelectedRow();
        ThongTinPhong ttPhong = returnTTPhong(indexTB);
        int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tblChiTietTTPhong.getRowCount() && indexTB >= 0){
                if (new ThongTinPhongDAO().XoaChiTietTTPhong(ttPhong)){
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tblChiTietTTPhong.removeRow(indexTB);
                    clearJTextChiTietTTPhong();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại.");
                }
            }
        }
    }//GEN-LAST:event_Button_XoaCTTTPhongActionPerformed

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        Button_ThemCTTTPhong.setEnabled(true);
        Button_SuaCTTTPhong.setEnabled(false);
        Button_XoaCTTTPhong.setEnabled(false);
        updateTable();
        clearJTextChiTietTTPhong();
//        ComboBox_KieuPhong.removeAllItems();
//        showComboBox_KieuPhong();
        showText_GiaPhong(ComboBox_KieuPhong.getSelectedItem().toString(), Integer.parseInt(ComboBox_KieuGiuong.getSelectedItem().toString()));
    }//GEN-LAST:event_Button_LamMoiActionPerformed

    private void Button_SuaCTTTPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaCTTTPhongActionPerformed
        if(new TTPhongController().KtraText_MaPhong(Text_MaPhong)){
            int indexTB = Table_ChiTietTTPhong.getSelectedRow();
            ThongTinPhong ttPhongCu = returnTTPhong(indexTB); 
            int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa dữ liệu?", "Sửa dữ liệu", JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION){
                ThongTinPhong ttPhongMoi = new ThongTinPhong(Text_MaPhong.getText(),ComboBox_KieuPhong.getSelectedItem().toString(),
                                                                        Integer.parseInt(ComboBox_KieuGiuong.getSelectedItem().toString()),
                                                                        Integer.parseInt(Text_GiaPhong.getText()), Text_MoTa.getText());
                if (new ThongTinPhongDAO().SuaChiTietTTPhong(ttPhongMoi, ttPhongCu)) {
                    if(indexTB < tblChiTietTTPhong.getRowCount() && indexTB >= 0){
                        tblChiTietTTPhong.setValueAt(Text_MaPhong.getText(), indexTB, 1);
                        tblChiTietTTPhong.setValueAt(ComboBox_KieuPhong.getSelectedItem(), indexTB, 2);
                        tblChiTietTTPhong.setValueAt(ComboBox_KieuGiuong.getSelectedItem(), indexTB, 3);
                        tblChiTietTTPhong.setValueAt(Text_GiaPhong.getText(), indexTB, 4);
                        tblChiTietTTPhong.setValueAt(Text_MoTa.getText(), indexTB, 5);
                        JOptionPane.showMessageDialog(this, "Sửa thành công.");
                        updateTable();
                        clearJTextChiTietTTPhong();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại.");
                    }
                }  
            }
        }
    }//GEN-LAST:event_Button_SuaCTTTPhongActionPerformed

    private void Button_QuanLiKieuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_QuanLiKieuPhongActionPerformed
        KieuPhongJFrame kieuphong = new KieuPhongJFrame();
        kieuphong.setVisible(true);
    }//GEN-LAST:event_Button_QuanLiKieuPhongActionPerformed

    private void ComboBox_KieuGiuongPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboBox_KieuGiuongPopupMenuWillBecomeInvisible
        showText_GiaPhong(ComboBox_KieuPhong.getSelectedItem().toString(), Integer.parseInt(ComboBox_KieuGiuong.getSelectedItem().toString()));
    }//GEN-LAST:event_ComboBox_KieuGiuongPopupMenuWillBecomeInvisible

    private void ComboBox_KieuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_KieuPhongActionPerformed
        ComboBox_KieuGiuong.removeAllItems();
        showComboBox_KieuGiuong(ComboBox_KieuPhong.getSelectedItem().toString());
        showText_GiaPhong(ComboBox_KieuPhong.getSelectedItem().toString(), Integer.parseInt(ComboBox_KieuGiuong.getSelectedItem().toString()));
    }//GEN-LAST:event_ComboBox_KieuPhongActionPerformed
    
    public void showComboBox_KieuPhong(){
        ArrayList<ThongTinPhong> ttKieuPhong = new ThongTinPhongDAO().getKieuPhong();
        for(ThongTinPhong data : ttKieuPhong){
            ComboBox_KieuPhong.addItem(data.getKieuPhong());
        }
    }
    
    public void showComboBox_KieuGiuong(String kieuphong){
        ArrayList<ThongTinPhong> ttKieuGiuong = new ThongTinPhongDAO().getKieuGiuong(ComboBox_KieuPhong.getSelectedItem().toString());
        for(ThongTinPhong data : ttKieuGiuong){
            ComboBox_KieuGiuong.addItem(String.valueOf(data.getKieuGiuong()));
        }
    }
    
    public void showText_GiaPhong(String KP, int KG){        
        int temp = new ThongTinPhongDAO().GiaPhong(KP, KG);
        Text_GiaPhong.setText(String.valueOf(temp));
    }
    
    public void clearJTextChiTietTTPhong(){
        Text_MaPhong.setText("");
        ComboBox_KieuPhong.setSelectedItem("Standard");
        ComboBox_KieuGiuong.setSelectedItem("1");
        Text_GiaPhong.setText("");
        Text_MoTa.setText("");
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_QuanLiKieuPhong;
    private javax.swing.JButton Button_SuaCTTTPhong;
    private javax.swing.JButton Button_ThemCTTTPhong;
    private javax.swing.JButton Button_XoaCTTTPhong;
    private javax.swing.JComboBox<String> ComboBox_KieuGiuong;
    private javax.swing.JComboBox<String> ComboBox_KieuPhong;
    private javax.swing.JTable Table_ChiTietTTPhong;
    private javax.swing.JTextField Text_GiaPhong;
    private javax.swing.JTextField Text_MaPhong;
    private javax.swing.JTextArea Text_MoTa;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}