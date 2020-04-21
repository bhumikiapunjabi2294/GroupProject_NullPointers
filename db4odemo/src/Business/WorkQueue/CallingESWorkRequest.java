/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Yash
 */
public class CallingESWorkRequest extends WorkRequest{
     private UserAccount patientAccount;
     private Enterprise enterprise;

     
    public Enterprise getHospital() {
        return enterprise;
    }

    public void setHospital(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    
     
    public UserAccount getPatientAccount() {
        return patientAccount;
    }

    public void setPatientAccount(UserAccount userAccount) {
        this.patientAccount = userAccount;
    }
    
    @Override
    public String toString() {
        return patientAccount.toString();
    }
    

}
