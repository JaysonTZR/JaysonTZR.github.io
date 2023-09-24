/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author USER
 */
public class HostelApplicationForm {
    
    //Hostel Application Page
    private JTextField date;
    private JTextField name;
    private JTextField dob;
    private JComboBox gender;
    private JTextField nationality;
    private JTextField cnumber;
    private JTextField eaddress;
    private JTextField costudy;
    private JComboBox tyostudy;
    private JComboBox cyostudy;
    private JRadioButton area1;
    private JRadioButton area2;
    private JRadioButton rtype1;
    private JRadioButton rtype2;
    private JRadioButton rtype3;
    private JToggleButton kitchen;
    private JToggleButton washroom;
    private JComboBox roommate;
    private JTextField dossdate;
    private JTextField dosedate;
    private JTextArea comment;
    
    public void saveTextToFile() {
        String[] stringList = createStringList();
        saveDataToFile(stringList);
        openApplicationPage();
    }

    private String[] createStringList() {
        String[] stringList = new String[19];
        stringList[0] = "Pending";
        JTextField[] fields = {date, name, dob, nationality, cnumber, eaddress, costudy, dossdate, dosedate};

        for (int i = 0; i < fields.length; i++) {
            stringList[i + 1] = fields[i].getText();
        }

        stringList[4] = (String) gender.getSelectedItem();
        stringList[9] = (String) tyostudy.getSelectedItem();
        stringList[10] = (String) cyostudy.getSelectedItem();
        stringList[11] = area1.isSelected() ? area1.getText() : area2.getText();
        stringList[12] = rtype1.isSelected() ? rtype1.getText() : (rtype2.isSelected() ? rtype2.getText() : rtype3.getText());
        stringList[13] = kitchen.isSelected() ? "Yes" : "No";
        stringList[14] = washroom.isSelected() ? "Yes" : "No";
        stringList[15] = (String) roommate.getSelectedItem();
        stringList[18] = comment.getText();

        return stringList;
    }

    private void saveDataToFile(String[] stringList) {
        TextFileInteractor insertData = new TextFileInteractor("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/PendingApplication.txt");
        insertData.appendData(stringList);
    }

    private void openApplicationPage() {
        new Application_Page_Student().setVisible(true);
    }

    public void setDate(JTextField date) {
        this.date = date;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public void setDob(JTextField dob) {
        this.dob = dob;
    }

    public void setGender(JComboBox gender) {
        this.gender = gender;
    }

    public void setNationality(JTextField nationality) {
        this.nationality = nationality;
    }

    public void setCnumber(JTextField cnumber) {
        this.cnumber = cnumber;
    }

    public void setEaddress(JTextField eaddress) {
        this.eaddress = eaddress;
    }

    public void setCostudy(JTextField costudy) {
        this.costudy = costudy;
    }

    public void setTyostudy(JComboBox tyostudy) {
        this.tyostudy = tyostudy;
    }

    public void setCyostudy(JComboBox cyostudy) {
        this.cyostudy = cyostudy;
    }

    public void setArea1(JRadioButton area1) {
        this.area1 = area1;
    }

    public void setArea2(JRadioButton area2) {
        this.area2 = area2;
    }

    public void setRtype1(JRadioButton rtype1) {
        this.rtype1 = rtype1;
    }

    public void setRtype2(JRadioButton rtype2) {
        this.rtype2 = rtype2;
    }

    public void setRtype3(JRadioButton rtype3) {
        this.rtype3 = rtype3;
    }

    public void setKitchen(JToggleButton kitchen) {
        this.kitchen = kitchen;
    }

    public void setWashroom(JToggleButton washroom) {
        this.washroom = washroom;
    }

    public void setRoommate(JComboBox roommate) {
        this.roommate = roommate;
    }

    public void setDossdate(JTextField dossdate) {
        this.dossdate = dossdate;
    }

    public void setDosedate(JTextField dosedate) {
        this.dosedate = dosedate;
    }

    public void setComment(JTextArea comment) {
        this.comment = comment;
    }
}
