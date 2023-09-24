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
public class AdminRooms extends Admin{
        private final String roomID;
        private boolean available;
        private String area, type, monthly, gender, kitchen, bathroom;
        private final String availableRoomsFile, existingRoomsFile;
        private final String[] filePaths;
        
        public AdminRooms(String roomID){
            this.roomID = roomID;
            this.availableRoomsFile = "C:\\Users\\Zacha\\OneDrive\\Desktop\\AvailableRoomInformationData.txt";
            this.existingRoomsFile = "C:\\Users\\Zacha\\OneDrive\\Desktop\\ExistingRoomInformationData.txt";
            this.filePaths = new String[]{existingRoomsFile, availableRoomsFile};
        }
        
        public boolean getStatus(){
            return this.available;
        }
        
        public void setStatus(boolean statoos){
            this.available = statoos;
        }
        
        public String getArea(){
            return this.area;
        }
        
        public void setArea(String ehRea){
            this.area = ehRea;
        }
        
        public String getType(){
            return this.type;
        }
        
        public void setType(String taip){
            this.type = taip;
        }
        
        public String getMonthly(){
            return this.monthly;
        }
        
        public void setMonthly(String monthlyFee){
            this.monthly = monthlyFee;
        }
        
        public String getGender(){
            return this.gender;
        }
        
        public void setGender(String boyGirl){
            this.gender = boyGirl;
        }
        
        public String getKitchen(){
            return this.kitchen;
        }
        
        public void setKitchen(String keechen){
            this.kitchen = keechen;
        }
        
        public String getBathroom(){
            return this.bathroom;
        }
        
        public void setBathroom(String batheRoom){
            this.bathroom = batheRoom;
        }
        
        private ArrayList<String> readRoomsFile(String filepath){
            ArrayList<String> roomsDetails = readFileContents(filepath);
            return roomsDetails;
        }
        
        private String[] readRoomIDs(ArrayList<String> roomDetails){
            int lengthOfDetails = roomDetails.size();
            ArrayList<String> IDs = new ArrayList();
            for(int i = 0; i <= lengthOfDetails - 6; i += 8){
                    String roomID = roomDetails.get(i);
                    IDs.add(roomID);
                }
            String[] roomIDs = convertToStringArray(IDs);
            return roomIDs;
        }
        
        private boolean validityCheck(){
            ArrayList<String> allRoomsDetails = readRoomsFile(existingRoomsFile);
            String[] roomIDs = readRoomIDs(allRoomsDetails);
            boolean isValid = checkIfInStringArray(roomID, roomIDs);
            return isValid;
        }
        
        public boolean availabilityCheck(){
            ArrayList<String> availableRoomDetails = readRoomsFile(availableRoomsFile);
            String[] vacantRooms = readRoomIDs(availableRoomDetails);
            boolean isVacant = checkIfInStringArray(roomID, vacantRooms);
            return isVacant;
        }
        
        public String selectBoxToYesOrNo(boolean selected){
            if(selected){
                return "Yes";
            }
            else{
                return "No";
            }
        }
        
        public String[] lookupAllRoomsDetails(){
            String[] roomDetails = new String[7];
            ArrayList<String> allRoomDetails = readRoomsFile(existingRoomsFile);
            int indexOfRoomID = allRoomDetails.indexOf(roomID);
            int c = 0;
            for(int i = indexOfRoomID ; i <= indexOfRoomID + 6; i++){
                roomDetails[c] = allRoomDetails.get(i);
                c++;
            }
            return roomDetails;
        }
        
        private void updateDetails(String filePath){
            boolean isAvailable = availabilityCheck();
            TextFileInteractor interactor = new TextFileInteractor(filePath);
            String[] oldRoomDetails = lookupAllRoomsDetails();
            String[] newDetails = {area, type, kitchen, bathroom, gender, monthly};
            for(int i = 1 ; i <= 6 ; i++){
                String newDetail = newDetails[i - 1];
                String oldDetail = oldRoomDetails[i];
                interactor.replaceData(oldDetail, newDetail);
            }
            if(isAvailable && available == false){
                clearDetails(availableRoomsFile);
            }
        }
        
        private void clearDetails(String file){
            ArrayList<String> fileContents = readRoomsFile(file);
            int roomIDIndex = fileContents.indexOf(roomID);
            Admin admin = new Admin();
            admin.removeLines(roomIDIndex, 7, fileContents, file);
        }
        
        public void deleteRoom(){
            boolean isValidRoom = validityCheck();
            String confirmationPrompt = "Are you sure you want to delete " + roomID + "? This cannot be reversed.";
            boolean deleteConfirmed = showConfirmationPopup(confirmationPrompt);
            if(isValidRoom){
                if(deleteConfirmed){
                    for(String file : filePaths){
                        clearDetails(file);
                    }
                    System.out.println("room deleted");
                }
            }else{showErrorPopup("RoomID not found");}    
        }
        
        public void updateRoomData(){
            boolean validRoom = validityCheck();
            boolean vacantRoom = availabilityCheck();
            if(validRoom && vacantRoom){
                String confirmationPrompt = "Are you sure you want to change the details of this room?: " + roomID;
                boolean confirmed = showConfirmationPopup(confirmationPrompt);
                if(confirmed){
                    for(String s : filePaths){
                        updateDetails(s);
                    }   
                }  
            } else if(validRoom){
                String confirmationPrompt = "Are you sure you want to change the details of this room?: " + roomID;
                boolean confirmed = showConfirmationPopup(confirmationPrompt);
                if(confirmed){
                    updateDetails(existingRoomsFile);
                }
            } else {
                showErrorPopup("RoomID not found");
            }

        }
        
        public void addRoomDetails(){
            boolean exists = validityCheck();
            if(exists){
                showErrorPopup("This roomID already exists");
            } else {
                String[] newDetails = {roomID, area, type, kitchen, bathroom, gender, monthly};
                for (String s : filePaths){
                    TextFileInteractor interactor = new TextFileInteractor(s);
                    interactor.appendData(newDetails);
                }
            }
        }
}
