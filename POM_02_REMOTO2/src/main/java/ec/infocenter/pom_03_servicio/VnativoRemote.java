/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_03_servicio;


import ec.infocenter.pom_01_ldomain.VCabeDeta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author christian
 */
@Remote
public interface VnativoRemote {

    public List<VCabeDeta> busca();
    
}
