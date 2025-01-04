package View;

import DAO.ThongTinPhongDAO;
import DAO.KhachHangDAO;
import DAO.PhieuDatPhongDAO;
import DAO.KieuKhachDAO;
import DAO.ThamSoDAO;
import Model.ThongTinPhong;
import Model.KhachHang;
import Model.PhieuDatPhong;
import Model.ThamSo;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;

import java.text.DecimalFormat;
/**
 *
 * @author asus
 */
public class QuanLiDatPhongJPane extends javax.swing.JPanel {
//    private ArrayList<LoaiPhong> listKieuPhong;
    private ArrayList<ThongTinPhong> listPhongTrong;
    private ArrayList<KhachHang> listKhachHang;
    private HashMap<String, Integer> listPhongDat;
    private KhachHangDAO khachHangDAO;
    private PhieuDatPhongDAO phieuDatPhongDAO;
    private int curr_MaDatPhong;
    private int curr_MaKhachHang;
    private int tongTienPhong;
    private PhieuDatPhong phieuDatPhong; 
    DefaultTableModel tblKhachHang;
    DefaultTableModel tblDanhSachPhongTrong;
    DefaultTableModel tblDanhSachPhongDat;
    DefaultTableModel tblDanhSachTiLePhuThu;
    private int nPhuThu = 2;
    private HashMap<String, Integer> mapPhuThu;
    private HashMap<String, Double> tilePhuThu;
    private int SoKhachVuotQua;
    Date date = new Date();
    
    private ThamSoDAO thamsoDAO;
    public double tongTiLePhuThu;
    public double tileCoc;
   
    public QuanLiDatPhongJPane() 
    {             
        initComponents(); 
//       phiếu đặt phòng init
        phieuDatPhong = new PhieuDatPhong();
        phieuDatPhongDAO = new PhieuDatPhongDAO();
        curr_MaDatPhong = phieuDatPhongDAO.getCurrentMaDatPhong();
        tongTienPhong = 0;
        
        thamsoDAO = new ThamSoDAO();
        ThamSo thamSo = thamsoDAO.getThamSobyMaQD("TiLeTraTruoc");
        tileCoc = Double.parseDouble(thamSo.getGiaTri());
        Text_TiLeCoc.setText(String.valueOf(tileCoc));
        
//      Danh sách phòng init        
        listPhongTrong = new ThongTinPhongDAO().getListChiTietTTPhong();
        tblDanhSachPhongTrong = (DefaultTableModel) Table_DanhSachPhongTrong.getModel();
        tblDanhSachPhongTrong.setColumnIdentifiers(new Object[]{"Mã phòng", "Kiểu phòng", "Kiểu giường", "Giá phòng", "Số khách tối đa", "Tỷ lệ phụ thu"});
        
        listPhongDat = new HashMap<String,Integer>();
        tblDanhSachPhongDat = (DefaultTableModel) Table_DanhSachPhongDat.getModel();
        tblDanhSachPhongDat.setColumnIdentifiers(new Object[]{"Mã phòng", "Số lưọng khách"});
        
        tblDanhSachTiLePhuThu = (DefaultTableModel) Table_TiLePhuThu.getModel();
        mapPhuThu = new HashMap<String, Integer>();
        tilePhuThu = new HashMap<String, Double>();
        
        String tenPhuThuLoaiKhach = "Theo loại khách";
        double giatri = 0.0;
        tilePhuThu.put(tenPhuThuLoaiKhach, giatri);
        mapPhuThu.put("Theo loại khách", 0);
        tblDanhSachTiLePhuThu.addRow(new Object[]{"Phụ thu theo loại khách", giatri});
        
        String tenPhuThuKhachToiDa = "Theo khách tối đa";
        giatri = 0.0;
        tilePhuThu.put(tenPhuThuKhachToiDa, giatri);
        mapPhuThu.put("Theo khách tối đa", 1);
        tblDanhSachTiLePhuThu.addRow(new Object[]{"Phụ thu khách tối đa", giatri});

        
//        showTableChiTietTTPhong();
        showComboBox_KieuPhong();
//        showComboBox_KieuGiuong();
        Table_DanhSachPhongDat.setShowHorizontalLines(true);
        Table_DanhSachPhongTrong.setShowHorizontalLines(true);
        Table_TiLePhuThu.setShowHorizontalLines(true);
        Table_DanhSachPhongDat.setDefaultEditor(Object.class, null);
        Table_DanhSachPhongTrong.setDefaultEditor(Object.class, null);
        Table_TiLePhuThu.setDefaultEditor(Object.class, null);
        Button_XoaPhongDat.setEnabled(false);
    }
    
