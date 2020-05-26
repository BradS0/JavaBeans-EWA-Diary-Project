/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.bus;

import bradley.OnlineDiaryProject.ent.UserLogin;
import bradley.OnlineDiaryProject.ent.UserDetails;
import bradley.OnlineDiaryProject.ent.UserDetailsFacade;
import bradley.OnlineDiaryProject.ent.UserLoginFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bradley
 */
@Stateless
public class RegistrationService {
    
    @EJB
    private UserLoginFacade uf;
    @EJB
    private UserDetailsFacade udf;
    
    /**
     * Initialises the persisting of the new user.
     * @param u
     * @return
     */
    public UserLogin addNewUser(UserLogin u){
        uf.create(u);
        return u;
    }
    
    /**
     * Initialises the persisting of the new user details.
     * @param uinf
     * @param u
     * @return
     */
    public UserDetails addNewUserInfo(UserDetails uinf, UserLogin u){
        udf.create(uinf); 
        return uinf;
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
