/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.service;

import za.gov.sars.hrsystem.domain.Address;

/**
 *
 * @author S2028398
 */
public interface AddressServiceLocal {

    Address findById(Long id);

    Address deleteById(Long id);
}
