/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.gov.sars.hrsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2028398
 */
@Audited
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends Person {

    @Column(name = "employee_number")
    private String employeeNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "user_password")
    private String userPassword;
}
