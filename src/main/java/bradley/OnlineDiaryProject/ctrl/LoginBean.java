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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.NoResultException;

/**
 *
 * @author Bradley
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    /**
     *
     */
    public LoginBean() {
    }

    /**
     *
     * @return
     */
    public UserLogin getUserDetails() {
        return userDetails;
    }

    /**
     *
     * @param userDetails
     */
    public void setUserDetails(UserLogin userDetails) {
        this.userDetails = userDetails;
    }

    @EJB
    private LoginService ls;
    private UserLogin userDetails = new UserLogin();
    private UserLogin fetchedLogin;
    private String validationResult, loginResult, credentialCheckResult;
    private FacesMessage errorMessage;
    private FacesContext errorContext;
    private UIComponent submitCredentialBtn;

    /**
     *
     * @return
     */
    public UIComponent getSubmitCredentialBtn() {
        return submitCredentialBtn;
    }

    /**
     *
     * @param submitCredentialBtn
     */
    public void setSubmitCredentialBtn(UIComponent submitCredentialBtn) {
        this.submitCredentialBtn = submitCredentialBtn;
    }

    /**
     * Initiates the fetch of logins from the database with the same credentials as the one entered, if any match they are passed to the checkUsernamePassword function to be checked.
     * @return
     */
    public String loginCredentialCheck() {
        if (!userDetails.getUsername().equals("")) {
            try {
                fetchedLogin = ls.checkUserCredentials(userDetails);
                validationResult = checkUsernamePassword(userDetails, fetchedLogin);
                loginResult = validationResult;
            } catch (NoResultException e) {
                System.out.println(e);
            }
        } else {
            loginResult = "loginError";
        }
        return loginResult;
    }

    /**
     * Checks the credentials fetched from the database against the credentials submitted by the user, returning the appropriate page based on result.
     * @param u
     * @param fetchedLogin
     * @return
     */
    public String checkUsernamePassword(UserLogin u, UserLogin fetchedLogin) {
        // Checks to see if fetched username and password match that of entered credentials.
        if (fetchedLogin != null && fetchedLogin.getUsername().equals(u.getUsername()) && fetchedLogin.getPassword().equals(u.getPassword())) {
            credentialCheckResult = "home";
        } else if (fetchedLogin != null && fetchedLogin.getUsername().equals(u.getUsername()) && !fetchedLogin.getPassword().equals(u.getPassword())) {
            errorMessage = new FacesMessage("Invalid Password Input");
            errorContext = FacesContext.getCurrentInstance();
            errorContext.addMessage(submitCredentialBtn.getClientId(errorContext), errorMessage);
            credentialCheckResult = "loginError";
        } else if (fetchedLogin != null && !fetchedLogin.getUsername().equals(u.getUsername()) && fetchedLogin.getPassword().equals(u.getPassword())) {
            errorMessage = new FacesMessage("Invalid Username Input");
            errorContext = FacesContext.getCurrentInstance(); // Might be okay outside of if statement
            errorContext.addMessage(submitCredentialBtn.getClientId(errorContext), errorMessage);
            credentialCheckResult = "loginError";
        } else {
            errorMessage = new FacesMessage("Invalid Username and Password");
            errorContext = FacesContext.getCurrentInstance(); // Might be okay outside of if statement
            errorContext.addMessage(submitCredentialBtn.getClientId(errorContext), errorMessage);
            credentialCheckResult = "loginError";
        }
        return credentialCheckResult;
    }
}
