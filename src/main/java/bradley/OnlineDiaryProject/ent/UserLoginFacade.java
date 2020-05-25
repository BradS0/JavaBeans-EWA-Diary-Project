/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    private List<UserLogin> credentialResults;
    private UserLogin fetchedUser;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserLoginFacade() {
        super(UserLogin.class);
    }

    public UserLogin createUserLogin(Long id, String username, String password) {
        UserLogin newU = new UserLogin();
        newU.setId(id);
        newU.setUsername(username);
        newU.setPassword(password);
        em.persist(newU);
        return newU;
    }

    public UserLogin checkUserCredentials(Long id, String username, String password) {
        UserLogin userCredentials = new UserLogin();
        userCredentials.setId(id);
        userCredentials.setUsername(username);
        userCredentials.setPassword(password);
        // Try to fetch the user from the database, based on the user's enter details
        Query q = em.createQuery("SELECT u FROM UserLogin u WHERE u.username = '" + userCredentials.getUsername() + "' AND u.password ='" + userCredentials.getPassword() + "'");
        // Check to see if the fetched result is empty, if yes then throw a loginError.
        try {
            credentialResults = q.getResultList();
            if (!credentialResults.isEmpty()) {
                fetchedUser = credentialResults.get(0);
                System.out.println(fetchedUser);
            } else {
                return null;
            }
        }catch (NoResultException e) {
            System.out.println(credentialResults);
            return null;
        }
        return fetchedUser;       
    }
}
