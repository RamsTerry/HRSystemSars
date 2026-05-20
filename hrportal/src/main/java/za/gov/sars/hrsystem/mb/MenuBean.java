/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.hrsystem.mb;

import jakarta.annotation.PostConstruct;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author S2028398
 */
@ManagedBean
@RequestScoped
public class MenuBean extends BaseBean {

    private static final Logger LOG = Logger.getLogger(MenuBean.class.getName());

    @PostConstruct
    public void init() {
    }

    public String route(String page) {
        System.out.println("selected page =" + page);
        return defaultRouter(page);
    }

}
