/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import za.gov.sars.hrsystem.domain.Employee;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class HomeBean extends BaseBean<Employee> {

    private static final String EXPIRY_PAGE = "/expired.xhtml?faces-redirect=true";
    private static final String EMPLOYEE_PAGE = "employees.xhtml";

    public String routeToEmployee() {
        if (getActiveUser() != null) {
            return EMPLOYEE_PAGE;
        }
        return EXPIRY_PAGE;
    }
}
