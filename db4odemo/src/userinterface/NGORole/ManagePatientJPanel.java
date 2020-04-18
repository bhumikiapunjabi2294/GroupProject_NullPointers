/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NGORole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.PatientRole;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.PatientsAllocatedWorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author yash
 */
public class ManagePatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePatientJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private Network network;
    
    
    public ManagePatientJPanel(JPanel userProcessContainer, Organization organization, Enterprise enterprise, UserAccount account, EcoSystem business,Network network) {
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
     
        initComponents();
        populatecombobox();
      //  populateDocCombo(enterprise);
    }
    private void populatecombobox(){
        HospitalJComboBox.removeAllItems();
        
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if(enterprise.getEnterpriseType().toString().equals("Hospital")){
                    HospitalJComboBox.addItem(enterprise);
                    //populateDocCombo(enterprise);
                    
                }
            }
        }
    }
    private void populateDocCombo(Enterprise en){
        doctorComboBox.removeAllItems();
        for (Organization organization : en.getOrganizationDirectory().getOrganizationList()) {
                    if (organization.getSupportedRole().toString().equals("[Business.Role.DoctorRole]")) {
//                        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
//                            doctorComboBox.addItem(employee.getName());
//                            //System.out.println(organization.getEmployeeDirectory().getEmployeeList());
//                        }
                    for(UserAccount u : organization.getUserAccountDirectory().getUserAccountList())
                    {
                        doctorComboBox.addItem(u.toString());
                    }
                    }
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

        NameLbl = new javax.swing.JLabel();
        UsernameLbl = new javax.swing.JLabel();
        PasswordLbl = new javax.swing.JLabel();
        NameTxt = new javax.swing.JTextField();
        UsernameTxt = new javax.swing.JTextField();
        PasswordTxt = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        HospitalJComboBox = new javax.swing.JComboBox();
        doctorComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NameLbl.setText("Name:");
        add(NameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 50, -1));

        UsernameLbl.setText("Username:");
        add(UsernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        PasswordLbl.setText("Password:");
        add(PasswordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        NameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTxtActionPerformed(evt);
            }
        });
        add(NameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 57, -1));
        add(UsernameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 57, -1));

        PasswordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTxtActionPerformed(evt);
            }
        });
        add(PasswordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 57, -1));

        AddBtn.setText("Add ");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });
        add(UpdateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, -1));

        jLabel1.setText("Select Hospital : ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        HospitalJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        HospitalJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HospitalJComboBoxActionPerformed(evt);
            }
        });
        add(HospitalJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        doctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboBoxActionPerformed(evt);
            }
        });
        add(doctorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        jLabel2.setText("Select doctor");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Image/symptoms-cough.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 420, 430));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Image/symptoms-fever.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/Image/symptoms-shortnessOfBreath.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 400, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void NameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTxtActionPerformed

    private void PasswordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTxtActionPerformed

    public UserAccount getUser(String s){
        System.out.println("popopopopopopopopopopopopopopopopopo");
         UserAccount a = new UserAccount();
         for(Network network : business.getNetworkList()){
             for(Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                 for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                     for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
                         if(s.equals(u.getUsername())){
                           a=u;
                            System.out.println(a);
                        }
                     }
                 }
             }
         }
         return a;
    }
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        String userName = UsernameTxt.getText();
        String password = PasswordTxt.getText();
        String Emp = NameTxt.getText();
        Employee employee = business.getEmployeeDirectory().createEmployee(NameTxt.getText());
        UserAccount ua = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, new PatientRole());
        
        
        String message = "";
        
        PatientsAllocatedWorkRequest request = new PatientsAllocatedWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        System.out.println(doctorComboBox.getSelectedItem());
        UserAccount o = getUser(doctorComboBox.getSelectedItem().toString());
   
        request.setReceiver(o);
        request.setStatus("Sent");
        request.setPatientAccount(ua);
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        o.getWorkQueue().getWorkRequestList().add(request);
        System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        
//        Organization org = null;
//        
//        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof DoctorOrganization){
//                org = organization;
//                
//                System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooo");
//                break;
//            }
//        }
//        if (org!=null){
//            org.getWorkQueue().getWorkRequestList().add(request);
//            userAccount.getWorkQueue().getWorkRequestList().add(request);
//            System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooo");
//        }
//
//      
      
    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorComboBoxActionPerformed

    private void HospitalJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HospitalJComboBoxActionPerformed
        Enterprise enterprise = (Enterprise) HospitalJComboBox.getSelectedItem();
        
        if(enterprise!= null){
             populateDocCombo(enterprise);
             
        }
        
       
    }//GEN-LAST:event_HospitalJComboBoxActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox HospitalJComboBox;
    private javax.swing.JLabel NameLbl;
    private javax.swing.JTextField NameTxt;
    private javax.swing.JLabel PasswordLbl;
    private javax.swing.JTextField PasswordTxt;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox<String> doctorComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
