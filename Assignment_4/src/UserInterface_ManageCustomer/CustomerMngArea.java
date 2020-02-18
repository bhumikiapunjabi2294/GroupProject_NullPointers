/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface_ManageCustomer;

import Business.Abstract.User;
import UserInterface.LogoutScreen;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class CustomerMngArea extends javax.swing.JPanel {

    /**
     * Creates new form CustomerMngArea
     */
    private User user;
    List<User> list;
    JPanel panelRight;

     public CustomerMngArea(JPanel panelRight, User user) {
        initComponents();
        this.panelRight=panelRight;
        this.user = user;
       // initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnToFlightBook = new javax.swing.JButton();
        btnToPastBokng = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        btnToFlightBook.setText("Flight Booking");
        btnToFlightBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToFlightBookActionPerformed(evt);
            }
        });

        btnToPastBokng.setText("View Past Bookings");
        btnToPastBokng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToPastBokngActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Manage Customers");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(btnToPastBokng)
                .addGap(175, 175, 175))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnToFlightBook))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLogout))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnLogout)
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(btnToFlightBook)
                .addGap(45, 45, 45)
                .addComponent(btnToPastBokng)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnToFlightBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToFlightBookActionPerformed
        
        CardLayout layout = (CardLayout) panelRight.getLayout();
        panelRight.add(new FlightSearchArea(panelRight,user));
        layout.next(panelRight);
    }//GEN-LAST:event_btnToFlightBookActionPerformed

    private void btnToPastBokngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToPastBokngActionPerformed
        
        CardLayout layout = (CardLayout) panelRight.getLayout();
        panelRight.add(new ManageBookings(panelRight,user));
        layout.next(panelRight);
    }//GEN-LAST:event_btnToPastBokngActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        
        CardLayout layout = (CardLayout) panelRight.getLayout();
        panelRight.add(new LogoutScreen(user));
        layout.next(panelRight);
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnToFlightBook;
    private javax.swing.JButton btnToPastBokng;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}