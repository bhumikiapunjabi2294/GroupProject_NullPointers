/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author bhumika
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private PatientAccount patientAccount;
    private PersonalInformation personalInformation;

    
    public UserAccount() {
        workQueue = new WorkQueue();
        patientAccount = new PatientAccount();
        personalInformation = new PersonalInformation();
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public PatientAccount getPatientAccount() {
        return patientAccount;
    }

    public void setPatientAccount(PatientAccount patientAccount) {
        this.patientAccount = patientAccount;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
    public void AddPersonalInformation(String name,String Address, String ContectNum, String email){
        personalInformation.setName(name);
        personalInformation.setAddress(Address);
        personalInformation.setContactNum(ContectNum);
        personalInformation.setEmailAddress(email);
        
    }
    
    
    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}