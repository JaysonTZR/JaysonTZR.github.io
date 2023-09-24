/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

/**
 *
 * @author Zacha
 */
public class AdminRegisterStudent extends Admin{
    public AdminRegisterStudent(){
    }
        
    public void registerStudent(String studentUsername, String studentPassword){
        String[] studentDetails = {studentUsername, studentPassword};
        TextFileInteractor interactor = new TextFileInteractor(studentFilePath);
        interactor.appendData(studentDetails);
    }
}
