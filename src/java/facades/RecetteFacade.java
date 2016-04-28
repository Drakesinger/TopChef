/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Recette;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author horia.mut
 */
@Stateless
public class RecetteFacade extends AbstractFacade<Recette> {
    @PersistenceContext(unitName = "TopChefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecetteFacade() {
        super(Recette.class);
    }
    
}
