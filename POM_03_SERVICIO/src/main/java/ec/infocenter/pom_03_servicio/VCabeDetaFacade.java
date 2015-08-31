/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_03_servicio;

import ec.infocenter.pom_01_ldomain.VCabeDeta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author christian
 */
@Stateless
public class VCabeDetaFacade extends AbstractFacade<VCabeDeta> {

    @PersistenceContext(unitName = "PU3")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VCabeDetaFacade() {
        super(VCabeDeta.class);
    }

    List<VCabeDeta> busca() {
        String sql
                = "select * from V_CABE_DETA";

        Query query = em.createNativeQuery(sql, VCabeDeta.class);
        List<VCabeDeta> resultList = query.getResultList();
        return resultList;
    }

}
