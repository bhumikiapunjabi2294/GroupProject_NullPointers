/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.EmergencyServicesAdministrativeRole;
import Business.Role.EmergencyServicesManagerRole;
import Business.Role.HospitalManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yash
 */
public class HospitalManagerOrganization extends Organization{

    public HospitalManagerOrganization() {
         super(Organization.Type.HospitalManager.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HospitalManagerRole());
        return roles;
    }
    
}
