/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.hrsystem.domain.Employee;
import za.gov.sars.hrsystem.service.EmployeeServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@RequestScoped
@Getter
@Setter
public class LoginBean extends BaseBean<Employee> {

    @Autowired
    private EmployeeServiceLocal employeeService;

    private String userName;
    private String password;

    public void signIn() {
        Employee employee = employeeService.findByUsernameAndUserPassword(userName, password);
        if (employee != null) {
            getActiveUser().setLogonUserSession(employee);
            redirect("landing");
        } else {
            addErrorMessage("Employee with those cridentials does not exist");
        }
    }
}
