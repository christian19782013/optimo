package ec.infocenter.pom_04_web.jsfclases;

import ec.infocenter.pom_01_ldomain.ImalabDesciento;
import ec.infocenter.pom_04_web.jsfclases.util.JsfUtil;
import ec.infocenter.pom_04_web.jsfclases.util.JsfUtil.PersistAction;
import ec.infocenter.pom_04_web.session.ImalabDescientoFacade;

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

@Named("imalabDescientoController")
@SessionScoped
public class ImalabDescientoController implements Serializable {

    @EJB
    private ec.infocenter.pom_04_web.session.ImalabDescientoFacade ejbFacade;
    private List<ImalabDesciento> items = null;
    private ImalabDesciento selected;

    public ImalabDescientoController() {
    }

    public ImalabDesciento getSelected() {
        return selected;
    }

    public void setSelected(ImalabDesciento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ImalabDescientoFacade getFacade() {
        return ejbFacade;
    }

    public ImalabDesciento prepareCreate() {
        selected = new ImalabDesciento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ImalabDescientoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ImalabDescientoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ImalabDescientoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ImalabDesciento> getItems() {
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

    public ImalabDesciento getImalabDesciento(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<ImalabDesciento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ImalabDesciento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ImalabDesciento.class)
    public static class ImalabDescientoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ImalabDescientoController controller = (ImalabDescientoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "imalabDescientoController");
            return controller.getImalabDesciento(getKey(value));
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
            if (object instanceof ImalabDesciento) {
                ImalabDesciento o = (ImalabDesciento) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ImalabDesciento.class.getName()});
                return null;
            }
        }

    }

}
