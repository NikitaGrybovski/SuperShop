/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.HistoryProduct;
import entity.Product;
import entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ban31
 */
@Stateless
public class HistoryProductFacade extends AbstractFacade<HistoryProduct> {
    @PersistenceContext(unitName = "SuperShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoryProductFacade() {
        super(HistoryProduct.class);
    }
    
    public void removeByProduct(Product delete) {
        try {
            em.createQuery("DELETE FROM HistoryProduct ur WHERE ur.product = :product")
                    .setParameter("product", delete)
                    .executeUpdate();
            em.flush();
        } catch (Exception e) {
            
        }
    }
    
}
