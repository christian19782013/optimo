/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_04_web.converter;

import ec.infocenter.pom_01_ldomain.VCabeDeta;
import ec.infocenter.pom_03_servicio.VnativoRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author christian
 */
@Named(value = "newJSFManagedBean")
@ViewScoped
public class NewJSFManagedBean implements Serializable {

    @EJB
    private VnativoRemote vnativo;
    private List<VCabeDeta> lvn = new ArrayList<>();

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
    }

  

    /**
     * @return the lvn
     */
    public List<VCabeDeta> getLvn() {
        lvn=vnativo.busca();  
        System.out.println("lvn = " + lvn.size());
        System.out.println("lvn = " + lvn.size());
        System.out.println("lvn = " + lvn.size());
        Iterator<VCabeDeta> iterator = lvn.iterator();
        while (iterator.hasNext()) {
            VCabeDeta next = iterator.next();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("next.getNumeroFactura():"+next.getNumeroFactura());
            System.out.println("next.getObservacion():"+next.getObservacion());
            System.out.println("next.getCantidad():"+next.getCantidad());
            System.out.println("next.getFechaFactura():"+next.getFechaFactura());
        }
        return lvn;
    }

}
