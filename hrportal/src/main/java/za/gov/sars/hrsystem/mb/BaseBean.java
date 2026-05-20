package za.gov.sars.hrsystem.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author S2028398
 */
public class BaseBean<T> extends SpringBeanAutowiringSupport implements Serializable {
    
    @ManagedProperty(value = "#{activeUser}")
    private ActiveUser activeUser;
    
    private boolean list;
    private boolean add;
    private boolean update;
    private boolean view;
    private boolean addressPanel;
    private boolean socialAddress;
    
    private List<T> collections = new ArrayList<>();
    private List<String> errorCollectionMsg = new ArrayList<>();
    
    private T entity;
    private String panelTitleName;
    
    public BaseBean() {
        
    }
    
    public void authenticationChecks() {
        if (!getActiveUser().isUserLoginIndicator()) {
            redirect("accessdenied");
        }
    }

    /**
     * @return the activeUser
     */
    public ActiveUser getActiveUser() {
        return activeUser;
    }

    /**
     * @param activeUser the activeUser to set
     */
    public void setActiveUser(ActiveUser activeUser) {
        this.activeUser = activeUser;
    }
    
    public void redirect(String page) {
        try {
            StringBuilder builder = new StringBuilder(page);
            builder.append(".xhtml");
            FacesContext.getCurrentInstance().getExternalContext().redirect(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(HomeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void redirecting(String page) {
        try {
            StringBuilder builder = new StringBuilder(page);
            builder.append(".xhtml?faces-redirect=true");
            FacesContext.getCurrentInstance().getExternalContext().redirect(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(HomeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addInformationMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void addErrorMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String defaultRouter(String page) {
        StringBuilder builder = new StringBuilder(page);
        builder.append(".xhtml");
        return builder.toString();
    }
    
    public String defaultRouting(String page) {
        StringBuilder builder = new StringBuilder(page);
        builder.append(".xhtml");
        return builder.toString();
    }

    /**
     * @return the errorCollectionMsg
     */
    public List<String> getErrorCollectionMsg() {
        return errorCollectionMsg;
    }

    /**
     * @param errorCollectionMsg the errorCollectionMsg to set
     */
    public void setErrorCollectionMsg(List<String> errorCollectionMsg) {
        this.errorCollectionMsg = errorCollectionMsg;
    }
    
    public BaseBean reset() {
        setList(false);
        setAdd(false);
        setUpdate(false);
        setView(false);
        setAddressPanel(false);
        setSocialAddress(false);
        return this;
    }
    
    public List<T> getCollections() {
        return collections;
    }
    
    public void setCollections(List<T> collections) {
        this.collections = collections;
    }
    
    public T getEntity() {
        return entity;
    }
    
    public void setEntity(T entity) {
        this.entity = entity;
    }
    
    public void addEntity(T entity) {
        this.entity = entity;
    }
    
    public void addCollections(List<T> list) {
        collections.clear();
        collections.addAll(list);
    }
    
    public void addToCollection(T entity) {
        collections.add(0, entity);
    }
    
    public void addCollections(Set<T> list) {
        collections.clear();
        collections.addAll(list);
    }
    
    public void refreshTable(T entity) {
        collections.add(0, entity);
    }
    
    public void synchronize(T entity) {
        if (collections.contains(entity)) {
            collections.remove(entity);
        }
    }
    
    public void remove(T entity) {
        collections.remove(entity);
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isAddressPanel() {
        return addressPanel;
    }

    public void setAddressPanel(boolean addressPanel) {
        this.addressPanel = addressPanel;
    }

    public boolean isSocialAddress() {
        return socialAddress;
    }

    public void setSocialAddress(boolean socialAddress) {
        this.socialAddress = socialAddress;
    }

    public String getPanelTitleName() {
        return panelTitleName;
    }

    public void setPanelTitleName(String panelTitleName) {
        this.panelTitleName = panelTitleName;
    }
    
    
    
}
