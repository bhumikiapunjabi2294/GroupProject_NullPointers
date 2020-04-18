/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/*
 *
 *
 * @author Yash
 */

public class PatientsAllocatedWorkRequest extends WorkRequest {
    private UserAccount patientAccount;
    private String healthCondition;

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }
    
    public UserAccount getPatientAccount() {
        return patientAccount;
    }

    public void setPatientAccount(UserAccount userAccount) {
        this.patientAccount = userAccount;
    }
    
}
