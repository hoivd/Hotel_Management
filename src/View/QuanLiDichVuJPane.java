/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LoginController;

import Controller.DichVuController;
import DAO.ThongTinPhongDAO;
import DAO.DanhMucDichVuDAO;
import DAO.DataBaseConnection;
import DAO.HoaDonDichVuDAO;
import Model.ThongTinPhong;
import Model.DanhMucDichVu;
import Model.HoaDonDichVu;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author asus
 */
public class QuanLiDichVuJPane extends javax.swing.JPanel {
    private ArrayList<DanhMucDichVu> listDichVu;
    private HashMap<String,DanhMucDichVu> dsDichVu;
    private ArrayList<HoaDonDichVu> listDVPhong;
    DefaultTableModel tblDichVu, tbleDichVuPhong;
    Date date = new Date();

    
    public QuanLiDichVuJPane() {
        initComponents();
        
        dsDichVu = new HashMap<String,DanhMucDichVu>();
        
        
        listDichVu = new DanhMucDichVuDAO().getListTTDichVu();
        tblDichVu = (DefaultTableModel) Table_DichVu.getModel();
        tblDichVu.setColumnIdentifiers(new Object[]{"STT","Mã dịch vụ", "Tên dịch vụ", "Đơn giá"});
        tbleDichVuPhong = (DefaultTableModel) Table_DichVuPhong.getModel();
        tbleDichVuPhong.setColumnIdentifiers(new Object[]{"STT", "Tên DV", "Ngày SD", "Số lượng", "Đơn giá", "Thành tiền"});
        
        
        showTableChiTietDV();
        showComboBox_MaPhg();
        showComboBox_TenDV();
        Button_XoaDichVu.setEnabled(false);
        Button_SuaDichVu.setEnabled(false);

        getDonGiaDV();
        Table_DichVu.setDefaultEditor(Object.class, null);
        Table_DichVuPhong.setDefaultEditor(Object.class, null);
    }
    
    public void getDonGiaDV(){
        int Gia = new DanhMucDichVuDAO().getGiaDV(ComboBox_TenDV.getSelectedItem().toString());
        Text_ThanhTien.setText(String.valueOf((int) Spinner_SoLuong.getValue() * Gia));
    }
    
