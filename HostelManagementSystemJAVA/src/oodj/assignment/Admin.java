/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj.assignment;

import javax.swing.JOptionPane;
import java.util.ArrayList; // import the ArrayList class
/**
 *
 * @author Zacha
 */
public class Admin extends User{
    
    public Admin(){
    }
    
    @Override
    public void showErrorPopup(String errorMessage) {
        JOptionPane.showMessageDialog(null, "ERROR: " + errorMessage);
    }
    
    @Override
    public boolean showConfirmationPopup(String confirmPrompt) {
        int choice = JOptionPane.showConfirmDialog(null,confirmPrompt);
        return choice == JOptionPane.YES_OPTION;
    }
    
    protected void openChosenPage(String pageName){
        try{
            switch (pageName) {
            case "Rooms":
                new Rooms().setVisible(true);
                Navigation.instance.setVisible(false);
                break;
            case "Student Applications":
                new StudentApplications().setVisible(true);
                Navigation.instance.setVisible(false);
                break;
            case "Student Records":
                new StudentRecords().setVisible(true);
                Navigation.instance.setVisible(false);
                break;
            case "Register Student":
                new RegisterStudent().setVisible(true);
                Navigation.instance.setVisible(false);
                break;
            case "Report":
                new Report().setVisible(true);
                Navigation.instance.setVisible(false);
                break;
            default:
                break;
            }
        } catch(NullPointerException e){
            showErrorPopup("No page selected");
        }
    }
    
    public boolean showNavigation(){
        String confirmationMessage = "Are you sure you want to return to navigation?";
        boolean confirmation = showConfirmationPopup(confirmationMessage);
        if(confirmation){
            new Navigation().setVisible(true);
            return confirmation;
        }
        else{
            System.out.println("login cancelled");
            return confirmation;
        }
    }
    
    public void removeLines(int anchorIndex, int numberOfLines, ArrayList<String> contents, String path) {
        TextFileInteractor interactor = new TextFileInteractor(path);

        for (int i = 0; i <= numberOfLines; i++) {
            System.out.println(i);
            contents.remove(anchorIndex);
        }

        int lastIndex = contents.size() - 2;  // Get the index of the last set of data
        System.out.println(lastIndex);
        if (anchorIndex == 0) {
            contents.remove(0);
            contents.remove(lastIndex);  // Remove the last set of data
        } else if (anchorIndex == lastIndex) {
            contents.remove(anchorIndex - 1);  // Remove the set of data before the anchor
            contents.remove(lastIndex);  // Remove the last set of data
        } else {
            contents.remove(anchorIndex - 1);  // Remove the set of data before the anchor
            contents.remove(lastIndex - 1);  // Remove the set of data after the anchor
        }

        String[] newFileContents = new String[contents.size()];
        newFileContents = contents.toArray(newFileContents);
        interactor.clearTextFile();
        interactor.appendData(newFileContents);
    }

    
    protected String[] convertToStringArray(ArrayList<String> al){
        String[] array = new String[al.size()];
        array = al.toArray(array);
        return array;
    }
    
    protected boolean checkIfInStringArray(String element, String[] array){
        boolean isInArray = false;
        for (String s : array){

            if(s.equals(element)){
                isInArray = true;
                break;
            }
        }
        return isInArray;
    }
    
    protected ArrayList<String> readFileContents(String path){
        TextFileInteractor reader = new TextFileInteractor(path);
        ArrayList<String> contents = reader.extractTextData();
        return contents;
    }
    
    protected int findIndex(String arr[], String s)
    {
        int index = 0;
        for(String element : arr){
            if(element.equals(s)){
                return index;
            }
            else{
                index++;
            }
        }
        // if the element is not in the array
        System.out.println("Element is not in array");
        return -1;
    }
    
    
}
