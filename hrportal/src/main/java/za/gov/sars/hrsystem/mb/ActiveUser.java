/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;
import za.gov.sars.hrsystem.domain.Employee;

/**
 *
 * @author S2028398
 */
@ManagedBean
@SessionScoped
@Getter
@Setter
public class ActiveUser implements Serializable {
    
    private boolean userLoginIndicator;
    
    private String firstName;
    private String lastName;
    private String employeeNumber;
    
    public ActiveUser() {
        userLoginIndicator = Boolean.FALSE;
    }
    
    public void setLogonUserSession(Employee loginEmployee) {
        if (loginEmployee.getId() != null) {            
            setFirstName(loginEmployee.getFirstName());
            setLastName(loginEmployee.getLastName());
            setEmployeeNumber(loginEmployee.getEmployeeNumber());
            setUserLoginIndicator(true);
        }
    }
    
}
