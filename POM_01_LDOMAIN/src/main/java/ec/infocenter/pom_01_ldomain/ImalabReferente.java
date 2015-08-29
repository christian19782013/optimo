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
@Table(name = "IMALAB_REFERENTE")
@NamedQueries({
    @NamedQuery(name = "ImalabReferente.findAll", query = "SELECT i FROM ImalabReferente i")})
public class ImalabReferente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "CC")
    private String cc;
    @Column(name = "PORCENTAJE_REFERENTE")
    private BigInteger porcentajeReferente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imalabReferente", fetch = FetchType.LAZY)
    private List<ImalabDetalleCompra> imalabDetalleCompraList;

    public ImalabReferente() {
    }

    public ImalabReferente(BigDecimal id) {
        this.id = id;
    }

    public ImalabReferente(BigDecimal id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public BigInteger getPorcentajeReferente() {
        return porcentajeReferente;
    }

    public void setPorcentajeReferente(BigInteger porcentajeReferente) {
        this.porcentajeReferente = porcentajeReferente;
    }

    public List<ImalabDetalleCompra> getImalabDetalleCompraList() {
        return imalabDetalleCompraList;
    }

    public void setImalabDetalleCompraList(List<ImalabDetalleCompra> imalabDetalleCompraList) {
        this.imalabDetalleCompraList = imalabDetalleCompraList;
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
        if (!(object instanceof ImalabReferente)) {
            return false;
        }
        ImalabReferente other = (ImalabReferente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabReferente[ id=" + id + " ]";
    }
    
}
