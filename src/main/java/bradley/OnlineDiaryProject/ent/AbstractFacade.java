/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import javax.persistence.EntityManager;

/**
 *
 * @author Bradley
 */
public abstract class AbstractFacade<C> {

    private Class<C> entityClass;

    
    public AbstractFacade(Class<C> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();

    public void create(C entity) {
        getEntityManager().persist(entity);
    }
    
    public C edit(C entity) {
        return getEntityManager().merge(entity);
    }

    public void remove(C entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public C find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
   
}
