/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.io.BufferedReader; //Import this class to read text from a character-input stream
import java.io.FileReader; //Import this class to read character files
import java.io.IOException;
import java.time.LocalDateTime; //Import this class to get year month day and hour minute second
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; //Import the ArrayList class
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class Payment extends Student{
    
    private JTextField roomID;
    private JLabel roomPrice;
    private JTextField paymentAmount;
    private JTextField payTo;
    private JLabel totalAmount1;
    private JLabel paidAmount;
    private JLabel balanceAmount;
    private JTextField name;
    private JComboBox month1;
    private JLabel totalAmount2;
    
    //Payment Page
    private int getRoomPrice() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/ExistingRoomInformationData.txt"));
            String line;
            boolean found = false;

            //Search for the RoomID
            while ((line = reader.readLine()) != null) {
                if (line.equals(roomID.getText())) {
                    found = true;
                    break;
                }
            }

            //If the RoomID was found, get the Room price
            if (found) {
                //Skip the next five lines
                for (int i = 0; i < 5; i++) {
                    reader.readLine();
                }
                //Get the Room price from the next line
                int price = Integer.parseInt(reader.readLine());
                reader.close();
                return price;
            } else {
                reader.close();
                return 0;
            }
        
        } catch (IOException | NumberFormatException ex) { //Print the stack trace of the exception if there is an error reading from the file
            ex.printStackTrace();                          //or the room price cannot be parse as a non-integer value
            return 0;
        }
    }
    
    public void proceedToPayment() {
        //Clear the text
        paymentAmount.setText("");
        payTo.setText("");
        totalAmount1.setText("");
        paidAmount.setText("");
        balanceAmount.setText("");
        
        int price = getRoomPrice();
        if (price > 0) {
            roomPrice.setText("RM" + price);
        } else {
            showErrorPopup("RoomID not found.");
        }
    }
    
    private int calculateBalance(int paymentAmount, int roomPrice, JLabel balanceAmountLabel) {
        int balance = paymentAmount - roomPrice;
        balanceAmountLabel.setText("RM" + balance);
        return balance;
    }
    
    private void insertPaymentData(String payTo, String roomId, String name, String month, String totalAmount) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = now.format(dateFormatter);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = now.format(timeFormatter);
        String[] stringList = {
            date, time, payTo, roomId, name, month, totalAmount,
        };
        //Insert data into text file
        TextFileInteractor insertData = new TextFileInteractor("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/PaymentReceiptInformation.txt");
        insertData.appendData(stringList);
    }
    
    public void payment(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/ExistingRoomInformationData.txt"));
            TextFileInteractor receiptData = new TextFileInteractor("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/PaymentReceiptInformation.txt");
            //Create an ArrayList that store data from text file
            ArrayList<String> data = receiptData.extractTextData();
            String line;
            String roomValue = "";
            String nameValue = "";
            String monthValue = "";
            boolean found = false;
            boolean success = false;
            
            //Search for the RoomID
            while ((line = reader.readLine()) != null) {
                if (line.equals(roomID.getText())) {
                    found = true;
                    break;
                }
            }

            //If the RoomID was found, get the Room price
            if (found) {
                //Skip the next five lines
                for (int j = 0; j < 5; j++) {
                    reader.readLine();
                }
                //Get the Room price from the next line
                int roomPrice = Integer.parseInt(reader.readLine());
                totalAmount2.setText("RM" + roomPrice);
                int PaymentAmount = Integer.parseInt(paymentAmount.getText());
                paidAmount.setText("RM" + PaymentAmount);
                //Payment process
                int balance = calculateBalance(PaymentAmount, roomPrice, balanceAmount);
                
                if (balance >= 0){
                    success = true;
                    if (success) {
                        //Check if the room was paid or not
                        for (int i = 0; i < data.size() - 6; i++) {
                            //Check if month, room and name matches
                            if (data.get(i + 3).equals(roomID.getText()) & 
                                    data.get(i + 4).equals(name.getText()) & 
                                        data.get(i + 5).equals((String) month1.getSelectedItem())) {
                                roomValue = roomID.getText();
                                nameValue = name.getText();
                                monthValue = (String) month1.getSelectedItem();
                            }
                        }
                        //If room was paid
                        if (roomValue.equals(roomID.getText()) & 
                                nameValue.equals(name.getText()) & 
                                    monthValue.equals((String) month1.getSelectedItem())) {
                            showErrorPopup("RoomID " + roomID.getText() + "'s fee in month " + month1.getSelectedItem().toString() + " was paid.");
                        } else { //If room was not paid
                            insertPaymentData(payTo.getText(), roomID.getText(), name.getText(), 
                                    (String) month1.getSelectedItem(), String.valueOf(roomPrice));
                            showConfirmationPopup("Payment successful.");
                        }
                    } else {
                        showErrorPopup("Payment failed.");
                    }
                } else {
                    showErrorPopup("Payment amount is insufficient.");
                }
            } else {
            showErrorPopup("RoomID not found.");
            }
            reader.close();
            
        } catch (IOException ex) { //Print the stack trace of the exception if there is an error reading from the file
            ex.printStackTrace();
        } catch (NumberFormatException ex) { //Print the stack trace of the exception if the room price cannot be parse as a non-integer value
            showErrorPopup("Room price not found.");
        }
    }
    
    public void setRoomID(JTextField roomID) {
        this.roomID = roomID;
    }

    public void setRoomPrice(JLabel roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setPaymentAmount(JTextField paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setPayTo(JTextField payTo) {
        this.payTo = payTo;
    }

    public void setTotalAmount1(JLabel totalAmount1) {
        this.totalAmount1 = totalAmount1;
    }

    public void setPaidAmount(JLabel paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setBalanceAmount(JLabel balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public void setMonth1(JComboBox month1) {
        this.month1 = month1;
    }

    public void setTotalAmount2(JLabel totalAmount2) {
        this.totalAmount2 = totalAmount2;
    }
}
