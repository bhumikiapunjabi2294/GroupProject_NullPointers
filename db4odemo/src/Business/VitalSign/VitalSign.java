/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VitalSign;

import java.util.Date;

/**
 *
 * @author bHumika
 */
public class VitalSign {

    private float bodyTemperature;
    private float respiratoryRate;
    private String coughType;
    private Boolean musclePain;
    private Boolean headache;
    private String date;
    private String healthCondition;
    private String status;

    public float getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(float bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public float getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(float respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public String getCoughType() {
        return coughType;
    }

    public void setCoughType(String coughType) {
        this.coughType = coughType;
    }

    public Boolean getMusclePain() {
        return musclePain;
    }

    public void setMusclePain(Boolean musclePain) {
        this.musclePain = musclePain;
    }

    public Boolean getHeadache() {
        return headache;
    }

    public void setHeadache(Boolean headache) {
        this.headache = headache;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return healthCondition;
    }
    
}
