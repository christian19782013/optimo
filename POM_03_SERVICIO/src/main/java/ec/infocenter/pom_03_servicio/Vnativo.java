/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_03_servicio;

import ec.infocenter.pom_01_ldomain.VCabeDeta;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author christian
 */
@Stateless
@PermitAll
public class Vnativo implements VnativoRemote {

    @PersistenceContext(unitName = "PU3")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<VCabeDeta> busca() {
        String sql
                = "select * from V_CABE_DETA";
        Query query = em.createNativeQuery(sql, VCabeDeta.class);
        List resultList = query.getResultList();
        return resultList;
    }
}
