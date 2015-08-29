/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_01_ldomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "IMALAB_PRECIO")
@NamedQueries({
    @NamedQuery(name = "ImalabPrecio.findAll", query = "SELECT i FROM ImalabPrecio i")})
public class ImalabPrecio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "FECHA_FIJA_PRECIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFijaPrecio;
    @Column(name = "VALOR")
    private BigInteger valor;
    @JoinColumn(name = "APLICA_DESCUENTO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ImalabDesciento imalabDesciento;
    @JoinColumn(name = "SERVICIOS", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ImalabServicios imalabServicios;
    @OneToMany(mappedBy = "imalabPrecio", fetch = FetchType.LAZY)
    private List<ImalabDetalleCompra> imalabDetalleCompraList;

    public ImalabPrecio() {
    }

    public ImalabPrecio(BigDecimal id) {
        this.id = id;
    }

    public ImalabPrecio(BigDecimal id, Date fechaFijaPrecio) {
        this.id = id;
        this.fechaFijaPrecio = fechaFijaPrecio;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaFijaPrecio() {
        return fechaFijaPrecio;
    }

    public void setFechaFijaPrecio(Date fechaFijaPrecio) {
        this.fechaFijaPrecio = fechaFijaPrecio;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public ImalabDesciento getImalabDesciento() {
        return imalabDesciento;
    }

    public void setImalabDesciento(ImalabDesciento imalabDesciento) {
        this.imalabDesciento = imalabDesciento;
    }

    public ImalabServicios getImalabServicios() {
        return imalabServicios;
    }

    public void setImalabServicios(ImalabServicios imalabServicios) {
        this.imalabServicios = imalabServicios;
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
        if (!(object instanceof ImalabPrecio)) {
            return false;
        }
        ImalabPrecio other = (ImalabPrecio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabPrecio[ id=" + id + " ]";
    }
    
}
