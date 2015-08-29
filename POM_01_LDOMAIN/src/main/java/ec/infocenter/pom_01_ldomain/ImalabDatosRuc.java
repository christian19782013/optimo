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
@Table(name = "IMALAB_DATOS_RUC")
@NamedQueries({
    @NamedQuery(name = "ImalabDatosRuc.findAll", query = "SELECT i FROM ImalabDatosRuc i")})
public class ImalabDatosRuc implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "RUC")
    private String ruc;
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "AUTORIZACIONSRI")
    private String autorizacionsri;
    @OneToMany(mappedBy = "imalabDatosRuc", fetch = FetchType.LAZY)
    private List<ImalabCabecera> imalabCabeceraList;

    public ImalabDatosRuc() {
    }

    public ImalabDatosRuc(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAutorizacionsri() {
        return autorizacionsri;
    }

    public void setAutorizacionsri(String autorizacionsri) {
        this.autorizacionsri = autorizacionsri;
    }

    public List<ImalabCabecera> getImalabCabeceraList() {
        return imalabCabeceraList;
    }

    public void setImalabCabeceraList(List<ImalabCabecera> imalabCabeceraList) {
        this.imalabCabeceraList = imalabCabeceraList;
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
        if (!(object instanceof ImalabDatosRuc)) {
            return false;
        }
        ImalabDatosRuc other = (ImalabDatosRuc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabDatosRuc[ id=" + id + " ]";
    }
    
}
