/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.EmergencyServicesEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EmergencyServicesManagerOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Role.EmergencyServicesManagerRole;
import Business.UserAccount.UserAccount;
import Business.VitalSign.VitalSign;
import Business.WorkQueue.CallingESWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.PatientsAllocatedWorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yash
 */
public class CheckPatientsWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form CheckPatientsWorkArea
     *
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem business;
    private final Enterprise enterprise;
    private UserAccount docAccount;

    public CheckPatientsWorkArea(JPanel userProcessContainer, UserAccount account, UserAccount docAccount, EcoSystem business, Enterprise enterprise) {

        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.docAccount = docAccount;
        this.business = business;
        this.enterprise = enterprise;
        initComponents();

        populateTable();
        GoodCndtnRadioButton.isSelected();

    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) VitalSignsJTable.getModel();
        //System.out.println(account.getPatientAccount().getVitalSignHistory().getVitalSigns());
        model.setRowCount(0);
        for (VitalSign vitalSign : account.getPatientAccount().getVitalSignHistory().getVitalSigns()) {
            //System.out.println(vitalSign);
            Object[] row = new Object[7];
            row[0] = vitalSign.getBodyTemperature();
            row[2] = vitalSign.getRespiratoryRate();
            row[3] = vitalSign.getCoughType();
            row[1] = vitalSign.getHeadache();
            row[4] = vitalSign.getMusclePain();
            row[5] = vitalSign.getDate();
            row[6] = vitalSign;
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

        chooseOption = new javax.swing.ButtonGroup();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        VitalSignsJTable = new javax.swing.JTable();
        submitBtn = new javax.swing.JButton();
        GoodCndtnRadioButton = new javax.swing.JRadioButton();
        badCndtnRadioButton = new javax.swing.JRadioButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        VitalSignsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Body Temp", "Headache", "Respiratory Rate", "Cough Type", "Muscle Pain", "Date", "Health Conditions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(VitalSignsJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 800, 90));

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        chooseOption.add(GoodCndtnRadioButton);
        GoodCndtnRadioButton.setText("Good condition");
        add(GoodCndtnRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        chooseOption.add(badCndtnRadioButton);
        badCndtnRadioButton.setText("Bad condition");
        badCndtnRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badCndtnRadioButtonActionPerformed(evt);
            }
        });
        add(badCndtnRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        int selectedRow = VitalSignsJTable.getSelectedRow();
        //account.get
        if (selectedRow < 0) {
            return;
        }

        // PatientsAllocatedWorkRequest request = (PatientsAllocatedWorkRequest)patientsListJTable.getValueAt(selectedRow, 0);
        VitalSign sign = (VitalSign) VitalSignsJTable.getValueAt(selectedRow, 6);
        

            sign.setStatus("yes");
            String s;
            if (GoodCndtnRadioButton.isSelected()) {
                s = GoodCndtnRadioButton.getText();
            } else {
                s = badCndtnRadioButton.getText();

            }

            sign.setHealthCondition(s);

            //System.out.println(s);
            populateTable();

            if (s == "Bad condition") {
                CallingESWorkRequest ws = new CallingESWorkRequest();
                ws.setSender(docAccount);
                ws.setStatus("Patient is Infected,please send ambulance");
                ws.setPatientAccount(account);
                ws.setHospital(enterprise);
                account.getPatientAccount().setCondition("Patient is Infected,please send ambulance");

                Organization org = null;
                for (Network n : business.getNetworkList()) {

                    for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            //System.out.println(o);
                            if (o instanceof EmergencyServicesManagerOrganization) {
                                org = o;

                                break;
                            }
                        }
                        // System.out.println(org+"bhbjjuhhgggjkkkkkk" );

                        if (org != null) {
                            // System.out.println(org + "yash thakkar");
                            org.getWorkQueue().getWorkRequestList().add(ws);
                            account.getWorkQueue().getWorkRequestList().add(ws);
                            System.out.println(org.getWorkQueue().getWorkRequestList());
                            break;
                        }

                    }
                    break;
                }
            } else if (s == "Good condition") {
                CallingESWorkRequest ws = new CallingESWorkRequest();
                ws.setStatus("Patient is Normal! No worries");
                account.getPatientAccount().setCondition("Patient is Normal! No worries");
            }
         else {
            JOptionPane.showMessageDialog(null, "this vital sign is already reviewed");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void badCndtnRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badCndtnRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_badCndtnRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton GoodCndtnRadioButton;
    private javax.swing.JTable VitalSignsJTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JRadioButton badCndtnRadioButton;
    private javax.swing.ButtonGroup chooseOption;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
