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

    String valortexto = "";

    public String getValortexto() {
        return valortexto;
    }

    public void setValortexto(String valortexto) {
        this.valortexto = valortexto;
    }

    public VnativoRemote getVnativo() {
        return vnativo;
    }

    public void setVnativo(VnativoRemote vnativo) {
        this.vnativo = vnativo;
    }

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
        lvn.clear();
        lvn = vnativo.busca(valortexto);
        return lvn;
    }

}
