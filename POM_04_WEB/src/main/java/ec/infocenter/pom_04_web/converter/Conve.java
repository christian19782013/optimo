/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_04_web.converter;

import ec.infocenter.pom_01_ldomain.ImalabCabecera;
import ec.infocenter.pom_04_web.session.ImalabCabeceraFacade;
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
@Named(value = "conve")
@ViewScoped
public class Conve implements Serializable {

    @EJB
    private ec.infocenter.pom_04_web.session.ImalabCabeceraFacade ejbFacade;
    private ImalabCabecera imalabCabecera = new ImalabCabecera();
    private String valor = "";

    /**
     * Creates a new instance of Conve
     */
    public Conve() {
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        System.out.println("valor = " + valor);
        this.valor = valor;
    }

    public List<ImalabCabecera> getItemsAvailableSelectMany() {
        return ejbFacade.findAll();
    }

    /**
     * @return the imalabCabecera
     */
    public ImalabCabecera getImalabCabecera() {
        return imalabCabecera;
    }

    /**
     * @param imalabCabecera the imalabCabecera to set
     */
    public void setImalabCabecera(ImalabCabecera imalabCabecera) {
        System.out.println("llega a setImalabCabecera() ");
        try {
            System.out.println("llega a getImalabCabecera() ");
            System.out.println("imalabCabecera. = " + imalabCabecera.getNumeroFactura());
            System.out.println("imalabCabecera. = " + imalabCabecera.getId());
            System.out.println("imalabCabecera.getImalabCliente().getNombres() = " + imalabCabecera.getImalabCliente().getNombres());

        } catch (Exception e) {
        }

        this.imalabCabecera = imalabCabecera;
    }

}