    public void showTableChiTietDV(){
        int i = 1;
        ArrayList<DanhMucDichVu> listDichVu = new DanhMucDichVuDAO().getListTTDichVu();
        for(DanhMucDichVu DichVu : listDichVu){
            tblDichVu.addRow(new Object[]{i++, DichVu.getMaDV(), DichVu.getTenDV(), DichVu.getDonGia()});
            dsDichVu.put(DichVu.getTenDV(), DichVu);
        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Text_MaDV = new javax.swing.JTextField();
        Text_TenDV = new javax.swing.JTextField();
        Text_DonGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_DichVu = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        Button_ThemDichVu = new javax.swing.JButton();
        Button_XoaDichVu = new javax.swing.JButton();
        Button_SuaDichVu = new javax.swing.JButton();
        Button_LamMoi = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Spinner_SoLuong = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_DichVuPhong = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ComboBox_TenDV = new javax.swing.JComboBox<>();
        ComboBox_MaPhg = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        Button_ThemDVPhong = new javax.swing.JButton();
        Button_XoaDVPhong = new javax.swing.JButton();
        Button_InHoaDon = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        Text_ThanhTien = new javax.swing.JTextField();
        JDateChooser_NgaySuDung = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên dịch vụ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mã dịch vụ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Đơn giá");

        Text_MaDV.setEditable(false);
        Text_MaDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_TenDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_DonGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Table_DichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Đơn giá"
            }
        ));
        Table_DichVu.setShowHorizontalLines(true);
        Table_DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_DichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_DichVu);

        Button_ThemDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Add_Icon.png"))); // NOI18N
        Button_ThemDichVu.setText("Thêm");
        Button_ThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemDichVuActionPerformed(evt);
            }
        });

        Button_XoaDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Delete_Icon.png"))); // NOI18N
        Button_XoaDichVu.setText("Xóa");
        Button_XoaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaDichVuActionPerformed(evt);
            }
        });

        Button_SuaDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_SuaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Fix_Icon.png"))); // NOI18N
        Button_SuaDichVu.setText("Sửa");
        Button_SuaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SuaDichVuActionPerformed(evt);
            }
        });

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Button_SuaDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_ThemDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_XoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_SuaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Text_MaDV)
                                    .addComponent(Text_TenDV)
                                    .addComponent(Text_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                        .addGap(0, 136, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Text_MaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Text_TenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Text_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Tên dịch vụ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Số lượng");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Ngày sử dụng");

        Spinner_SoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Spinner_SoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 0, 50, 1));
        Spinner_SoLuong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spinner_SoLuongStateChanged(evt);
            }
        });

        Table_DichVuPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên DV", "Ngày SD", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        Table_DichVuPhong.setShowGrid(false);
        Table_DichVuPhong.setShowHorizontalLines(true);
        jScrollPane4.setViewportView(Table_DichVuPhong);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã phòng");

        ComboBox_TenDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_TenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_TenDVActionPerformed(evt);
            }
        });

        ComboBox_MaPhg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_MaPhg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_MaPhgActionPerformed(evt);
            }
        });

        Button_ThemDVPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_ThemDVPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Add_Icon.png"))); // NOI18N
        Button_ThemDVPhong.setText("Thêm");
        Button_ThemDVPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemDVPhongActionPerformed(evt);
            }
        });

        Button_XoaDVPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XoaDVPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Delete_Icon.png"))); // NOI18N
        Button_XoaDVPhong.setText("Xóa");
        Button_XoaDVPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XoaDVPhongActionPerformed(evt);
            }
        });

        Button_InHoaDon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_InHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Bill_Icon.png"))); // NOI18N
        Button_InHoaDon.setText("In hóa đơn");
        Button_InHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_InHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_InHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Button_ThemDVPhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_XoaDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Button_InHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_ThemDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_XoaDVPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Thành tiền");

        Text_ThanhTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JDateChooser_NgaySuDung.setDate(date);
        JDateChooser_NgaySuDung.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBox_MaPhg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBox_TenDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDateChooser_NgaySuDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Text_ThanhTien)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(Spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 96, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ComboBox_MaPhg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(ComboBox_TenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(Spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(JDateChooser_NgaySuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(Text_ThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Dịch vụ phòng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Chi tiết dịch vụ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
      
    //Start code in Panel CHI TIET DICH VU
    private void Button_ThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemDichVuActionPerformed
        if(new DichVuController().KtraJtextDichVu(Text_TenDV, Text_DonGia)){
            DanhMucDichVu DichVu = new DanhMucDichVu();
            DichVu.setTenDV(Text_TenDV.getText());
            DichVu.setDonGia(Integer.parseInt(Text_DonGia.getText()));
            if(new DanhMucDichVuDAO().ThemTTDichVu(DichVu)){
                JOptionPane.showMessageDialog(this, "Thêm thành công.");
                listDichVu.add(DichVu);
                ComboBox_TenDV.addItem(Text_TenDV.getText().toString());
                clearJTextDichVu();
                UpdateTable_DichVu();
            } else {
                JOptionPane.showMessageDialog(this, "Không thể thêm.");
            }
        }
    }//GEN-LAST:event_Button_ThemDichVuActionPerformed

    private void Button_XoaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaDichVuActionPerformed
        int indexTB = Table_DichVu.getSelectedRow();
        DanhMucDichVu DichVu = returnDichVu(indexTB);       
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tblDichVu.getRowCount() && indexTB >= 0){
                if(new DanhMucDichVuDAO().XoaTTDichVu(DichVu)){               
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tblDichVu.removeRow(indexTB);
                    ComboBox_TenDV.removeItem(DichVu.getTenDV());
                    clearJTextDichVu();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại.");
                }
            }         
        }
    }//GEN-LAST:event_Button_XoaDichVuActionPerformed

    private void Button_SuaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SuaDichVuActionPerformed
        if(new DichVuController().KtraJtextDichVu(Text_TenDV, Text_DonGia)){
            int indexTB = Table_DichVu.getSelectedRow();
            int MaDV = Integer.parseInt(Text_MaDV.getText());
            String TenDV = Text_TenDV.getText();
            int DonGia = Integer.parseInt(Text_DonGia.getText());
            DanhMucDichVu DichVu = new DanhMucDichVu(MaDV, TenDV, DonGia);
            int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa dữ liệu?","Sửa dữ liệu",JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION){
                if(new DanhMucDichVuDAO().SuaTTDichVu(DichVu)){
                    if(indexTB < tblDichVu.getRowCount() && indexTB >= 0){
                        ComboBox_TenDV.removeItem(tblDichVu.getValueAt(indexTB, 2).toString());
                        tblDichVu.setValueAt(Text_TenDV.getText(), indexTB, 2);
                        tblDichVu.setValueAt(Text_DonGia.getText(), indexTB, 3);
                        ComboBox_TenDV.addItem(Text_TenDV.getText());
                        JOptionPane.showMessageDialog(this, "Sửa thành công.");   
                        clearJTextDichVu();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại.");
                    }
                }
            }
        }
    }//GEN-LAST:event_Button_SuaDichVuActionPerformed

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        clearJTextDichVu();
        Button_ThemDichVu.setEnabled(true);
        Button_XoaDichVu.setEnabled(false);
        Button_SuaDichVu.setEnabled(false);
    }//GEN-LAST:event_Button_LamMoiActionPerformed

    private void Table_DichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_DichVuMouseClicked
        ListSelectionModel listTable_DichVu = Table_DichVu.getSelectionModel();
        listTable_DichVu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Button_ThemDichVu.setEnabled(false);
        Button_XoaDichVu.setEnabled(true);
        Button_SuaDichVu.setEnabled(true);
        int indexTB = Table_DichVu.getSelectedRow();
        if (indexTB < tblDichVu.getRowCount() && indexTB >= 0){
            Text_MaDV.setText(tblDichVu.getValueAt(indexTB, 1).toString());
            Text_TenDV.setText(tblDichVu.getValueAt(indexTB, 2).toString());
            Text_DonGia.setText(tblDichVu.getValueAt(indexTB, 3).toString());
        }
    }//GEN-LAST:event_Table_DichVuMouseClicked

    public DanhMucDichVu returnDichVu(int index){        
        int MaDichVu = (int) tblDichVu.getValueAt(index, 1);
        String TenDichVu = tblDichVu.getValueAt(index, 2).toString();
        int DonGia = Integer.parseInt(tblDichVu.getValueAt(index, 3).toString());
        
        return new DanhMucDichVu(MaDichVu,TenDichVu,DonGia);
    }
    public void clearJTextDichVu(){
        Text_MaDV.setText("");
        Text_TenDV.setText("");
        Text_DonGia.setText("");
    }
    
    //End code in panel CHI TIET DICH VU.
    
    
    //Start code in Panel DICH VU PHONG.
   
    public void showTableDichVuPhong(String MaPhong){
        int i = 1;
        listDVPhong = new HoaDonDichVuDAO().getListChiTietHDDV(MaPhong);
        for(HoaDonDichVu data : listDVPhong){
            tbleDichVuPhong.addRow(new Object[]{i++, data.getTenDV(), data.getNgaySD(), data.getSoLuong(), data.getDonGia(), data.getSoLuong()*data.getDonGia()});
        }
    }
    
    public void UpdateTableDVPhong(String MaPhong){
        tbleDichVuPhong.setRowCount(0);
        this.showTableDichVuPhong(MaPhong);
    }
    
    public void showComboBox_MaPhg(){
        ArrayList<ThongTinPhong> ttMaPhg = new ThongTinPhongDAO().getListPhongDangSD();
        for(ThongTinPhong data : ttMaPhg){
            ComboBox_MaPhg.addItem(data.getMaPhg());
        }
    }
    
    public void showComboBox_TenDV(){
        ArrayList<DanhMucDichVu> ttTenDV = new DanhMucDichVuDAO().getListTenDV();
        for(DanhMucDichVu data : ttTenDV){
            ComboBox_TenDV.addItem(data.getTenDV());
        }
    }
    
    public void UpdateTable_DichVu(){
        tblDichVu.setRowCount(0);
        showTableChiTietDV();
    }

    private void Button_InHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_InHoaDonActionPerformed
        String maphg = ComboBox_MaPhg.getSelectedItem().toString();
        HashMap para = new HashMap();
        para.put("maphg", maphg);
        viewReport("src\\Reports\\HoaDonDV.jasper", para);
    }//GEN-LAST:event_Button_InHoaDonActionPerformed

    private void Button_ThemDVPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemDVPhongActionPerformed
        HoaDonDichVu HDDV = new HoaDonDichVu();
        HDDV.setMaPHG(ComboBox_MaPhg.getSelectedItem().toString());
        HDDV.setTenDV(ComboBox_TenDV.getSelectedItem().toString());
        HDDV.setSoLuong((int) Spinner_SoLuong.getValue());
        HDDV.setNgaySD(JDateChooser_NgaySuDung.getDate());
        if(new HoaDonDichVuDAO().ThemDichVuPhong(HDDV,dsDichVu.get(HDDV.getTenDV()).getMaDV())){
            JOptionPane.showMessageDialog(this, "Thêm thành công.");
            UpdateTableDVPhong(ComboBox_MaPhg.getSelectedItem().toString());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại.");
            clearTextDVPhong();
        }
    }//GEN-LAST:event_Button_ThemDVPhongActionPerformed

    private void Button_XoaDVPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XoaDVPhongActionPerformed
        int indexTB = Table_DichVuPhong.getSelectedRow();
        if(indexTB < 0){
            JOptionPane.showMessageDialog(this, "Chưa chọn dịch vụ để xóa.\nVui lòng chọn một dịch vụ trong bảng để xóa.");
            return;
        }
        HoaDonDichVu hddv = new HoaDonDichVu();
        hddv.setMaPHG(ComboBox_MaPhg.getSelectedItem().toString());
        DanhMucDichVu dv = dsDichVu.get(tbleDichVuPhong.getValueAt(indexTB, 1).toString());
        int ret = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa dữ liệu?", "Xóa dữ liệu", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION){
            if(indexTB < tbleDichVuPhong.getRowCount() && indexTB >= 0){
                if(new HoaDonDichVuDAO().XoaDichVuPhong(hddv,dv.getMaDV())){               
                    JOptionPane.showMessageDialog(this, "Xóa thành công.");
                    tbleDichVuPhong.removeRow((indexTB));
                    clearTextDVPhong();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại.");
                }
            }         
        }
    }//GEN-LAST:event_Button_XoaDVPhongActionPerformed

    private void ComboBox_MaPhgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_MaPhgActionPerformed
        UpdateTableDVPhong(ComboBox_MaPhg.getSelectedItem().toString());
    }//GEN-LAST:event_ComboBox_MaPhgActionPerformed

    private void ComboBox_TenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_TenDVActionPerformed
        Spinner_SoLuong.setValue(1);
        getDonGiaDV();        
    }//GEN-LAST:event_ComboBox_TenDVActionPerformed

    private void Spinner_SoLuongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spinner_SoLuongStateChanged
        getDonGiaDV();
    }//GEN-LAST:event_Spinner_SoLuongStateChanged
    
    public void clearTextDVPhong(){
        Spinner_SoLuong.setValue(1);
        ComboBox_TenDV.setSelectedIndex(0);
    }
    
    public void viewReport(String fileName, HashMap para){
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(fileName, para, DataBaseConnection.getConnection());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //End code in Panel DICH VU PHONG.
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_InHoaDon;
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_SuaDichVu;
    private javax.swing.JButton Button_ThemDVPhong;
    private javax.swing.JButton Button_ThemDichVu;
    private javax.swing.JButton Button_XoaDVPhong;
    private javax.swing.JButton Button_XoaDichVu;
    private javax.swing.JComboBox<String> ComboBox_MaPhg;
    private javax.swing.JComboBox<String> ComboBox_TenDV;
    private com.toedter.calendar.JDateChooser JDateChooser_NgaySuDung;
    private javax.swing.JSpinner Spinner_SoLuong;
    private javax.swing.JTable Table_DichVu;
    private javax.swing.JTable Table_DichVuPhong;
    private javax.swing.JTextField Text_DonGia;
    private javax.swing.JTextField Text_MaDV;
    private javax.swing.JTextField Text_TenDV;
    private javax.swing.JTextField Text_ThanhTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
