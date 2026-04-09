/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.tests;

import za.gov.sars.hrsystem.domain.ContactDetail;
import za.gov.sars.hrsystem.domain.Employee;

/**
 *
 * @author S2028398
 */
public class BootStrapHelper {

    public static Employee getEmployee(String employeeNumber, String username, String userPassword, String firstName, String lastName, ContactDetail contactDetail) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmployeeNumber(employeeNumber);
        employee.setUsername(username);
        employee.setUserPassword(userPassword);
        employee.setContactDetail(contactDetail);
        return employee;
    }
}
