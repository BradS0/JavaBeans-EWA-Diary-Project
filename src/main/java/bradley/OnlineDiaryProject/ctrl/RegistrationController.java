/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ctrl;

import bradley.OnlineDiaryProject.bus.RegistrationService;
import bradley.OnlineDiaryProject.ent.UserLogin;
import bradley.OnlineDiaryProject.ent.UserDetails;
import bradley.OnlineDiaryProject.ent.UserDetailsFacade;
import bradley.OnlineDiaryProject.ent.UserLoginFacade;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Bradley
 */
@Named("registrationBean")
@RequestScoped
public class RegistrationController {

    public UserLogin getNewUser() {
        return newUser;
    }

    public void setNewUser(UserLogin newUser) {
        this.newUser = newUser;
    }

    public UserDetails getNewUserDetails() {
        return newUserDetails;
    }

    public void setNewUserDetails(UserDetails newUserDetails) {
        this.newUserDetails = newUserDetails;
    }
    
    public RegistrationController(){
    }
    
    @EJB
    private RegistrationService rs;
    private UserLogin newUser = new UserLogin();
    private UserDetails newUserDetails = new UserDetails();


    public String createUser(){ 
        rs.addNewUser(newUser);
        rs.addNewUserInfo(newUserDetails, newUser);
        return "home";
    }
}
