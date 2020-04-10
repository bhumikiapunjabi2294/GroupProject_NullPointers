/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.NGOAdministrativeRole;
import Business.Role.PatientRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yash
 */
public class NGOOrganization extends Organization{

    public NGOOrganization() {
        super(Organization.Type.NGO.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NGOAdministrativeRole());
        return roles;
    }
     
   
    
    
}
