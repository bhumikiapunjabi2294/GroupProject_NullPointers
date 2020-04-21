/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AmbulanceRole;

import Business.Enterprise.Enterprise;
import Business.Organization.AmbulanceOrganization;
import Business.Organization.DoctorOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CallingESWorkRequest;
import Business.WorkQueue.PatientsAllocatedWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.PatientsInHospitalWorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yash
 */
public class AmbulanceWorkAreaJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private AmbulanceOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Enterprise e;
    private UserAccount ua;
    
    
    public AmbulanceWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, AmbulanceOrganization organization, Enterprise enterprise) {
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
         initComponents();
         populateTable();
    }
    
    public void populateTable(){
         DefaultTableModel model = (DefaultTableModel) patientjTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            
            Object[] row = new Object[7];
          //UserAccount u = ((PatientsAllocatedWorkRequest) request).getPatientAccount();
             ua = ((CallingESWorkRequest) request).getPatientAccount();
            System.out.println(ua);
            row[0] = request;
            row[1] = ua.getPersonalInformation().getName();
            System.out.println(ua.getPersonalInformation().getName());
            row[2] = ua.getPersonalInformation().getAddress();
            row[3] = ua.getPersonalInformation().getContactNum();
            row[4] = ((CallingESWorkRequest) request).getHospital();
            e = ((CallingESWorkRequest) request).getHospital();
            row[5] = request.getSender();
            row[6] = request.getStatus();
          
            
            model.addRow(row);
        }
    }

    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientjTable = new javax.swing.JTable();
        ProcessBtn = new javax.swing.JButton();
        DelivredButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ambulance on way!!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 11, -1, -1));

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Image/ambulance_coverGIF.gif"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        patientjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Patient Name", "Addrees", "Phone Number", "Hospital Name", "Doctor Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientjTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 610, 90));

        ProcessBtn.setBackground(new java.awt.Color(251, 251, 251));
        ProcessBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ProcessBtn.setText("Process");
        ProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessBtnActionPerformed(evt);
            }
        });
        add(ProcessBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, -1));

        DelivredButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        DelivredButton.setText("Delivered");
        DelivredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelivredButtonActionPerformed(evt);
            }
        });
        add(DelivredButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, -1, -1));

        refreshjButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });
        add(refreshjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void DelivredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelivredButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientjTable.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to complete the request ?", "Warning", dialogButton);
                    PatientsInHospitalWorkRequest request = new PatientsInHospitalWorkRequest();
                    request.addPatient(ua);
                    e.getWorkQueue().getWorkRequestList().add(request);
            if (dialogResult == JOptionPane.YES_OPTION) {
                WorkRequest req = (WorkRequest) patientjTable.getValueAt(selectedRow, 0);
                if (req.getStatus() == "Ambulance on the way!!!!!!") {
                    req.setStatus("Patient has been dropped to the hospital!!!");
                    populateTable();
//                    PatientsInHospitalWorkRequest request = new PatientsInHospitalWorkRequest();
//                    request.addPatient(ua);
//                    e.getWorkQueue().getWorkRequestList().add(request);
                } else if (req.getStatus() == "Patient has been dropped to the hospital!!!") {
                    JOptionPane.showMessageDialog(null, "Already Dropped Patient", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (req.getStatus() == "Ambulance assigned to pickup patient!!") {
                    JOptionPane.showMessageDialog(null, "Please First Process the Request", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DelivredButtonActionPerformed

    private void ProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = patientjTable.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to process the request ?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                WorkRequest req = (WorkRequest) patientjTable.getValueAt(selectedRow, 0);
                if (req.getStatus() == "Ambulance on the way!!!!!!") {
                    JOptionPane.showMessageDialog(null, "Already proceesed", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (req.getStatus() == "Patient has been dropped to the hospital!!!") {
                    JOptionPane.showMessageDialog(null, "Request is already completed", "Warning", JOptionPane.WARNING_MESSAGE);

                } else if (req.getStatus() == "Ambulance assigned to pickup patient!!") {
                    req.setStatus("Ambulance on the way!!!!!!");
                    populateTable();
                }
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_ProcessBtnActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        populateTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DelivredButton;
    private javax.swing.JButton ProcessBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientjTable;
    private javax.swing.JButton refreshjButton;
    // End of variables declaration//GEN-END:variables
}
