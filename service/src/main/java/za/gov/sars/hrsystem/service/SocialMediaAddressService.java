/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.hrsystem.domain.SocialMediaAddress;
import za.gov.sars.hrsystem.repo.SocialMediaAddressRepository;

/**
 *
 * @author S2028398
 */
@Service
@Transactional
public class SocialMediaAddressService implements SocialMediaAddressServiceLocal {

    @Autowired
    private SocialMediaAddressRepository socialMediaAddressRepository;

    @Override
    public SocialMediaAddress findById(Long id) {
        return socialMediaAddressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public SocialMediaAddress deleteById(Long id) {
        SocialMediaAddress socialMediaAddress = findById(id);
        if (socialMediaAddress != null) {
            socialMediaAddressRepository.delete(socialMediaAddress);
        }
        return socialMediaAddress;
    }

}
