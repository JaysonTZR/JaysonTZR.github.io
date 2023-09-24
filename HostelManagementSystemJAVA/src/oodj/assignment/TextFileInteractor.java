package oodj.assignment;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList; //Import the ArrayList class
import java.io.File;  //Import the File class
import java.io.FileNotFoundException;  //Import this class to handle errors
import java.util.Scanner; //Import the Scanner class to read text files
import java.io.FileWriter;   //Import the FileWriter class
import java.io.IOException;  //Import the IOException class to handle errors

/**
 *
 * @author Zacha
 */

public class TextFileInteractor {
    private String path;
    
    public TextFileInteractor(String filePath){
        path = filePath;
    }
    
    public ArrayList<String> extractTextData(){
        ArrayList<String> dataList = new ArrayList<String>(); // Create an ArrayList object
        try {
            File dataFile = new File(path);
            Scanner dataReader = new Scanner(dataFile);
            while(dataReader.hasNextLine()){
                String data = dataReader.nextLine();
                dataList.add(data);
            }
            dataReader.close();
            System.out.println("Data read successfully");
            return dataList;
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
            return dataList;
        }
    }
    
    public void appendData(String[] data){
        try {
            File dataFile = new File(path);
            FileWriter dataWriter = new FileWriter(dataFile, true);
            for(String i : data){
                dataWriter.write(i + "\n");
            }
            dataWriter.write("\n");
            dataWriter.close();
            System.out.println("Data stored successfully to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void clearTextFile(){
        File dataFile = new File(path);
        try {
            FileWriter writer = new FileWriter(dataFile);
            writer.write("");
            writer.flush();
            writer.close();
            System.out.println("Successfully cleared the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the file.");
            e.printStackTrace();
        }
    }
    
    public void replaceData(String oldData, String newData) {
        ArrayList<String> dataList = extractTextData();
        int index = dataList.indexOf(oldData + "\n");
        if (index != -1) {
            dataList.set(index, newData + "\n");
            clearTextFile();
            String[] dataArray = dataList.toArray(new String[dataList.size()]);
            appendData(dataArray);
            System.out.println("Data updated successfully");
        }
        else{
            System.out.println("An error occured while updating the data");
        }
    }
}
