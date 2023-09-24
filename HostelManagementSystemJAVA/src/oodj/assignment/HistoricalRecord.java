/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.io.BufferedReader; //Import this class to read text from a character-input stream
import java.io.FileReader; //Import this class to read character files
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static oodj.assignment.User.username;

/**
 *
 * @author USER
 */
public class HistoricalRecord extends Student{
    
    //Historical Record Page
    public void showTextToTable_AR_HR(JTable table) {
        String[] columnNames = {"Date", "Area", "Room Type", "Kitchen", "Washroom", "Roommate", "Duration of Stay"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);

        try {
            FileReader data = new FileReader("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/StudentData.txt");
            BufferedReader reader = new BufferedReader(data);
            String line;
            String[] rowData = new String[18];
            int rowIndex = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // End of row, add data to list and start new row
                    // Add the data into row only if it matches the username
                    if (rowData[1] != null && rowData[1].equals(username)) {
                        String[] displayData = {rowData[0], rowData[10], rowData[11], rowData[12], rowData[13], rowData[14], rowData[15] + "-" + rowData[16]};
                        model.addRow(displayData);
                    }
                    rowData = new String[18];
                    rowIndex = 0;
                } else {
                    processLine_AR(rowData, rowIndex, line);
                    rowIndex++;
                }
            }
            reader.close();

            // Add the last row of data to the table
            String[] displayData = {rowData[0], rowData[10], rowData[11], rowData[12], rowData[13], rowData[14], rowData[15] + "-" + rowData[16]};
            model.addRow(displayData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void processLine_AR(String[] rowData, int rowIndex, String line) {
        switch (rowIndex) {
            case 0: // date
                rowData[0] = line.trim();
                break;
            case 1: // name
                rowData[1] = line.trim();
                break;
            case 2: // dob
                rowData[2] = line.trim();
                break;
            case 3: // gender
                rowData[3] = line.trim();
                break;
            case 4: // nationality
                rowData[4] = line.trim();
                break;
            case 5: // contact number
                rowData[5] = line.trim();
                break;
            case 6: // email address
                rowData[6] = line.trim();
                break;
            case 7: // course of study
                rowData[7] = line.trim();
                break;
            case 8: // total years of study
                rowData[8] = line.trim();
                break;
            case 9: // current year of study
                rowData[9] = line.trim();
                break;
            case 10: // area
                rowData[10] = line.trim();
                break;
            case 11: // room type
                rowData[11] = line.trim();
                break;
            case 12: // kitchen
                rowData[12] = line.trim();
                break;
            case 13: // washroom
                rowData[13] = line.trim();
                break;
            case 14: // roommate
                rowData[14] = line.trim();
                break;
            case 15: // date of start staying
                rowData[15] = line.trim();
                break;
            case 16: // day of end staying
                rowData[16] = line.trim();
                break;
            case 17: // comment
                rowData[17] = line.trim();
                break;
            default:
                break;
        }
    }
    
    public void showTextToTable_PR_HR(JTable table){
        String[] columnNames = {"Date", "Time", "RoomID", "Month", "Amount (RM)", "Paid to"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);
        
        try {
            FileReader data = new FileReader("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/PaymentReceiptInformation.txt");
            BufferedReader reader = new BufferedReader(data);
            String line;
            String[] rowData = new String[7];
            int rowIndex = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    //End of row, add data to list and start new row
                    //Add the data into row only if it matches the username
                    if (rowData[4].equals(username)) {
                        String[] displayData = {rowData[0], rowData[1], rowData[3], rowData[5], rowData[6], rowData[2]};
                        model.addRow(displayData);
                    }
                    rowData = new String[7];
                    rowIndex = 0;
                } else {
                    processLine_PR(rowData, rowIndex, line);
                    rowIndex++;
                }
            }
            reader.close();

            //Add the last row of data to the table
            String[] displayData = {rowData[0], rowData[1], rowData[3], rowData[5], rowData[6], rowData[2]};
            model.addRow(displayData);
        } catch (Exception ex) { //Print the stack trace of the exception
            ex.printStackTrace();
        }
    }
        
    private void processLine_PR(String[] rowData, int rowIndex, String line) {
        switch (rowIndex) {
            case 0: //date
                rowData[0] = line.trim();
                break;
            case 1: //time
                rowData[1] = line.trim();
                break;
            case 2: //paid to
                rowData[2] = line.trim();
                break;
            case 3: //roomid
                rowData[3] = line.trim();
                break;
            case 4: //name
                rowData[4] = line.trim();
                break;
            case 5: //month
                rowData[5] = line.trim();
                break;
            case 6: //amount
                rowData[6] = line.trim();
                break;
            default:
                break;
        }
    }
}
