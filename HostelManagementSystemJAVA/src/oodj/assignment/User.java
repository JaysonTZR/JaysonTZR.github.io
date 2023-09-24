/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.util.List; // Import the List class
import java.util.ArrayList; // Import the ArrayList class
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public abstract class User {
    protected List<String> adminUsernames;
    protected List<String> adminPasswords;
    protected List<String> studentUsernames;
    protected List<String> studentPasswords;
    protected String adminFilePath;
    protected String studentFilePath;
    public static String username;
    public static String password;
    
    public User(){
        this.adminFilePath = "C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/admins.txt";
        this.studentFilePath = "C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/students.txt";
        this.adminUsernames = sortLoginDetails(adminFilePath, "usernames");
        this.adminPasswords = sortLoginDetails(adminFilePath, "passwords");
        this.studentUsernames = sortLoginDetails(studentFilePath, "usernames");
        this.studentPasswords = sortLoginDetails(studentFilePath, "passwords");
    }
    
    private ArrayList<String> sortLoginDetails(String filePath, String dataType){
        ArrayList<String> details = new ArrayList<>();
        //call text File interactor class to extract data from "admins.txt"/"students.txt"
        TextFileInteractor loginDetailsFile = new TextFileInteractor(filePath);
        ArrayList<String> loginDetails = loginDetailsFile.extractTextData();
        int lengthOfLoginDetails = loginDetails.size();
        //trimming and getting rid of the "\n" for each line
        if(dataType == "usernames"){
           for(int i=0 ; i <= lengthOfLoginDetails - 3 ; i += 3){
               String username = loginDetails.get(i);
               details.add(username.trim());
           }
        }
        else if(dataType == "passwords"){
            for(int i=1; i <= lengthOfLoginDetails - 2; i +=3){
                String password = loginDetails.get(i);
                details.add(password.trim());
            }
        } else{System.out.println("an error has occured");}
        return details;
    }
    
    private boolean authenticateUser(String username, String password){
        //Check if the user is an admin
        for(int a = 0; a < adminUsernames.size(); a++){
            if ((username.equals(adminUsernames.get(a)) && password.equals(adminPasswords.get(a)))){
                return true;
            }
        }
        
        //Check if the user is an admin
        for(int b = 0; b < studentUsernames.size(); b++){
            if ((username.equals(studentUsernames.get(b)) && password.equals(studentPasswords.get(b)))){
                return true;
            }
        }
        //User authentication failed
        return false;
    }
    
    private String identifyUser(String username){
        boolean userFound = false;
        
        //Check if the user is an admin
        for(int a = 0; a <adminUsernames.size(); a++){
            if (username.equals(adminUsernames.get(a))){
                userFound = true;
                return "admin";
            }
        }
            
        //Check if the user is a student
        for(int b = 0; b <studentUsernames.size(); b++){
            if (username.equals(studentUsernames.get(b))){
                userFound = true;
                return "student";
            }
        }
        
        if(!userFound) {
            JOptionPane.showMessageDialog(null, "User not found.");
        }
        
        return null;
    }
    
    public void run(JTextField usernameField, JTextField passwordField) {
        //Get username and password from textfield
        username = usernameField.getText();
        password = passwordField.getText();

        // Authenticate the user
        boolean authenticated = authenticateUser(username, password);

        // Identify the user
        if (authenticated) {
            String userType = identifyUser(username);
            if (userType.equals("admin")) {
                new Navigation().setVisible(true);
            } else if (userType.equals("student")) {
                new Application_Page_Student().setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Unauthorized access. Please try again.");
        }
    }
    
    public void setUsername(JTextField usernameField){
        String youSername = usernameField.getText();
        this.username = youSername;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(JTextField passwordField){
        String passWord = passwordField.getText();
        this.password = passWord;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public abstract void showErrorPopup(String errorMessage);
    
    public abstract boolean showConfirmationPopup(String confirmPrompt);
}