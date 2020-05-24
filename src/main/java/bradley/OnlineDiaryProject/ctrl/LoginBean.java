/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ctrl;

import bradley.OnlineDiaryProject.bus.LoginService;
import bradley.OnlineDiaryProject.ent.UserLogin;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Bradley
 */
@Named(value="loginBean")
@RequestScoped
public class LoginBean {
   
    public LoginBean() {
    }
    
    public UserLogin getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserLogin userDetails) {
        this.userDetails = userDetails;
    }

    @EJB
    private LoginService ls;
    private UserLogin userDetails = new UserLogin();
    private String validationResult;
    
    public String loginCredentialCheck(){
        ls.checkUserCredentials(userDetails);
        validationResult = validationCheck(userDetails);
        System.out.println(userDetails);
        return validationResult;
    }
    
    public String validationCheck(UserLogin loginCheck){
        if(loginCheck != null){
            return "home";
        } else {
            return "loginerror";
        }
        
    }
}
