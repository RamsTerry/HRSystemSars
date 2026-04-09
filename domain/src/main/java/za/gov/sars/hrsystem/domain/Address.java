/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.gov.sars.hrsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import za.gov.sars.hrsystem.common.AddressType;

/**
 *
 * @author S2028398
 */
@Audited
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "add_line1")
    private String line1;

    @Column(name = "add_line2")
    private String line2;

    @Column(name = "add_line3")
    private String line3;

    @Column(name = "code")
    private String code;

    @Column(name = "add_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
