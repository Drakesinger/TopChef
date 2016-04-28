/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Ingredient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author wassimajjali
 */
@Stateless
public class IngredientFacade extends AbstractFacade<Ingredient> {

    @PersistenceContext(unitName = "TopChefPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngredientFacade() {
        super(Ingredient.class);
    }
    public List<Ingredient> search(String param)
    {
      
        Query query = null;
        query = searchNom(param);
        return query.getResultList();
    }
    
    
    private Query searchNom(String param)
    {
        return em.createQuery(
            "SELECT i FROM ingredient c WHERE i.nom LIKE :nom")
                .setParameter("nom", "%"+param+"%");
    }
    


        
    
}
