/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.util.ArrayList; //Import the ArrayList class
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static oodj.assignment.User.username;

/**
 *
 * @author USER
 */
public class PersonalApplicationForm extends Student{
    
    //Personal Application Page
    private JLabel roomAssigned;
    private JTextField date;
    private JTextField dob;
    private JTextField gender;
    private JTextField nationality;
    private JTextField cnumber;
    private JTextField eaddress;
    private JTextField costudy;
    private JTextField tyostudy;
    private JTextField cyostudy;
    private JRadioButton area1;
    private JRadioButton area2;
    private JRadioButton rtype1;
    private JRadioButton rtype2;
    private JRadioButton rtype3;
    private JTextField kitchen;
    private JTextField washroom;
    private JTextField roommate;
    private JTextField dossdate;
    private JTextField dosedate;
    private JTextArea comment;

    public void displayStudentData() {
        ArrayList<String> dataStore = getDataStore(date.getText());
    
        if (dataStore.isEmpty()) {
            showErrorPopup("Date not found.");
            return;
        }
    
        setStudentData(dataStore);
    }

    private ArrayList<String> getDataStore(String date) {
        TextFileInteractor displayData = new TextFileInteractor("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/StudentData.txt");
        ArrayList<String> data = displayData.extractTextData();
        ArrayList<String> dataStore = new ArrayList<String>(18);
        boolean found = false;

        for (int i = 0; i < data.size() - 18; i++) {
            if (data.get(i).equals(date) & data.get(i + 1).equals(username)) {
                found = true;
                for (int j = i + 1; j <= i + 18; j++) {
                    String elementAsString = data.get(j);
                    dataStore.add(elementAsString);
                }
                break;
            }
        }
    
        return dataStore;
    }

    private void setStudentData(ArrayList<String> dataStore) {
        dob.setText(dataStore.get(1));
        gender.setText(dataStore.get(2));
        nationality.setText(dataStore.get(3));
        cnumber.setText(dataStore.get(4));
        eaddress.setText(dataStore.get(5));
        costudy.setText(dataStore.get(6));
        tyostudy.setText(dataStore.get(7));
        cyostudy.setText(dataStore.get(8));

        switch (dataStore.get(9)) {
            case "On-campus":
                area1.setSelected(true);
                break;
            case "Off-campus":
                area2.setSelected(true);
                break;
            default:
                break;
        }

        switch (dataStore.get(10)) {
            case "Single":
                rtype1.setSelected(true);
                break;
            case "Twin":
                rtype2.setSelected(true);
                break;
            case "Triple":
                rtype3.setSelected(true);
                break;
            default:
                break;
        }

        kitchen.setText(dataStore.get(11));
        washroom.setText(dataStore.get(12));
        roommate.setText(dataStore.get(13));
        dossdate.setText(dataStore.get(14));
        dosedate.setText(dataStore.get(15));
        comment.setText(dataStore.get(16));
        roomAssigned.setText(dataStore.get(17));
    }
    
    public void setRoomAssigned(JLabel roomAssigned) {
        this.roomAssigned = roomAssigned;
    }

    public void setDate(JTextField date) {
        this.date = date;
    }

    public void setDob(JTextField dob) {
        this.dob = dob;
    }

    public void setGender(JTextField gender) {
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

    public void setTyostudy(JTextField tyostudy) {
        this.tyostudy = tyostudy;
    }

    public void setCyostudy(JTextField cyostudy) {
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

    public void setKitchen(JTextField kitchen) {
        this.kitchen = kitchen;
    }

    public void setWashroom(JTextField washroom) {
        this.washroom = washroom;
    }

    public void setRoommate(JTextField roommate) {
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