    public void updateTableTiLePhuThu(){
        String tenTiLe = "Theo loại khách";
        double giatri = tilePhuThu.get(tenTiLe);
        int indexTB = mapPhuThu.get(tenTiLe);
        tblDanhSachTiLePhuThu.setValueAt(giatri, indexTB, 1);
        
        tenTiLe = "Theo khách tối đa";
        giatri = tilePhuThu.get(tenTiLe);
        indexTB = mapPhuThu.get(tenTiLe);
        tblDanhSachTiLePhuThu.setValueAt(giatri, indexTB, 1);
    }
    
    public void showTableChiTietTTPhong(){
        tblDanhSachPhongTrong.setRowCount(0);
        for(ThongTinPhong ttPhong : listPhongTrong){
            tblDanhSachPhongTrong.addRow(new Object[]{ttPhong.getMaPhg(), ttPhong.getKieuPhong(), ttPhong.getKieuGiuong(), 
                ttPhong.getDonGia(), ttPhong.getSoKhachToiDa(), ttPhong.getTyLePhuThu()});          
        }
    }
    
    public void resetTablePhongTrong(){
        try {
            //            int kieuGiuong = Integer.parseInt(ComboBox_LoaiGiuong.getSelectedItem().toString());
//            Date ngayNhan = jDateChooser_NgayNhan.getDate();
//            Date ngayTra = jDateChooser_NgayTra.getDate();
            String kieuphong = ComboBox_KieuPhong.getSelectedItem().toString();
            if (kieuphong.equals("Tất cả"))
                kieuphong = "";
            String kieugiuong = ComboBox_KieuGiuong.getSelectedItem().toString();
            if (kieugiuong.equals("Tất cả"))
                kieugiuong = "";

            listPhongTrong = new ThongTinPhongDAO().getListTTPhongTrong(kieuphong, kieugiuong ,
                    new java.sql.Date(jDateChooser_NgayNhan.getDate().getTime()), new java.sql.Date(jDateChooser_NgayTra.getDate().getTime()));
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiDatPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTableChiTietTTPhong();
    }
    
    public void reset()
    {
        curr_MaDatPhong = phieuDatPhongDAO.getCurrentMaDatPhong();
        Text_MaKhachHang.setText("");
        Text_TenKhachHang.setText("");
        Text_LoaiKhach.setText("");
        Text_TongTienPhong.setText("");
        Text_TienTraTruoc.setText("");
        Text_TongTien.setText("");
        Text_TienPhuPhi.setText("");
        Text_TongTiLePhuThu.setText("");
        tblDanhSachPhongDat.setRowCount(0);
        ComboBox_KieuPhong.setSelectedItem("Tất cả");
        ComboBox_KieuGiuong.setSelectedItem("Tất cả");
        jDateChooser_NgayNhan.setDate(null);
        jDateChooser_NgayTra.setDate(null);
        Button_ThemPhongDat.setEnabled(true);
        Button_XoaPhongDat.setEnabled(false);

        for (int row = 0; row < tblDanhSachTiLePhuThu.getRowCount(); row++){
            tblDanhSachTiLePhuThu.setValueAt(0, row, 1);
        }
        
        tblDanhSachPhongTrong.setRowCount(0);
    }
    public String getMaKH()
    {
        ChonKhachHang panel = new ChonKhachHang();
        int result =    JOptionPane.showConfirmDialog(null, panel, "Chọn khách hàng", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
            return panel.returnMaKH();
        }
        else return null;
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
        jLabel6 = new javax.swing.JLabel();
        ComboBox_KieuPhong = new javax.swing.JComboBox<>();
        ComboBox_KieuGiuong = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_DanhSachPhongTrong = new javax.swing.JTable();
        Button_TimKiemPhong = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser_NgayNhan = new com.toedter.calendar.JDateChooser();
        jDateChooser_NgayTra = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        Button_XacNhanKhachHang = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_DanhSachPhongDat = new javax.swing.JTable();
        Button_ThemPhongDat = new javax.swing.JButton();
        Button_XoaPhongDat = new javax.swing.JButton();
        Button_TaoDonDatPhong = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Text_TienTraTruoc = new javax.swing.JTextField();
        Text_TongTienPhong = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Text_TenKhachHang = new javax.swing.JTextField();
        Text_LoaiKhach = new javax.swing.JTextField();
        Text_MaKhachHang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Text_TienPhuPhi = new javax.swing.JTextField();
        Text_TiLeCoc = new javax.swing.JTextField();
        Text_TongTien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Text_TongTiLePhuThu = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        Table_TiLePhuThu = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        Button_LamMoi = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        Text_SoKhachTinhPhuThu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1058, 644));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel2.setPreferredSize(new java.awt.Dimension(1058, 642));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Kiểu phòng");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kiểu giường");

        ComboBox_KieuPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_KieuPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        ComboBox_KieuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_KieuPhongActionPerformed(evt);
            }
        });

        ComboBox_KieuGiuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_KieuGiuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        Table_DanhSachPhongTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Kiểu phòng", "Kiểu giường", "Giá phòng", "Số khách tối đa", "Tỷ lệ phụ thu"
            }
        ));
        jScrollPane3.setViewportView(Table_DanhSachPhongTrong);

        Button_TimKiemPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_TimKiemPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Search_Icon.png"))); // NOI18N
        Button_TimKiemPhong.setText("Tìm phòng trống");
        Button_TimKiemPhong.setMaximumSize(new java.awt.Dimension(115, 40));
        Button_TimKiemPhong.setMinimumSize(new java.awt.Dimension(115, 40));
        Button_TimKiemPhong.setPreferredSize(new java.awt.Dimension(115, 40));
        Button_TimKiemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TimKiemPhongActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Ngày nhận");

        jDateChooser_NgayNhan.setDateFormatString("dd/MM/yyyy");
        jDateChooser_NgayNhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser_NgayTra.setDateFormatString("dd/MM/yyyy");
        jDateChooser_NgayTra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Ngày trả");

        Button_XacNhanKhachHang.setBackground(new java.awt.Color(51, 51, 51));
        Button_XacNhanKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XacNhanKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        Button_XacNhanKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_people_white_24dp.png"))); // NOI18N
        Button_XacNhanKhachHang.setText("Chọn khách hàng");
        Button_XacNhanKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_XacNhanKhachHangMouseClicked(evt);
            }
        });
        Button_XacNhanKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XacNhanKhachHangActionPerformed(evt);
            }
        });

        Table_DanhSachPhongDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Số lượng khách"
            }
        ));
        Table_DanhSachPhongDat.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(Table_DanhSachPhongDat);
        Table_DanhSachPhongDat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Button_ThemPhongDat.setText(">>");
        Button_ThemPhongDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_ThemPhongDatMouseClicked(evt);
            }
        });
        Button_ThemPhongDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ThemPhongDatActionPerformed(evt);
            }
        });

        Button_XoaPhongDat.setText("<<");
        Button_XoaPhongDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_XoaPhongDatMouseClicked(evt);
            }
        });

        Button_TaoDonDatPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_TaoDonDatPhong.setText("Tạo đơn đặt phòng");
        Button_TaoDonDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_TaoDonDatPhongMouseClicked(evt);
            }
        });
        Button_TaoDonDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TaoDonDatPhongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tiền trả trước");

        Text_TienTraTruoc.setEditable(false);
        Text_TienTraTruoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_TongTienPhong.setEditable(false);
        Text_TongTienPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_TongTienPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_TongTienPhongActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Tiền phòng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Loại khách");

        Text_TenKhachHang.setEditable(false);
        Text_TenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Text_LoaiKhach.setEditable(false);
        Text_LoaiKhach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Text_MaKhachHang.setEditable(false);
        Text_MaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tỉ lệ cọc");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tiền phụ thu");

        Text_TienPhuPhi.setEditable(false);
        Text_TienPhuPhi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_TienPhuPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_TienPhuPhiActionPerformed(evt);
            }
        });

        Text_TiLeCoc.setEditable(false);
        Text_TiLeCoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_TiLeCocActionPerformed(evt);
            }
        });

        Text_TongTien.setEditable(false);
        Text_TongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Text_TongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_TongTienActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tổng tiền");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tổng tỉ lệ phụ thu");

        Text_TongTiLePhuThu.setEditable(false);
        Text_TongTiLePhuThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_TongTiLePhuThuActionPerformed(evt);
            }
        });

        Table_TiLePhuThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên tỉ lệ phụ thu", "Giá trị"
            }
        ));
        jScrollPane5.setViewportView(Table_TiLePhuThu);
        Table_TiLePhuThu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Bảng tỉ lệ phụ thu");

        Button_LamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_LamMoi.setText("Làm mới");
        Button_LamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_LamMoiMouseClicked(evt);
            }
        });
        Button_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_LamMoiActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Số khách tính phụ thu");

        Text_SoKhachTinhPhuThu.setEditable(false);
        Text_SoKhachTinhPhuThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_SoKhachTinhPhuThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Text_TenKhachHang)
                        .addComponent(Text_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Text_LoaiKhach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Button_XacNhanKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBox_KieuPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBox_KieuGiuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Button_TimKiemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Text_SoKhachTinhPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel7))
                                            .addGap(31, 31, 31)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Text_TongTiLePhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Text_TiLeCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Button_ThemPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Button_XoaPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Text_TongTien)
                                    .addComponent(Text_TienPhuPhi)
                                    .addComponent(Text_TongTienPhong)
                                    .addComponent(Text_TienTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Button_TaoDonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Text_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Text_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Button_XacNhanKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Text_LoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ComboBox_KieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(ComboBox_KieuGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jDateChooser_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jDateChooser_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGap(34, 34, 34)
                            .addComponent(Button_TimKiemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Button_ThemPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_XoaPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_TongTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Text_TienPhuPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(Text_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_TienTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Button_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_TaoDonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_SoKhachTinhPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_TongTiLePhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Text_TiLeCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Phiếu đặt phòng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Button_TimKiemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TimKiemPhongActionPerformed
        if (jDateChooser_NgayNhan.getDate()==null || jDateChooser_NgayTra.getDate()==null )
        {
            JOptionPane.showMessageDialog(this,"Yêu cầu nhập ngày nhận, ngày trả trước khi tra cứu danh sách phòng trống");
        } else if(jDateChooser_NgayTra.getDate().compareTo(jDateChooser_NgayNhan.getDate()) < 0){
            JOptionPane.showMessageDialog(this, "Ngày trả nhỏ hơn ngày nhận. Vui lòng kiểm tra lại.");
            return;
        }     
        else
        {
            String kieuPhong = ComboBox_KieuPhong.getSelectedItem().toString();
            try {
                //            int kieuGiuong = Integer.parseInt(ComboBox_LoaiGiuong.getSelectedItem().toString());
//            Date ngayNhan = jDateChooser_NgayNhan.getDate();
//            Date ngayTra = jDateChooser_NgayTra.getDate();
                String kieuphong = ComboBox_KieuPhong.getSelectedItem().toString();
                if (kieuphong.equals("Tất cả"))
                    kieuphong = "";
                String kieugiuong = ComboBox_KieuGiuong.getSelectedItem().toString();
                if (kieugiuong.equals("Tất cả"))
                    kieugiuong = "";
                    
                listPhongTrong = new ThongTinPhongDAO().getListTTPhongTrong(kieuphong, kieugiuong ,
                        new java.sql.Date(jDateChooser_NgayNhan.getDate().getTime()), new java.sql.Date(jDateChooser_NgayTra.getDate().getTime()));
            } catch (SQLException ex) {
                Logger.getLogger(QuanLiDatPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
            }
            showTableChiTietTTPhong();
        }    
    }//GEN-LAST:event_Button_TimKiemPhongActionPerformed
    
    private void Button_XacNhanKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_XacNhanKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_XacNhanKhachHangMouseClicked

    public int ShowInputDinalog(int KhachToiDa){
        boolean isValid = false;

        while (!isValid) {
            try {
                // Hiển thị hộp thoại nhập liệu
                String input = JOptionPane.showInputDialog(null, "Nhập số lượng khách trong phòng:");

                // Kiểm tra người dùng nhấn Cancel hoặc để trống
                if (input == null || input.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bạn đã hủy hoặc không nhập gì. Kết thúc chương trình.");
                    return -1; // Thoát chương trình
                }

                // Thử chuyển đổi chuỗi thành số nguyên
                int number = Integer.parseInt(input);
                
                if (number > KhachToiDa){
                    JOptionPane.showMessageDialog(null, "Lỗi: Lượng khách vượt quá số khách tối đa của phòng.");
                } else if(number > 0){
                    isValid = true; // Nếu không có lỗi, kết thúc vòng lặp
                    return number;
                }
               
            } catch (NumberFormatException e) {
                // Hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(null, "Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
        return -1;
    }
    
    public void CalAndShowPrice(){
        try {

        // Tính số tiền trả trước
        
        double PhuPhi = tongTienPhong * tongTiLePhuThu;
        double TongTien = tongTienPhong + PhuPhi;
        double tienTraTruoc = TongTien * tileCoc;
        DecimalFormat df = new DecimalFormat("#.##");
        
        String formattedTienTraTruoc = df.format(tienTraTruoc);
        String formattedPhuPhi = df.format(PhuPhi);
        String formattedTongTien = df.format(TongTien);
        // Cập nhật Text_TienTraTruoc
        Text_TienTraTruoc.setText(formattedTienTraTruoc);
        Text_TienPhuPhi.setText(formattedPhuPhi);
        Text_TongTien.setText(formattedTongTien);
        } catch (NumberFormatException ex) {
        // Xử lý trường hợp giá trị không hợp lệ
        JOptionPane.showMessageDialog(this, "Giá trị trong ComboBox không hợp lệ.");
        }
    }
    
    public double UpdateTongTiLePhuThu(){
        // Duyệt bảng tỉ lệ phụ thu lấy tổng tỉ lệ phụ thu
        tongTiLePhuThu = 0;
        for (int row = 0; row < tblDanhSachTiLePhuThu.getRowCount(); row++) {
            Object value = tblDanhSachTiLePhuThu.getValueAt(row, 1);
            tongTiLePhuThu += Double.parseDouble(value.toString());
        }
        
        Text_TongTiLePhuThu.setText(Double.toString(tongTiLePhuThu));
        return tongTiLePhuThu;
    }
    
    private void Button_ThemPhongDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_ThemPhongDatMouseClicked
        // TODO add your handling code here:
        long songayluutru;
        long diff = jDateChooser_NgayTra.getDate().getTime() - jDateChooser_NgayNhan.getDate().getTime();
        TimeUnit time = TimeUnit.DAYS; 
        songayluutru = time.convert(diff, TimeUnit.MILLISECONDS);
        if (songayluutru < 0)
            songayluutru = 0;
        else if (songayluutru == 0)
            songayluutru = 1;
        int indexTB = Table_DanhSachPhongTrong.getSelectedRow();
        if (indexTB < tblDanhSachPhongTrong.getRowCount() && indexTB >= 0){
            String selectedRoom = tblDanhSachPhongTrong.getValueAt(indexTB, 0).toString();
            Integer selectedPrice =  Integer.valueOf(tblDanhSachPhongTrong.getValueAt(indexTB, 3).toString());
            Integer selectedKhachToiDa = Integer.valueOf(tblDanhSachPhongTrong.getValueAt(indexTB, 4).toString());
            Integer selectedKieuGiuong = Integer.valueOf(tblDanhSachPhongTrong.getValueAt(indexTB, 2).toString());
            Double TyLePhuThu = Double.valueOf(tblDanhSachPhongTrong.getValueAt(indexTB, 5).toString());
            if (!listPhongDat.keySet().contains(selectedRoom))
            {
                int nKhach = ShowInputDinalog(selectedKhachToiDa);
                if (nKhach != -1){
                    listPhongDat.put(selectedRoom, selectedPrice);
                    tblDanhSachPhongDat.addRow(new Object[]{selectedRoom, nKhach}); 
                    tongTienPhong += listPhongDat.get(selectedRoom)*(int)songayluutru;
                    Text_TongTienPhong.setText(Integer.toString(tongTienPhong));
                    Button_ThemPhongDat.setEnabled(false);
                    Button_XoaPhongDat.setEnabled(true);
                    SoKhachVuotQua = nKhach - selectedKieuGiuong;
                    Text_SoKhachTinhPhuThu.setText(String.valueOf(SoKhachVuotQua));
                    String tenTiLe = "Theo khách tối đa";
                    TyLePhuThu = TyLePhuThu * SoKhachVuotQua;
                    tilePhuThu.put(tenTiLe, TyLePhuThu);
                    updateTableTiLePhuThu();
                    UpdateTongTiLePhuThu();
                    CalAndShowPrice();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Thêm phòng không thành công!");
                }
            }
        }  
         
    }//GEN-LAST:event_Button_ThemPhongDatMouseClicked

    private void Button_XoaPhongDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_XoaPhongDatMouseClicked
        // TODO add your handling code here:
        long songayluutru;
        long diff = jDateChooser_NgayTra.getDate().getTime() - jDateChooser_NgayNhan.getDate().getTime();
        TimeUnit time = TimeUnit.DAYS; 
        songayluutru = time.convert(diff, TimeUnit.MILLISECONDS);
        if (songayluutru < 0)
            songayluutru = 0;
        else if (songayluutru == 0)
            songayluutru = 1;

        int indexTB = Table_DanhSachPhongDat.getSelectedRow();
        if (indexTB < tblDanhSachPhongDat.getRowCount() && indexTB >= 0){
            String selectedRoom = tblDanhSachPhongDat.getValueAt(indexTB, 0).toString();
            listPhongDat.remove(selectedRoom);
            tblDanhSachPhongDat.removeRow(indexTB);
            tongTienPhong = 0;
            Text_TongTienPhong.setText("0");
            Button_ThemPhongDat.setEnabled(true);
            Button_XoaPhongDat.setEnabled(false);
            SoKhachVuotQua = 0;
            Text_SoKhachTinhPhuThu.setText(String.valueOf(SoKhachVuotQua));
            String tenTiLe = "Theo khách tối đa";
            double TyLePhuThu = 0;
            tilePhuThu.put(tenTiLe, TyLePhuThu);
            updateTableTiLePhuThu();
            UpdateTongTiLePhuThu();
            CalAndShowPrice();
        }
    }//GEN-LAST:event_Button_XoaPhongDatMouseClicked

    private void Button_TaoDonDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_TaoDonDatPhongMouseClicked
        // TODO add your handling code here:
        if (Text_MaKhachHang.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Người dùng chưa chọn khách hàng");
            return;
        }
        else if (tblDanhSachPhongDat.getRowCount()==0){
            JOptionPane.showMessageDialog(this,"Người dùng chưa chọn phòng để đặt");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date currentDate = sdf.parse(sdf.format(new Date()));
            Date NgayNhan = sdf.parse(sdf.format(jDateChooser_NgayNhan.getDate()));
            if(jDateChooser_NgayNhan.getDate().compareTo(currentDate) < 0){
                int ret = JOptionPane.showConfirmDialog(this, "Đã qua ngày nhận phòng. \nBạn có chắc chắn muốn đặt phòng?", "Ngày nhận phòng đã qua.", JOptionPane.YES_NO_OPTION);
                if(ret == JOptionPane.NO_OPTION){
                return;
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(NhanPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        phieuDatPhong.setMaDatPhong(curr_MaDatPhong);
        KhachHang k = new KhachHang();
        k.setMaKH(Integer.parseInt(Text_MaKhachHang.getText()));
        phieuDatPhong.setKhachHang(k);
        phieuDatPhong.setTienPhong(Integer.parseInt(Text_TongTien.getText()));
        try {
            phieuDatPhong.setTienTraTruoc(Integer.parseInt(Text_TienTraTruoc.getText()));        
        } catch (NumberFormatException e) {
            phieuDatPhong.setTienTraTruoc(0);
        }
        phieuDatPhong.setPhuPhi(Integer.parseInt(Text_TienPhuPhi.getText()));
        
        phieuDatPhong.setNgayNhan(jDateChooser_NgayNhan.getDate());
        phieuDatPhong.setNgayTra(jDateChooser_NgayTra.getDate());
        try {
            if (phieuDatPhongDAO.TaoPhieuDatPhong(phieuDatPhong, new ArrayList<String>(listPhongDat.keySet()) ))
            {
                JOptionPane.showMessageDialog(this, "Thêm phiếu đặt phòng thành công.");
                this.reset();
            }
            else {
                JOptionPane.showMessageDialog(this,"Thêm phiếu đặt phòng thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiDatPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_TaoDonDatPhongMouseClicked

    private void ComboBox_KieuGiuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_KieuGiuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_KieuGiuongActionPerformed

    private void ComboBox_KieuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_KieuPhongActionPerformed
        // TODO add your handling code here:
        ComboBox_KieuGiuong.removeAllItems();
        showComboBox_KieuGiuong();

    }//GEN-LAST:event_ComboBox_KieuPhongActionPerformed

    private void Button_XacNhanKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XacNhanKhachHangActionPerformed
        ChonKhachHang ttKH = new ChonKhachHang();
        int result = JOptionPane.showConfirmDialog(null, ttKH, "Chọn khách hàng", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
            KhachHang selected_kh = ttKH.returnTTKH();
            Text_MaKhachHang.setText(String.valueOf(selected_kh.getMaKH()));
            Text_TenKhachHang.setText(selected_kh.getTenKH());
            Text_LoaiKhach.setText(selected_kh.getTenLoaiKhach());
            double TyLePhuThu = Double.parseDouble(selected_kh.getTyLePhuThu());
            String tenTiLe = "Theo loại khách";
            tilePhuThu.put(tenTiLe, TyLePhuThu);
            updateTableTiLePhuThu();
            UpdateTongTiLePhuThu();
        }

    }//GEN-LAST:event_Button_XacNhanKhachHangActionPerformed

    private void Button_ThemPhongDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ThemPhongDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_ThemPhongDatActionPerformed

    private void Text_TienPhuPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_TienPhuPhiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_TienPhuPhiActionPerformed

    private void Text_TongTienPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_TongTienPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_TongTienPhongActionPerformed

    private void Text_TongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_TongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_TongTienActionPerformed

    private void Button_TaoDonDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TaoDonDatPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_TaoDonDatPhongActionPerformed

    private void Text_TongTiLePhuThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_TongTiLePhuThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_TongTiLePhuThuActionPerformed

    private void Text_TiLeCocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_TiLeCocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_TiLeCocActionPerformed

    private void Button_LamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_LamMoiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_LamMoiMouseClicked

    private void Button_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_LamMoiActionPerformed
        reset();        // TODO add your handling code here:
    }//GEN-LAST:event_Button_LamMoiActionPerformed

    private void Text_SoKhachTinhPhuThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_SoKhachTinhPhuThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_SoKhachTinhPhuThuActionPerformed
    public KhachHang getKhachHangValue()
    {
        KhachHang kh =new KhachHang();
        kh.setMaKH(Integer.parseInt(Text_MaKhachHang.getText()));
        return kh;

    }
    public void clearTextKhachHang()
    {
        Text_MaKhachHang.setText(Integer.toString(curr_MaKhachHang));
    }
    public void showComboBox_KieuPhong(){
        ArrayList<ThongTinPhong> ttKieuPhong = new ThongTinPhongDAO().getKieuPhong();
        for(ThongTinPhong data : ttKieuPhong){
            ComboBox_KieuPhong.addItem(data.getKieuPhong());
        }
    }
    
public void showComboBox_KieuGiuong(){
        ArrayList<ThongTinPhong> ttKieuGiuong = new ThongTinPhongDAO().getKieuGiuong(ComboBox_KieuPhong.getSelectedItem().toString());
        for(ThongTinPhong data : ttKieuGiuong){
            ComboBox_KieuGiuong.addItem(String.valueOf(data.getKieuGiuong()));
        }
        
        ComboBox_KieuGiuong.addItem("Tất cả");
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_LamMoi;
    private javax.swing.JButton Button_TaoDonDatPhong;
    private javax.swing.JButton Button_ThemPhongDat;
    private javax.swing.JButton Button_TimKiemPhong;
    private javax.swing.JButton Button_XacNhanKhachHang;
    private javax.swing.JButton Button_XoaPhongDat;
    private javax.swing.JComboBox<String> ComboBox_KieuGiuong;
    private javax.swing.JComboBox<String> ComboBox_KieuPhong;
    private javax.swing.JTable Table_DanhSachPhongDat;
    private javax.swing.JTable Table_DanhSachPhongTrong;
    private javax.swing.JTable Table_TiLePhuThu;
    private javax.swing.JTextField Text_LoaiKhach;
    private javax.swing.JTextField Text_MaKhachHang;
    private javax.swing.JTextField Text_SoKhachTinhPhuThu;
    private javax.swing.JTextField Text_TenKhachHang;
    private javax.swing.JTextField Text_TiLeCoc;
    private javax.swing.JTextField Text_TienPhuPhi;
    private javax.swing.JTextField Text_TienTraTruoc;
    private javax.swing.JTextField Text_TongTiLePhuThu;
    private javax.swing.JTextField Text_TongTien;
    private javax.swing.JTextField Text_TongTienPhong;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayNhan;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
