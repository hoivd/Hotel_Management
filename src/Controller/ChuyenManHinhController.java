
package Controller;

import Bean.DanhMuc;
import View.AdminJFrame;
import View.LoginForm;
import View.NhanPhongJPane;
import View.QuanLiDatPhongJPane;
import View.QuanLiDichVuJPane;
import View.QuanLiDichVuJPaneUser;
import View.QuanLiKhachHangJPane;
import View.QuanLiKhachHangUserJPane;
import View.QuanLiThamSoJPane;
import View.QuanLiNhanVienJPane;
import View.QuanLiPhongJPane;
import View.ThongKeJPane;
import View.TrangChuJPane;
import View.TraPhongJPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author asus
 */
public class ChuyenManHinhController {
    private JPanel Root;
    private String kindeSelected = "";
    
    private List<DanhMuc> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.Root = jpnRoot;
    }
    
    public void setView (JPanel jpnItem, JLabel jlbItem){
        kindeSelected = "TrangChu";
        jpnItem.setBackground(new Color(153,153,153));
        jlbItem.setBackground(new Color(153,153,153));
        
        Root.removeAll();
        Root.setLayout(new BorderLayout());
        Root.add(new TrangChuJPane());
        Root.validate();
        Root.repaint();        
    }
    
    public void setEvent(List<DanhMuc> listItem){
        this.listItem = listItem;
        for(DanhMuc item: listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    public ChuyenManHinhController() {
    }
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "TrangChu":
                    node = new TrangChuJPane();
                    break;
                case "QuanLiKhachHang":
                    node = new QuanLiKhachHangJPane();
                    break;
                case "QuanLiKhachHangUser":
                    node = new QuanLiKhachHangUserJPane();
                    break;
                case "QuanLiThamSo":
                    node = new QuanLiThamSoJPane();
                    break;
                case "QuanLiNhanVien":
                    node = new QuanLiNhanVienJPane();
                    break;
                case "QuanLiPhong":
                    node = new QuanLiPhongJPane();
                    break;                
                case "ThongKe":
                    node = new ThongKeJPane();
                    break;
                case "QuanLiDichVu":
                    node = new QuanLiDichVuJPane();
                    break;
                case "QuanLiDichVuUser":
                    node = new QuanLiDichVuJPaneUser();
                    break;
                case "QuanLiDatPhong":
                    node = new QuanLiDatPhongJPane();
                    break;
                case "CheckIn":
                    node = new NhanPhongJPane();
                    break;
                case "CheckOut":
                    node = new TraPhongJPane();
                    break;
                default:
                    node = new TrangChuJPane();
                    break;
            }
            Root.removeAll();
            Root.repaint();
            Root.revalidate();
            Root.setLayout(new BorderLayout());
            Root.add(node);
            Root.repaint();            
            Root.revalidate();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindeSelected = kind;
            jpnItem.setBackground(new Color(153,153,153));
            jlbItem.setBackground(new Color(153,153,153));
            for(DanhMuc item: listItem){
                if(!kindeSelected.equalsIgnoreCase(item.getKind())){
                    item.getJpn().setBackground(new Color(102,102,102));
                    item.getJpn().setBackground(new Color(102,102,102));
                }   
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(153,153,153));
            jlbItem.setBackground(new Color(153,153,153));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindeSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(102,102,102));
                jlbItem.setBackground(new Color(102,102,102));
            }
        }
    
    }
    
    private void setChangeBackground(String kind){
        for(DanhMuc item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJlb().setBackground(new Color(153,153,153));
                item.getJpn().setBackground(new Color(153,153,153));
            } else {
                item.getJlb().setBackground(new Color(102,102,102));
                item.getJpn().setBackground(new Color(102,102,102));
            }
        } 
    }
}
