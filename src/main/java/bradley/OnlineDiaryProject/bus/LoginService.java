/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.bus;

import bradley.OnlineDiaryProject.ent.UserLogin;
import bradley.OnlineDiaryProject.ent.UserLoginFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bradley
 */
@Stateless
public class LoginService {

@EJB
private UserLoginFacade uf;

public void checkUserCredentials(UserLogin u){
    // String usernameInput = uf.checkUserCredentials(username, password);
} 
    

}