/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@Entity
@Table(name = "social_media_address")
@Getter
@Setter
public class SocialMediaAddress extends BaseEntity {

    @Column(name = "social_media_type")
    private String mediaType;

    @Column(name = "social_media_address")
    private String mediaAddress;
}
