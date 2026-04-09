/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.hrsystem.domain.Address;
import za.gov.sars.hrsystem.domain.SocialMediaAddress;
import za.gov.sars.hrsystem.repo.AddressRepository;
import za.gov.sars.hrsystem.repo.SocialMediaAddressRepository;

/**
 *
 * @author S2028398
 */
@Service
@Transactional
public class AddressService implements AddressServiceLocal {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public Address deleteById(Long id) {
        Address address = findById(id);
        if (address != null) {
            addressRepository.delete(address);
        }
        return address;
    }

}
