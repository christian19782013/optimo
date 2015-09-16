/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_04_web.session;

import ec.infocenter.pom_01_ldomain.ImalabPrecio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Christian
 */
@Stateless
public class ImalabPrecioFacade extends AbstractFacade<ImalabPrecio> {
    @PersistenceContext(unitName = "PULAB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImalabPrecioFacade() {
        super(ImalabPrecio.class);
    }
    
}
