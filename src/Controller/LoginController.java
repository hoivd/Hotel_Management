/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import View.AdminJFrame;
import View.MainJFrame;
import javax.swing.JFrame;

/**
 *
 * @author TNo1
 */
public class LoginController {
    private User currentUser;
    public LoginController(User user){
        if(user.getRole().equals("user"))
        {
            MainJFrame frame = new MainJFrame();
            frame.setExtendedState( JFrame.MAXIMIZED_BOTH);
            frame.setUser(user);
            frame.setVisible(true);
        }
        else if (user.getRole().equals("admin"))             
        {
            AdminJFrame frame = new AdminJFrame();
            frame.setExtendedState( JFrame.MAXIMIZED_BOTH);
            frame.setUser(user);
            frame.setVisible(true);
        }
    }
    
}
