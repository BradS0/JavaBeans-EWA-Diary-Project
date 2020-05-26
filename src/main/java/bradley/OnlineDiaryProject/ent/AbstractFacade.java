/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import javax.persistence.EntityManager;

/**
 * CRUD Functionality for Facade Classes
 * @author Bradley
 * @param <C>
 */
public abstract class AbstractFacade<C> {

    private Class<C> entityClass;

    /**
     *
     * @param entityClass
     */
    public AbstractFacade(Class<C> entityClass) {
        this.entityClass = entityClass;
    }
    
    /**
     *
     * @return
     */
    protected abstract EntityManager getEntityManager();

    /**
     *
     * @param entity
     */
    public void create(C entity) {
        getEntityManager().persist(entity);
    }
    
    /**
     *
     * @param entity
     * @return
     */
    public C edit(C entity) {
        return getEntityManager().merge(entity);
    }

    /**
     *
     * @param entity
     */
    public void remove(C entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     *
     * @param id
     * @return
     */
    public C find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
   
}
