/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_04_web.session;

import ec.infocenter.pom_01_ldomain.ImalabCabecera;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian
 */
@Stateless
public class ImalabCabeceraFacade extends AbstractFacade<ImalabCabecera> {
    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImalabCabeceraFacade() {
        super(ImalabCabecera.class);
    }
    
}
