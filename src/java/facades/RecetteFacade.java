/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Recette;
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
    //toDo Search
      public List<Recette> search(String param, int idType, int idMarque)
    {
        System.out.print(idType + "");
        Query query = null;
        query = searchNom(param);
        return query.getResultList();
    }
    
  
    
    private Query searchNom(String param)
    {
        return em.createQuery(
            "SELECT r FROM recette r WHERE r.nom LIKE :nom")
                .setParameter("nom", "%"+param+"%");
    }
    

    
}
