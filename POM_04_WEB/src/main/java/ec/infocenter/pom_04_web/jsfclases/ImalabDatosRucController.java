package ec.infocenter.pom_04_web.jsfclases;

import ec.infocenter.pom_01_ldomain.ImalabDatosRuc;
import ec.infocenter.pom_04_web.jsfclases.util.JsfUtil;
import ec.infocenter.pom_04_web.jsfclases.util.JsfUtil.PersistAction;
import ec.infocenter.pom_04_web.session.ImalabDatosRucFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("imalabDatosRucController")
@SessionScoped
public class ImalabDatosRucController implements Serializable {

    @EJB
    private ec.infocenter.pom_04_web.session.ImalabDatosRucFacade ejbFacade;
    private List<ImalabDatosRuc> items = null;
    private ImalabDatosRuc selected;

    public ImalabDatosRucController() {
    }

    public ImalabDatosRuc getSelected() {
        return selected;
    }

    public void setSelected(ImalabDatosRuc selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ImalabDatosRucFacade getFacade() {
        return ejbFacade;
    }

    public ImalabDatosRuc prepareCreate() {
        selected = new ImalabDatosRuc();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ImalabDatosRucCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ImalabDatosRucUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ImalabDatosRucDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ImalabDatosRuc> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ImalabDatosRuc getImalabDatosRuc(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<ImalabDatosRuc> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ImalabDatosRuc> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ImalabDatosRuc.class)
    public static class ImalabDatosRucControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ImalabDatosRucController controller = (ImalabDatosRucController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "imalabDatosRucController");
            return controller.getImalabDatosRuc(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ImalabDatosRuc) {
                ImalabDatosRuc o = (ImalabDatosRuc) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ImalabDatosRuc.class.getName()});
                return null;
            }
        }

    }

}
