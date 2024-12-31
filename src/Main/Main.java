package Main;

import View.AdminJFrame;
import View.LoginForm;
import View.MainJFrame;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGrayIJTheme;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author asus
 */
public class Main {
    public static void main(String[] args){            
        FlatGrayIJTheme.setup();
        

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Table.showGrid", true);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
//        new AdminJFrame().setVisible(true);
//        new MainJFrame().setVisible(true);
        LoginForm lgform = new LoginForm();
        lgform.setVisible(true);

    }
}
