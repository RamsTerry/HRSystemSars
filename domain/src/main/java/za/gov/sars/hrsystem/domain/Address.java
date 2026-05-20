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
import org.hibernate.envers.Audited;
import za.gov.sars.hrsystem.common.AddressType;

/**
 *
 * @author S2028398
 */
@Audited
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

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
    
    
}
