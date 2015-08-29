/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_01_ldomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "IMALAB_CABECERA")
@NamedQueries({
    @NamedQuery(name = "ImalabCabecera.findAll", query = "SELECT i FROM ImalabCabecera i")})
public class ImalabCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    //ESTE COMENTARIO LO COLOCO YO DESDE LA DELL
    //PRUEBA
    //locuas
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA_FACTURA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    @Column(name = "NUMERO_FACTURA")
    private String numeroFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imalabCabecera", fetch = FetchType.LAZY)
    private List<ImalabDetalleCompra> imalabDetalleCompraList;
    @JoinColumn(name = "CLIENTE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ImalabCliente imalabCliente;
    @JoinColumn(name = "DATOS_RUC", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ImalabDatosRuc imalabDatosRuc;

    public ImalabCabecera() {
    }

    public ImalabCabecera(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public List<ImalabDetalleCompra> getImalabDetalleCompraList() {
        return imalabDetalleCompraList;
    }

    public void setImalabDetalleCompraList(List<ImalabDetalleCompra> imalabDetalleCompraList) {
        this.imalabDetalleCompraList = imalabDetalleCompraList;
    }

    public ImalabCliente getImalabCliente() {
        return imalabCliente;
    }

    public void setImalabCliente(ImalabCliente imalabCliente) {
        this.imalabCliente = imalabCliente;
    }

    public ImalabDatosRuc getImalabDatosRuc() {
        return imalabDatosRuc;
    }

    public void setImalabDatosRuc(ImalabDatosRuc imalabDatosRuc) {
        this.imalabDatosRuc = imalabDatosRuc;
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
        if (!(object instanceof ImalabCabecera)) {
            return false;
        }
        ImalabCabecera other = (ImalabCabecera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabCabecera[ id=" + id + " ]";
    }
    
}
