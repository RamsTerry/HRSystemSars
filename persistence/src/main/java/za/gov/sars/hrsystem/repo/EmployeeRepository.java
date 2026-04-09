/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.gov.sars.hrsystem.domain.Employee;

/**
 *
 * @author S2028398
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsernameAndUserPassword(String username, String userPassword);

    Employee findByEmployeeNumber(String employeeNumber);
}
