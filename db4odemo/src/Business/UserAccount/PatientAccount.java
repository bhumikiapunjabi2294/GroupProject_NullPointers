/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.VitalSign.VitalSignHistory;

/**
 *
 * @author bhumika
 */
public class PatientAccount {
    
    private VitalSignHistory vitalSignHistory;
    private String Name;
    private String Address;
    private String ContactNum;
    private String EmailAddress; 
    
    
    public PatientAccount() {
        
        vitalSignHistory= new VitalSignHistory();
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
    
}
