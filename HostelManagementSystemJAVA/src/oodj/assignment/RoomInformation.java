/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.io.BufferedReader; //Import this class to read text from a character-input stream
import java.io.FileReader; //Import this class to read character files
import java.io.IOException;
import java.util.ArrayList; //Import the ArrayList class
import java.util.List; //Import the List class
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class RoomInformation {
    
    //Room Information Page
    public void showTextToTable_RI(JTable table) {
        String[] columnNames = {"RoomID", "Area", "Room Type", "Kitchen", "Washroom", "Roommate", "Monthly Rent"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);

        try {
            List<String[]> data = readDataFromFile();
            addDataToTable(data, model);
            table.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<String[]> readDataFromFile() throws IOException {
        List<String[]> data = new ArrayList<String[]>();
        FileReader RoomInformationData = new FileReader("C:/Users/USER/Desktop/OODJ Assignment/OODJ Assignment/AvailableRoomInformationData.txt");
        BufferedReader reader = new BufferedReader(RoomInformationData);

        String line;
        String[] rowData = new String[7];
        int rowIndex = 0;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                data.add(rowData);
                rowData = new String[7];
                rowIndex = 0;
            } else {
                rowData[rowIndex++] = line.trim();
            }
        }
        reader.close();

        return data;
    }

    private void addDataToTable(List<String[]> data, DefaultTableModel model) {
        for (String[] row : data) {
            model.addRow(row);
        }
    }
}
