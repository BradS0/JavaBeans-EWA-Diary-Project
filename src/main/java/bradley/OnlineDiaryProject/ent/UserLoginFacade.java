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

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public UserLoginFacade() {
        super(UserLogin.class);
    }

    /**
     * Sets the properties of the new user to the user inputs, and then persists them to the database.
     * @param id
     * @param username
     * @param password
     * @param ud
     * @return
     */
    public UserLogin createUserLogin(Long id, String username, String password, UserDetails ud) {
        UserLogin newU = new UserLogin();
        newU.setId(id);
        newU.setUsername(username);
        newU.setPassword(password);
        ud.setUserId(newU);
        em.persist(newU);
        return newU;
    }

    /**
     * Returns fetched user logins (if any) based on the login input by the user.
     * @param id
     * @param username
     * @param password
     * @return
     */
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
