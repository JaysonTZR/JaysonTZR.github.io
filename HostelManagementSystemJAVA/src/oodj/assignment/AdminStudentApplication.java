/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Zacha
 */
public class AdminStudentApplication extends Admin{
        private final String studentDataFile;
        private final String availableRoomsFile;
        private final String applicationDataFile;
        //application details
        private String status, dateSubmitted, name, birthDate, gender,
                nationality, contact, email, course, courseLength, currentYear,
                roomLocation, roomType, kitchen, washroom, roomateGender, 
                contractStartDate, contractEndDate, comments;
        
        public AdminStudentApplication(){
            this.studentDataFile = "C:\\Users\\Zacha\\OneDrive\\Desktop\\StudentData.txt";
            this.availableRoomsFile = "C:\\Users\\Zacha\\OneDrive\\Desktop\\AvailableRoomInformationData.txt";
            this.applicationDataFile = "C:\\Users\\Zacha\\OneDrive\\Desktop\\PendingApplication.txt";
        }
        
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDateSubmitted() {
            return dateSubmitted;
        }

        public void setDateSubmitted(String dateSubmitted) {
            this.dateSubmitted = dateSubmitted;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getCourseLength() {
            return courseLength;
        }

        public void setCourseLength(String courseLength) {
            this.courseLength = courseLength;
        }

        public String getCurrentYear() {
            return currentYear;
        }

        public void setCurrentYear(String currentYear) {
            this.currentYear = currentYear;
        }

        public String getRoomLocation() {
            return roomLocation;
        }

        public void setRoomLocation(String roomLocation) {
            this.roomLocation = roomLocation;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public String getKitchen() {
            return kitchen;
        }

        public void setKitchen(String kitchen) {
            this.kitchen = kitchen;
        }

        public String getWashroom() {
            return washroom;
        }

        public void setWashroom(String washroom) {
            this.washroom = washroom;
        }

        public String getRoomateGender() {
            return roomateGender;
        }

        public void setRoomateGender(String roomateGender) {
            this.roomateGender = roomateGender;
        }

        public String getContractStartDate() {
            return contractStartDate;
        }

        public void setContractStartDate(String contractStartDate) {
            this.contractStartDate = contractStartDate;
        }

        public String getContractEndDate() {
            return contractEndDate;
        }

        public void setContractEndDate(String contractEndDate) {
            this.contractEndDate = contractEndDate;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }
        
        //student data
        private String[] readStudentDataFile(){
            ArrayList<String> studentsDataAL = readFileContents(studentDataFile);
            String[] studentData = convertToStringArray(studentsDataAL);
            return studentData;
        }
        
        //available rooms data
        private String[] readAvailableRoomsData(){
            ArrayList<String> availableRoomsDetails = readFileContents(availableRoomsFile);
            String[] details = convertToStringArray(availableRoomsDetails);
            return details;
        }
        
        //application data
        private String[] readApplicationData(){
            ArrayList<String> data = readFileContents(applicationDataFile);
            String[] applicationData = convertToStringArray(data);
            return applicationData;
        }
        
        //student names
        private String[] isolateStudentNames(){
            String[] applications = readApplicationData();
            int applicationsLength = applications.length;
            int c = 0;
            String[] names = new String[applicationsLength/20];
            for(int i = 2; i < applicationsLength; i += 20){
                names[c] = applications[i];
                c++;
            }
            return names;
        }
        
        // application details
        private String[] studentApplicationDetails(){
            String[] applicationDetails = readApplicationData();
            String[] studentAppDetails = new String[19];
            int indexOfName = findIndex(applicationDetails, name);
            int c = 0;
            for(int i = indexOfName - 2; i <= indexOfName + 16; i++){
                studentAppDetails[c] = applicationDetails[i];
                c++;
            }
            return studentAppDetails;
        }
        
        public void setDetails(){
            String[] applicationDetails = studentApplicationDetails();
            setDateSubmitted(applicationDetails[1]);
            setBirthDate(applicationDetails[3]);
            setGender(applicationDetails[4]);
            setComments(applicationDetails[18]);
            setNationality(applicationDetails[5]);
            setContact(applicationDetails[6]);
            setEmail(applicationDetails[7]);
            setCourse(applicationDetails[8]);
            setCourseLength(applicationDetails[9]);
            setCurrentYear(applicationDetails[10]);
            setRoomLocation(applicationDetails[11]);
            setRoomType(applicationDetails[12]);
            setKitchen(applicationDetails[13]);
            setWashroom(applicationDetails[14]);
            setRoomateGender(applicationDetails[15]);
            setContractStartDate(applicationDetails[16]);
            setContractEndDate(applicationDetails[17]);
        }
        
        private void removeApplication(){
            ArrayList<String> fileContents = readFileContents(applicationDataFile);
            int statusIndex = fileContents.indexOf(name) - 2;
            Admin admin = new Admin();
            admin.removeLines(statusIndex, 18, fileContents, applicationDataFile);
        }
        
        public void showRooms() {
            String[] roomsData = readAvailableRoomsData();
            StringBuilder messageBuilder = new StringBuilder();
            for (String s : roomsData) {
                messageBuilder.append(s).append("\n");
            }
            String message = messageBuilder.toString();

            JTextArea textArea = new JTextArea(message);
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));

            JOptionPane.showMessageDialog(null, scrollPane);
        }
        
        //set student name before using, use members to fill fields and labels
        public void lookupApplication(){ 
            boolean isApplicant = checkIfInStringArray(name, isolateStudentNames());
            if(isApplicant){
                setDetails();
            }
            else{
                showErrorPopup("Applicant not found");
            }
        }
        
        //set student name before using
        public void rejectApplication(){
            boolean exists = checkIfInStringArray(name, isolateStudentNames());
            boolean sure = showConfirmationPopup("Are you sure you want to reject " + name + "'s application?");
            if(sure && exists){removeApplication();}
        }
        
        //set student name before using
        public void acceptApplication(String roomID){
            TextFileInteractor interactor = new TextFileInteractor(studentDataFile);
            boolean sure = showConfirmationPopup("Are you sure you want to accept " + name + "'s application?");
            if(sure){
                String[] applicationDetails = studentApplicationDetails();
                String[] studentDetails = new String[applicationDetails.length - 1];
                int c = 0;
                applicationDetails[0] = applicationDetails[1];
                applicationDetails[applicationDetails.length - 1] = roomID;
                for(int i = 1; i < applicationDetails.length; i++){
                    String detail = applicationDetails[i];
                    studentDetails[c] = detail;
                    c++;
                }
            interactor.appendData(studentDetails);
            removeApplication();
            }

        }
}
