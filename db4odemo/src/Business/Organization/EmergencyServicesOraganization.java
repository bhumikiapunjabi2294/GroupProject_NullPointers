/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AmbulanceRole;
import Business.Role.EmergencyServicesAdministrativeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Yash
 */
public class EmergencyServicesOraganization extends Organization{

    public EmergencyServicesOraganization() {
         super(Organization.Type.EmergencyServicesAdmin.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new EmergencyServicesAdministrativeRole());
        return roles;
    }
}
