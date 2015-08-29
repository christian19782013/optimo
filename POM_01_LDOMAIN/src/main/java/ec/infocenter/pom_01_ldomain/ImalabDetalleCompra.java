/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_01_ldomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "IMALAB_DETALLE_COMPRA")
@NamedQueries({
    @NamedQuery(name = "ImalabDetalleCompra.findAll", query = "SELECT i FROM ImalabDetalleCompra i")})
public class ImalabDetalleCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Column(name = "ANULADO")
    private BigInteger anulado;
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "CABECERA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ImalabCabecera imalabCabecera;
    @JoinColumn(name = "PRECIO_CATALOGO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ImalabPrecio imalabPrecio;
    @JoinColumn(name = "REFERIDO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ImalabReferente imalabReferente;

    public ImalabDetalleCompra() {
    }

    public ImalabDetalleCompra(BigDecimal id) {
        this.id = id;
    }

    public ImalabDetalleCompra(BigDecimal id, BigInteger cantidad, BigDecimal precio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigInteger getAnulado() {
        return anulado;
    }

    public void setAnulado(BigInteger anulado) {
        this.anulado = anulado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ImalabCabecera getImalabCabecera() {
        return imalabCabecera;
    }

    public void setImalabCabecera(ImalabCabecera imalabCabecera) {
        this.imalabCabecera = imalabCabecera;
    }

    public ImalabPrecio getImalabPrecio() {
        return imalabPrecio;
    }

    public void setImalabPrecio(ImalabPrecio imalabPrecio) {
        this.imalabPrecio = imalabPrecio;
    }

    public ImalabReferente getImalabReferente() {
        return imalabReferente;
    }

    public void setImalabReferente(ImalabReferente imalabReferente) {
        this.imalabReferente = imalabReferente;
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
        if (!(object instanceof ImalabDetalleCompra)) {
            return false;
        }
        ImalabDetalleCompra other = (ImalabDetalleCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabDetalleCompra[ id=" + id + " ]";
    }
    
}
