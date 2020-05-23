/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bradley
 */
@Stateless
public class UserLoginFacade extends AbstractFacade<UserLogin> {
    
    @PersistenceContext(unitName = "OnlineDiaryPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserLoginFacade() {
        super(UserLogin.class);
    }
    
    public UserLogin createUserLogin(Long id, String username, String password){
        UserLogin newU = new UserLogin();
        newU.setId(id);
        newU.setUsername(username);
        newU.setPassword(password);
        em.persist(newU);
        return newU;   
    }
    
    public List<UserLogin> checkUserCredentials(String username, String password){
        UserLogin credentialCheck = new UserLogin();
        credentialCheck.setUsername(username);
        credentialCheck.setPassword(password);
        Query q = em.createQuery("SELECT u FROM UserLogin u WHERE u.username ="+username+" AND u.password ="+password+";");
        List<UserLogin> credentialResults = q.getResultList();
        return credentialResults;
    }
}
   