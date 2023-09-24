/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Zacha
 */
public class AdminStudentRecords extends Admin{
    private final String studentRecordsPath;
    private String name;
    private String dateOfBirth;
    private String roomID;
    private String contractStart;
    private String contractEnd;
    
    public AdminStudentRecords(){
        this.studentRecordsPath = "C:\\Users\\Zacha\\OneDrive\\Desktop\\StudentData.txt"; //change file path here
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getContractStart() {
        return contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public String getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }
    
    private String[] readStudentRecordsFile(){
        TextFileInteractor interactor = new TextFileInteractor(studentRecordsPath);
        return convertToStringArray(interactor.extractTextData());
    }
    
    //set name before using this method
    private void setDetails(){
        String[] detailsRecord = readStudentRecordsFile();
        int nameIndex = findIndex(detailsRecord, name);
        this.dateOfBirth = detailsRecord[nameIndex + 1];
        this.roomID = detailsRecord[nameIndex + 17];
        this.contractStart = detailsRecord[nameIndex + 14];
        this.contractEnd = detailsRecord[nameIndex + 15];
    }
    
    public void showAll() {
        String[] textArray = readStudentRecordsFile();
        // Create a JTextArea to display the text
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        // Add the text from the array to the text area
        for (String text : textArray) {
            textArea.append(text + "\n");
        }

        // Create a JScrollPane to make the text area scrollable
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a JOptionPane to show the scrollable pop-up
        JOptionPane.showMessageDialog(null, scrollPane, "Student Record", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void removeRecord(){
        boolean confirm = showConfirmationPopup("Are you sure you want to delete the record of " + name + "?");
        String[] detailsRecord = readStudentRecordsFile();
        int nameIndex = findIndex(detailsRecord, name);
        ArrayList<String> details = new ArrayList<>();
        details.addAll(Arrays.asList(detailsRecord));
        if(confirm){
            removeLines(nameIndex - 1, 18, details, studentRecordsPath);
        }
    }
    
    //order of details = name, date of birth, roomid, start date, end date
    //set name before using
    public void updateRecord(String[] newDetails){
        boolean confirm = showConfirmationPopup("Are you sure you want to update the details of " + name + "?");
        TextFileInteractor file = new TextFileInteractor(studentRecordsPath);
        setDetails();
        String[] details = {name, dateOfBirth, roomID, contractStart, contractEnd};
        if(confirm){
            for(int i = 0; i < details.length; i++){
                System.out.println("here");
                file.replaceData(details[i], newDetails[i]);
            }   
        }
    }
    
    public void lookupDetails(){
        String[] records = readStudentRecordsFile();
        boolean valid = checkIfInStringArray(name, records);
        if(valid){
            setDetails();
            System.out.println(dateOfBirth);
            System.out.println(roomID);
            System.out.println(contractStart);
            System.out.println(contractEnd);
        }
        else{
            showErrorPopup("Student not found");
        }
    }
}
