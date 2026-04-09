/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.tests;

import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.gov.sars.hrsystem.common.AddressType;
import za.gov.sars.hrsystem.config.TestDataSourceConfiguration;
import za.gov.sars.hrsystem.domain.Address;
import za.gov.sars.hrsystem.domain.ContactDetail;
import za.gov.sars.hrsystem.domain.Employee;
import za.gov.sars.hrsystem.domain.SocialMediaAddress;
import za.gov.sars.hrsystem.service.EmployeeServiceLocal;

/**
 *
 * @author S2028398
 */
@EnableJpaAuditing
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class hrSystemTestCase {

    @Autowired
    private EmployeeServiceLocal employeeService;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testA() {

        //Employee 1
        Address postalAddress = new Address();
        postalAddress.setCreatedBy("Test Case");
        postalAddress.setCreatedDate(new Date());
        postalAddress.setAddressType(AddressType.POSTAL);
        postalAddress.setLine1("P.O BOX 433");
        postalAddress.setLine2("Johannesburg");
        postalAddress.setCode("1685");

        Address residentalAddress = new Address();
        residentalAddress.setCreatedBy("Test Case");
        residentalAddress.setCreatedDate(new Date());
        residentalAddress.setAddressType(AddressType.RESIDENTIAL);
        residentalAddress.setLine1("10 Broadwalk street");
        residentalAddress.setLine2("Johannesburg");
        residentalAddress.setLine3("Midrand");
        residentalAddress.setCode("1685");

        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setCreatedBy("Test Case");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setLandLineNumber("015 225 3652");
        contactDetail.setMobileNumber("079 903 5403");
        contactDetail.setEmailAddress("TRamurebiwa@sars.go.za");

        SocialMediaAddress mediaAddresses = new SocialMediaAddress();
        mediaAddresses.setCreatedBy("Test Case");
        mediaAddresses.setCreatedDate(new Date());
        mediaAddresses.setMediaType("Facebook");
        mediaAddresses.setMediaAddress("@rams_terry");
        contactDetail.addSocialAddress(mediaAddresses);

        SocialMediaAddress xAddresses = new SocialMediaAddress();
        xAddresses.setCreatedBy("Test Case");
        xAddresses.setCreatedDate(new Date());
        xAddresses.setMediaType("X");
        xAddresses.setMediaAddress("@ramsTerry");
        contactDetail.addSocialAddress(xAddresses);

        Employee employee = BootStrapHelper.getEmployee(RandomStringUtils.randomNumeric(8), "terry", "P@sswords", "Terry Khudani", "Ramurebiwa", contactDetail);
        employee.addAddress(postalAddress);
        employee.addAddress(residentalAddress);
        employeeService.save(employee);

        //Employee 2
        Address postalAddres = new Address();
        postalAddres.setCreatedBy("Test Case");
        postalAddres.setCreatedDate(new Date());
        postalAddres.setAddressType(AddressType.POSTAL);
        postalAddres.setLine1("P.O BOX 233");
        postalAddres.setLine2("Thohoyandou");
        postalAddres.setCode("0985");

        Address residentalAddres = new Address();
        residentalAddres.setCreatedBy("Test Case");
        residentalAddres.setCreatedDate(new Date());
        residentalAddres.setAddressType(AddressType.RESIDENTIAL);
        residentalAddres.setLine1("218 Codesa street");
        residentalAddres.setLine2("Hamutsha");
        residentalAddres.setLine3("Makhado");
        residentalAddres.setCode("0950");

        ContactDetail contactInfo = new ContactDetail();
        contactInfo.setCreatedBy("Test Case");
        contactInfo.setCreatedDate(new Date());
        contactInfo.setLandLineNumber("015 658 2256");
        contactInfo.setMobileNumber("068 708 4869");
        contactInfo.setEmailAddress("mtshifhiwa@gmail.com");

        SocialMediaAddress mediaAddress = new SocialMediaAddress();
        mediaAddress.setCreatedBy("Test Case");
        mediaAddress.setCreatedDate(new Date());
        mediaAddress.setMediaType("Facebook");
        mediaAddress.setMediaAddress("@m_tshifh");
        contactInfo.addSocialAddress(mediaAddress);

        SocialMediaAddress xAddresse = new SocialMediaAddress();
        xAddresse.setCreatedBy("Test Case");
        xAddresse.setCreatedDate(new Date());
        xAddresse.setMediaType("X");
        xAddresse.setMediaAddress("@mukatuni");
        contactInfo.addSocialAddress(xAddresse);

        Employee employeeT = BootStrapHelper.getEmployee(RandomStringUtils.randomNumeric(8), "mtshifhiwa", "incorrect", "Tshifhiwa", "Mukatuni", contactInfo);
        employeeT.addAddress(postalAddres);
        employeeT.addAddress(residentalAddres);
        employeeService.save(employeeT);
    }

}
