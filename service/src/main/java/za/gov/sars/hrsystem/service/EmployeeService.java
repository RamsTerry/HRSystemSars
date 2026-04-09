/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.hrsystem.domain.Employee;
import za.gov.sars.hrsystem.repo.EmployeeRepository;

/**
 *
 * @author S2028398
 */
@Service
@Transactional
public class EmployeeService implements EmployeeServiceLocal {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee deleteById(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
        return employee;
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findByUsernameAndUserPassword(String username, String userPassword) {
        return employeeRepository.findByUsernameAndUserPassword(username, userPassword);
    }

    @Override
    public boolean isExist(Employee employee) {
        return employeeRepository.findByEmployeeNumber(employee.getEmployeeNumber()) != null;
    }

}
