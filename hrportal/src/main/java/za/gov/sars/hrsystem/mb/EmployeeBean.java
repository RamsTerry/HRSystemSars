/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.hrsystem.common.AddressType;
import za.gov.sars.hrsystem.domain.Address;
import za.gov.sars.hrsystem.domain.ContactDetail;
import za.gov.sars.hrsystem.domain.Employee;
import za.gov.sars.hrsystem.domain.SocialMediaAddress;
import za.gov.sars.hrsystem.service.AddressServiceLocal;
import za.gov.sars.hrsystem.service.EmployeeServiceLocal;
import za.gov.sars.hrsystem.service.SocialMediaAddressServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean<Employee> {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private AddressServiceLocal addressService;
    @Autowired
    private SocialMediaAddressServiceLocal socialMediaAddressService;

    private List<AddressType> addressTypes = new ArrayList<>();

    private Employee selectedEmployee;

    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitleName("Employees");
        addressTypes.addAll(Arrays.asList(AddressType.values()));
        addCollections(employeeService.listAll());
    }

    public void addOrUpdate(Employee employee) {
        reset().setAdd(true);
        if (employee != null) {
            setPanelTitleName("Edit Employee");
            employee.setUpdatedBy(getActiveUser().getEmployeeNumber());
            employee.setUpdatedDate(new Date());
        } else {
            setPanelTitleName("Add Employee");
            employee = new Employee();
            employee.setCreatedBy(getActiveUser().getEmployeeNumber());
            employee.setCreatedDate(new Date());

            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getEmployeeNumber());
            contactDetail.setCreatedDate(new Date());
            employee.setContactDetail(contactDetail);

            addToCollection(employee);
        }
        addEntity(employee);
    }

    public void onRowSelect() {
        reset().setView(true);
        addEntity(selectedEmployee);
    }

    public void save(Employee employee) {
        if (employee.getId() != null) {
            employeeService.update(employee);
            addInformationMessage("Employee was successfully updated.");
        } else {
            if (employeeService.isExist(employee)) {
                addErrorMessage("Employee with that employee number already exist");
                return;
            }
            employeeService.save(employee);
            addInformationMessage("Employee was successfully created.");
        }
        reset().setList(true);
    }

    public void back() {
        reset().setList(true);
    }

    public void cancel(Employee employee) {
        if (employee.getId() == null && getEmployees().contains(employee)) {
            remove(employee);
        }
        reset().setList(true);
    }

    public void delete(Employee employee) {
        employeeService.deleteById(employee.getId());
        remove(employee);
        addInformationMessage("Employee was successfully deleted");
        reset().setList(true);
    }

    //Address adding,edit and delete
    public void addNewAddress() {
        Address address = new Address();
        address.setCreatedBy(getActiveUser().getEmployeeNumber());
        address.setCreatedDate(new Date());
        getEntity().addAddress(address);
//        reset().setAddressPanel(true);
    }

    public void removeAddress(Address Address) {
        if (getEntity().getAddresses().contains(Address) && Address.getId() == null) {
            getEntity().removeAddress(Address);
        } else {
            addressService.deleteById(Address.getId());
        }
        this.addInformationMessage("Address removed successfully!!");
    }

    //social Address adding,edit and delete
    public void addSocialAddress() {
        SocialMediaAddress socialMediaAddress = new SocialMediaAddress();
        socialMediaAddress.setCreatedBy(getActiveUser().getEmployeeNumber());
        socialMediaAddress.setCreatedDate(new Date());
        getEntity().getContactDetail().addSocialAddress(socialMediaAddress);
    }

    public void removeSocialMediaAddress(SocialMediaAddress socialMediaAddress) {
        if (getEntity().getContactDetail().getSocialMediaAddresses().contains(socialMediaAddress) && socialMediaAddress.getId() == null) {
            getEntity().getContactDetail().removeSocialAddress(socialMediaAddress);
        } else {
            socialMediaAddressService.deleteById(socialMediaAddress.getId());
        }
        this.addInformationMessage("Social media address removed successfully!!");
    }

    public List<Employee> getEmployees() {
        return this.getCollections();
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public List<AddressType> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<AddressType> addressTypes) {
        this.addressTypes = addressTypes;
    }

}
