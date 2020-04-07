/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.EmergencyServicesAdminRole;
import Business.Role.EmergencyServicesManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yash
 */
public class EmergencyServicesManagerOrganization extends Organization{

    public EmergencyServicesManagerOrganization() {
         super(Organization.Type.EmergencyServicesManager.getValue());;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new EmergencyServicesManagerRole());
        return roles;
    }
    
}
