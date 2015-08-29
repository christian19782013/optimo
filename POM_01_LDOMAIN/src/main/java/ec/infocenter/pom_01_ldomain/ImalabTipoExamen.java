/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_01_ldomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "IMALAB_TIPO_EXAMEN")
@NamedQueries({
    @NamedQuery(name = "ImalabTipoExamen.findAll", query = "SELECT i FROM ImalabTipoExamen i")})
public class ImalabTipoExamen implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "GRUPO")
    private BigInteger grupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imalabTipoExamen", fetch = FetchType.LAZY)
    private List<ImalabServicios> imalabServiciosList;

    public ImalabTipoExamen() {
    }

    public ImalabTipoExamen(BigDecimal id) {
        this.id = id;
    }

    public ImalabTipoExamen(BigDecimal id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getGrupo() {
        return grupo;
    }

    public void setGrupo(BigInteger grupo) {
        this.grupo = grupo;
    }

    public List<ImalabServicios> getImalabServiciosList() {
        return imalabServiciosList;
    }

    public void setImalabServiciosList(List<ImalabServicios> imalabServiciosList) {
        this.imalabServiciosList = imalabServiciosList;
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
        if (!(object instanceof ImalabTipoExamen)) {
            return false;
        }
        ImalabTipoExamen other = (ImalabTipoExamen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabTipoExamen[ id=" + id + " ]";
    }
    
}
