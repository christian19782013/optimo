/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_01_ldomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "IMALAB_SERVICIOS")
@NamedQueries({
    @NamedQuery(name = "ImalabServicios.findAll", query = "SELECT i FROM ImalabServicios i")})
public class ImalabServicios implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DESCRIP_EXAMEN_LAB")
    private String descripExamenLab;
    @Column(name = "ESPECIFICACIONES")
    private String especificaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imalabServicios", fetch = FetchType.LAZY)
    private List<ImalabPrecio> imalabPrecioList;
    @JoinColumn(name = "TIPO_EXAMEN", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ImalabTipoExamen imalabTipoExamen;

    public ImalabServicios() {
    }

    public ImalabServicios(BigDecimal id) {
        this.id = id;
    }

    public ImalabServicios(BigDecimal id, String descripExamenLab) {
        this.id = id;
        this.descripExamenLab = descripExamenLab;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripExamenLab() {
        return descripExamenLab;
    }

    public void setDescripExamenLab(String descripExamenLab) {
        this.descripExamenLab = descripExamenLab;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public List<ImalabPrecio> getImalabPrecioList() {
        return imalabPrecioList;
    }

    public void setImalabPrecioList(List<ImalabPrecio> imalabPrecioList) {
        this.imalabPrecioList = imalabPrecioList;
    }

    public ImalabTipoExamen getImalabTipoExamen() {
        return imalabTipoExamen;
    }

    public void setImalabTipoExamen(ImalabTipoExamen imalabTipoExamen) {
        this.imalabTipoExamen = imalabTipoExamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImalabServicios)) {
            return false;
        }
        ImalabServicios other = (ImalabServicios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabServicios[ id=" + id + " ]";
    }
    
}
