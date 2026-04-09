/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.gov.sars.hrsystem.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2028398
 */
@Audited
@Entity
@Table(name = "contact_detail")
@Getter
@Setter
public class ContactDetail extends BaseEntity {

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "land_line_number")
    private String landLineNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = SocialMediaAddress.class)
    private List<SocialMediaAddress> socialMediaAddresses = new ArrayList<>();

    public void addSocialAddress(SocialMediaAddress socialAddress) {
        socialMediaAddresses.add(socialAddress);
    }

    public void removeSocialAddress(SocialMediaAddress socialAddress) {
        socialMediaAddresses.remove(socialAddress);
    }
}
