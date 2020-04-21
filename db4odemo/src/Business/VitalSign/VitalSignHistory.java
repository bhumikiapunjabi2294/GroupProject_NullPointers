/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VitalSign;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Yash
 */
public class VitalSignHistory {
    private ArrayList<VitalSign> vitalSigns;

    public VitalSignHistory() {
        vitalSigns = new ArrayList();
    }

    public ArrayList<VitalSign> getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(ArrayList<VitalSign> vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
    
    
     public VitalSign createVitalSign(float bodyTemperature,float respiratoryRate,String coughType,Boolean musclePain,Boolean headache, String date,String healthCondition ){
        VitalSign vitalSign= new VitalSign();
        
        vitalSign.setBodyTemperature(bodyTemperature);
        vitalSign.setCoughType(coughType);
        vitalSign.setRespiratoryRate(respiratoryRate);
        vitalSign.setMusclePain(musclePain);
        vitalSign.setHeadache(headache);
        vitalSign.setDate(date);
        vitalSign.setHealthCondition(healthCondition);
        vitalSign.setStatus("no");
        vitalSigns.add(vitalSign);
        
        return vitalSign;
    }
    
}
