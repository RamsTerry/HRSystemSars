/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.service;

import java.util.List;
import za.gov.sars.hrsystem.domain.Employee;

/**
 *
 * @author S2028398
 */
public interface EmployeeServiceLocal {

    Employee save(Employee employee);

    Employee findById(Long id);

    public void deleteAll();

    Employee update(Employee employee);

    Employee deleteById(Long id);

    List<Employee> listAll();

    Employee findByUsernameAndUserPassword(String username, String userPassword);

    boolean isExist(Employee employee);
}
