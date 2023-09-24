/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.util.ArrayList;

/**
 *
 * @author Zacha
 */
public class AdminReport extends Admin{
    private final String receiptsFile;
    private String month;
    
    public AdminReport(){
        this.receiptsFile = "C:\\Users\\Zacha\\OneDrive\\Desktop\\PaymentReceiptInformation.txt"; //change file path here
    }
    
    public String getMonth(){
        return this.month;
    }
    
    public void setMonth(String selected){
        this.month = selected;
    }
    private String[] allReceipts(){
        TextFileInteractor interactor = new TextFileInteractor(receiptsFile);
        ArrayList<String> lines = interactor.extractTextData();
        String[] receipts = convertToStringArray(lines);
        return receipts;
    }
    
    //returns the index(es)/line number of the selected month within the file
    private int[] indexesOfMonth(){
        String[] receipts = allReceipts();
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        for(int i = 0; i < receipts.length; i++){
            String line = receipts[i];
            if(line.equals(month)){
                indexList.add(i);
            }
        }
        
        // Convert the ArrayList to an int array
        int[] indexArray = new int[indexList.size()];
        for (int i = 0; i < indexList.size(); i++) {
            indexArray[i] = indexList.get(i);
        }
        return indexArray;
    }
    
    private String[] namesOfPayers() {
    String[] receipts = allReceipts();
    int[] indexes = indexesOfMonth();
    String[] result = new String[indexes.length];

    for (int i = 0; i < indexes.length; i++) {
        int index = indexes[i] - 1;  // Adjust the index by subtracting one
        result[i] = receipts[index];
    }

    return result;
    }   
    
    private String[] rooms(){
        String[] receipts = allReceipts();
        int[] indexes = indexesOfMonth();
        String[] result = new String[indexes.length];

        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i] - 2;  // Adjust the index by subtracting one
            result[i] = receipts[index];
        }
        return result;
    }
    
    private int[] collectedAmounts(){
        String[] receipts = allReceipts();
        int[] indexes = indexesOfMonth();
        int[] result = new int[indexes.length];

        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i] + 1;  // Adjust the index by adding one
            result[i] = Integer.parseInt(receipts[index]);
        }

        return result;
    }
    
    public String totalCollected(){
        int sum = 0;
        int[] amounts = collectedAmounts();
        for(int amount: amounts){
            sum += amount;
        }
        String total = String.valueOf(sum);
        return total;
    }
    
    public String stringOfNames(){
        String nameString = "";
        String[] names = namesOfPayers();
        for(String s : names){
            int i = findIndex(names, s);
            if(i == names.length - 1){
                nameString += s;
            } else {nameString += s + ", ";}
        }
        if(nameString.equals("")){
            return "None";
        } else {return nameString;}
    }
    
    public String stringOfRoomIDs(){
        String roomsString = "";
        String[] ids = rooms();
        for(String s : ids){
            int i = findIndex(ids, s);
            if(i == ids.length - 1){
                roomsString += s;
            } else {roomsString += s + ", ";}
        }
        if(roomsString.equals("")){
            return "None";
        } else {return roomsString;}
    }
}
