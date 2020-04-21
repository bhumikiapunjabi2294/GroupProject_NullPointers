/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/*
 *
 *
 * @author Yash
 */
public class PatientsInHospitalWorkRequest extends WorkRequest {
    private ArrayList<UserAccount> PatientsList = new ArrayList<>();

    public ArrayList<UserAccount> getPatientsList() {
        return PatientsList;
    }

    public void setPatientsList(ArrayList<UserAccount> PatientsList) {
        this.PatientsList = PatientsList;
    }
    
    public void addPatient(UserAccount account){
        PatientsList.add(account);
    } 
    
}
