/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj.assignment;

import java.awt.Color;

/**
 *
 * @author Zacha
 */
public class Rooms extends javax.swing.JFrame {
    public static Rooms instance;

    /**
     * Creates new form Rooms
     */
    public Rooms() {
        initComponents();
        instance = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roomsToNavigationButton = new javax.swing.JToggleButton();
        statusLabel = new javax.swing.JLabel();
        roomTypeLabel = new javax.swing.JLabel();
        monthlyLabel = new javax.swing.JLabel();
        roomIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lookupRoomButton = new javax.swing.JToggleButton();
        typeField = new javax.swing.JTextField();
        monthlyField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        personalKitchenCheck = new javax.swing.JCheckBox();
        personalBathroomCheck = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        areaField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        genderField = new javax.swing.JTextField();
        deleteRoomButton = new javax.swing.JToggleButton();
        statusToggleButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Rooms");

        roomsToNavigationButton.setText("Back to navigaion");
        roomsToNavigationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsToNavigationButtonActionPerformed(evt);
            }
        });

        statusLabel.setForeground(new java.awt.Color(0, 0, 0));
        statusLabel.setText("Status:");

        roomTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        roomTypeLabel.setText("Room type:");

        monthlyLabel.setForeground(new java.awt.Color(0, 0, 0));
        monthlyLabel.setText("Monthly:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Enter room ID:");

        lookupRoomButton.setText("lookup");
        lookupRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookupRoomButtonActionPerformed(evt);
            }
        });

        updateButton.setText("update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        personalKitchenCheck.setForeground(new java.awt.Color(0, 0, 0));
        personalKitchenCheck.setText("Personal kitchen");
        personalKitchenCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalKitchenCheckActionPerformed(evt);
            }
        });

        personalBathroomCheck.setForeground(new java.awt.Color(0, 0, 0));
        personalBathroomCheck.setText("Personal bathroom");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Area:");

        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Gender:");

        deleteRoomButton.setText("delete");
        deleteRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomButtonActionPerformed(evt);
            }
        });

        statusToggleButton.setForeground(new java.awt.Color(255, 0, 0));
        statusToggleButton.setText("unavailable");
        statusToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(lookupRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(roomIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(37, 37, 37)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(monthlyLabel)
                                        .addComponent(statusLabel)
                                        .addComponent(roomTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(monthlyField)
                                .addComponent(areaField)
                                .addComponent(typeField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(genderField)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(statusToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(personalBathroomCheck)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(personalKitchenCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap()))
                    .addComponent(roomsToNavigationButton)
                    .addComponent(deleteRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(jLabel2)
                    .addComponent(statusToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(areaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomTypeLabel)
                    .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthlyLabel)
                    .addComponent(monthlyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lookupRoomButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(personalBathroomCheck)
                        .addComponent(personalKitchenCheck)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteRoomButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(roomsToNavigationButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lookupRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookupRoomButtonActionPerformed
        String roomID = roomIDField.getText();
        AdminRooms roomsProcesses = new AdminRooms(roomID);
        String[] roomDetails = roomsProcesses.lookupAllRoomsDetails();
        boolean status = roomsProcesses.availabilityCheck();
        String area = roomDetails[1];
        String roomType = roomDetails[2];
        String kitchen = roomDetails[3];
        String washroom = roomDetails[4];
        String gender = roomDetails[5];
        String monthly = roomDetails[6];
        areaField.setText(area);
        typeField.setText(roomType);
        genderField.setText(gender);
        monthlyField.setText(monthly);
        personalBathroomCheck.setSelected(washroom.equals("Yes"));
        personalKitchenCheck.setSelected(kitchen.equals("Yes"));
        statusToggleButton.setSelected(status);
        if(status){
            statusToggleButton.setForeground(Color.GREEN);
            statusToggleButton.setText("Available");
        }
        else{
            statusToggleButton.setForeground(Color.RED);
            statusToggleButton.setText("Available");
        }
    }//GEN-LAST:event_lookupRoomButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String roomID = roomIDField.getText();
        boolean status = statusToggleButton.isSelected();
        AdminRooms roomsProcesses = new AdminRooms(roomID);
        String kitchen = roomsProcesses.selectBoxToYesOrNo(personalKitchenCheck.isSelected());
        String bathroom = roomsProcesses.selectBoxToYesOrNo(personalBathroomCheck.isSelected());
        roomsProcesses.setArea(areaField.getText());
        roomsProcesses.setStatus(status);
        roomsProcesses.setGender(genderField.getText());
        roomsProcesses.setType(typeField.getText());
        roomsProcesses.setMonthly(monthlyField.getText());
        roomsProcesses.setKitchen(kitchen);
        roomsProcesses.setBathroom(bathroom);
        roomsProcesses.updateRoomData();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String roomID = roomIDField.getText();
        boolean status = statusToggleButton.isSelected();
        AdminRooms roomsProcesses = new AdminRooms(roomID);
        String kitchen = roomsProcesses.selectBoxToYesOrNo(personalKitchenCheck.isSelected());
        String bathroom = roomsProcesses.selectBoxToYesOrNo(personalBathroomCheck.isSelected());
        roomsProcesses.setArea(areaField.getText());
        roomsProcesses.setStatus(status);
        roomsProcesses.setGender(genderField.getText());
        roomsProcesses.setType(typeField.getText());
        roomsProcesses.setMonthly(monthlyField.getText());
        roomsProcesses.setKitchen(kitchen);
        roomsProcesses.setBathroom(bathroom);
        roomsProcesses.addRoomDetails();
    }//GEN-LAST:event_addButtonActionPerformed

    private void statusToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusToggleButtonActionPerformed
        boolean selected = statusToggleButton.isSelected();
        if(selected){
            statusToggleButton.setForeground(Color.GREEN);
            statusToggleButton.setText("Available");
        } else {
            statusToggleButton.setForeground(Color.RED);
            statusToggleButton.setText("Unavailable");
        }
    }//GEN-LAST:event_statusToggleButtonActionPerformed

    private void deleteRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomButtonActionPerformed
        String roomID = roomIDField.getText();
        AdminRooms roomsProcesses = new AdminRooms(roomID);
        roomsProcesses.deleteRoom();
    }//GEN-LAST:event_deleteRoomButtonActionPerformed

    private void roomsToNavigationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsToNavigationButtonActionPerformed
        Admin adminClass = new Admin();
        boolean confirmation = adminClass.showNavigation();
        if(confirmation){
            Rooms.instance.dispose();
        }
    }//GEN-LAST:event_roomsToNavigationButtonActionPerformed

    private void personalKitchenCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalKitchenCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personalKitchenCheckActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField areaField;
    private javax.swing.JToggleButton deleteRoomButton;
    private javax.swing.JTextField genderField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton lookupRoomButton;
    private javax.swing.JTextField monthlyField;
    private javax.swing.JLabel monthlyLabel;
    private javax.swing.JCheckBox personalBathroomCheck;
    private javax.swing.JCheckBox personalKitchenCheck;
    private javax.swing.JTextField roomIDField;
    private javax.swing.JLabel roomTypeLabel;
    private javax.swing.JToggleButton roomsToNavigationButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JToggleButton statusToggleButton;
    private javax.swing.JTextField typeField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
