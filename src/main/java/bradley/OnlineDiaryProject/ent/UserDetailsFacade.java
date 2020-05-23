/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bradley
 */

@Stateless
public class UserDetailsFacade extends AbstractFacade<UserDetails> {
    @PersistenceContext(unitName = "OnlineDiaryPU")
    private EntityManager em;
 
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public UserDetailsFacade() {
        super(UserDetails.class);
    }
    
    
}
