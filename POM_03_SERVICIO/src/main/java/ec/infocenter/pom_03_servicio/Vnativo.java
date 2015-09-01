/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_03_servicio;

import ec.infocenter.pom_01_ldomain.VCabeDeta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class Vnativo implements VnativoRemote, Serializable {

    @PersistenceContext(unitName = "PU3")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<VCabeDeta> busca(String texto) {
        em.setProperty("javax.persistence.cache.storeMode", "BYPASS");

        String sql
                = "select * from V_CABE_DETA where observacion like '%" + texto.toUpperCase() + "%'";
        Query query = em.createNativeQuery(sql, VCabeDeta.class);

        List<VCabeDeta> l = new ArrayList<>();
        l = query.getResultList();
        return l;
    }
}
