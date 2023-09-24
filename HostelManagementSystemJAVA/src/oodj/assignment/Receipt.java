/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.util.ArrayList; //Import the ArrayList class
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Receipt {
    
    //Receipt Page
    private JLabel date;
    private JLabel time;
    private JLabel receivedFrom;
    private JLabel amount;
    private JLabel paidTo;
    private JLabel description1;
    private JLabel description2;
    private JTextField roomID;
    private JComboBox<String> month;
    private JTextField name;
    
    private ArrayList<String> extractDataFromFile() {
        TextFileInteractor receiptData = new TextFileInteractor("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/PaymentReceiptInformation.txt");
        return receiptData.extractTextData();
    }
    
    public void receiptData() {
        ArrayList<String> data = extractDataFromFile();
        //Create an ArrayList with the size of 7
        ArrayList<String> dataStore = new ArrayList<String>(7);
    
        //Iterate through data to check the following condition
        for (int i = 0; i < data.size() - 6; i++) {
            //Check if month, room and name matches
            if (data.get(i + 3).equals(roomID.getText()) & 
                    data.get(i + 4).equals(name.getText()) & 
                    data.get(i + 5).equals(month.getSelectedItem())) {
                //Loop and store all the elements in dataStore ArrayList
                for (int j = i; j <= i + 6; j++) {
                    String elementAsString = data.get(j);
                    dataStore.add(elementAsString);
                }
                break;
            }
        }
    
        updateReceiptDialog(dataStore);
    }
 
    private void updateReceiptDialog(ArrayList<String> dataStore) {
        date.setText(dataStore.get(0));
        time.setText(dataStore.get(1));
        receivedFrom.setText(dataStore.get(4));
        amount.setText("RM" + dataStore.get(6));
        paidTo.setText(dataStore.get(2));
        description1.setText("Payment for " + dataStore.get(5));
        description2.setText("RoomID: " + dataStore.get(3));
    }

    public void setDate(JLabel date) {
        this.date = date;
    }

    public void setTime(JLabel time) {
        this.time = time;
    }

    public void setReceivedFrom(JLabel receivedFrom) {
        this.receivedFrom = receivedFrom;
    }

    public void setAmount(JLabel amount) {
        this.amount = amount;
    }

    public void setPaidTo(JLabel paidTo) {
        this.paidTo = paidTo;
    }

    public void setDescription1(JLabel description1) {
        this.description1 = description1;
    }

    public void setDescription2(JLabel description2) {
        this.description2 = description2;
    }

    public void setRoomID(JTextField roomID) {
        this.roomID = roomID;
    }

    public void setMonth(JComboBox<String> month) {
        this.month = month;
    }

    public void setName(JTextField name) {
        this.name = name;
    }
}
