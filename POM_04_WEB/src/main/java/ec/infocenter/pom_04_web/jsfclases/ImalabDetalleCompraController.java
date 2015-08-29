package ec.infocenter.pom_04_web.jsfclases;

import ec.infocenter.pom_01_ldomain.ImalabDetalleCompra;
import ec.infocenter.pom_04_web.jsfclases.util.JsfUtil;
import ec.infocenter.pom_04_web.jsfclases.util.JsfUtil.PersistAction;
import ec.infocenter.pom_04_web.session.ImalabDetalleCompraFacade;

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

@Named("imalabDetalleCompraController")
@SessionScoped
public class ImalabDetalleCompraController implements Serializable {

    @EJB
    private ec.infocenter.pom_04_web.session.ImalabDetalleCompraFacade ejbFacade;
    private List<ImalabDetalleCompra> items = null;
    private ImalabDetalleCompra selected;

    public ImalabDetalleCompraController() {
    }

    public ImalabDetalleCompra getSelected() {
        return selected;
    }

    public void setSelected(ImalabDetalleCompra selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ImalabDetalleCompraFacade getFacade() {
        return ejbFacade;
    }

    public ImalabDetalleCompra prepareCreate() {
        selected = new ImalabDetalleCompra();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ImalabDetalleCompraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ImalabDetalleCompraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ImalabDetalleCompraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ImalabDetalleCompra> getItems() {
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

    public ImalabDetalleCompra getImalabDetalleCompra(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<ImalabDetalleCompra> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ImalabDetalleCompra> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ImalabDetalleCompra.class)
    public static class ImalabDetalleCompraControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ImalabDetalleCompraController controller = (ImalabDetalleCompraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "imalabDetalleCompraController");
            return controller.getImalabDetalleCompra(getKey(value));
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
            if (object instanceof ImalabDetalleCompra) {
                ImalabDetalleCompra o = (ImalabDetalleCompra) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ImalabDetalleCompra.class.getName()});
                return null;
            }
        }

    }

}
