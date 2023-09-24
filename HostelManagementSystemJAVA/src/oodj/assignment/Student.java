/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Student extends User{
    
    public Student() {
        
    }
    
    public void setLoginName(JLabel usernameLabel, JTextField name) {
        String username = User.username;
        usernameLabel.setText(username);
        name.setText(username);
    }

    @Override
    public void showErrorPopup(String errorMessage) {
        JOptionPane.showMessageDialog(null, "ERROR: " + errorMessage);
    }

    @Override
    public boolean showConfirmationPopup(String confirmPrompt) {
        JOptionPane.showMessageDialog(null, confirmPrompt);
        return false;
    }
}
