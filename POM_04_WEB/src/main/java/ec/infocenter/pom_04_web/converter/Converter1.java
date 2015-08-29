/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_04_web.converter;

import ec.infocenter.pom_01_ldomain.ImalabCabecera;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author christian
 */
@FacesConverter("convv")
public class Converter1 implements Converter {

    @EJB
    private ec.infocenter.pom_04_web.session.ImalabCabeceraFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        //La parte complicada del converter en este caso es que se recibe 
        //el id del entity como numero por ejemplo:87 no como se suponia la cadena ec.....[id=87]
        //aca es donde se tranforma del número a objeto y se almacena el el set objeto en el managedbean
        ImalabCabecera find = ejbFacade.find(new BigDecimal(value));
        return find;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        //en Object value viene value ec.infocenter.pom_01_ldomain.ImalabCabecera[ id=62 ]
        //no como yo suponia al inicio que venia el objeto de la interface
        //de aca se extrae su id y se retorna, este método sirve solo cuando se esta dibujando 
        //la página para llenar el value ej:
//        <select id="j_idt5:iterator_input" name="j_idt5:iterator_input" tabindex="-1" onchange="mojarra.ab('j_idt5:iterator',event,'change',0,0)">
//            <option>Choose item</option>
//            <option value="62">bNbDEsDTaOzGOxkXzIFnsiHjjVUsyMcTMCrsjJwYixcfrKIowySpOymqfvaVwnvkdNbhI</option>
//            <option value="81">bcqHIRuQyBQqceopAjnPJVYaRguZVgKifCiHrbVqRqht</option>
//        </select>
        BigDecimal k = (value instanceof ImalabCabecera) ? ((ImalabCabecera) value).getId() : null;
        return (k != null) ? k.toString() : null;
    }

    public List<ImalabCabecera> getItemsAvailableSelectMany() {
        return ejbFacade.findAll();
    }
}
