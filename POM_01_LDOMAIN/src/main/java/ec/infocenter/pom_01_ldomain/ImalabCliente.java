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
@Table(name = "IMALAB_CLIENTE")
@NamedQueries({
    @NamedQuery(name = "ImalabCliente.findAll", query = "SELECT i FROM ImalabCliente i")})
public class ImalabCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "RUC_CEDULA")
    private String rucCedula;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(mappedBy = "imalabCliente", fetch = FetchType.LAZY)
    private List<ImalabCabecera> imalabCabeceraList;

    public ImalabCliente() {
    }

    public ImalabCliente(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRucCedula() {
        return rucCedula;
    }

    public void setRucCedula(String rucCedula) {
        this.rucCedula = rucCedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof ImalabCliente)) {
            return false;
        }
        ImalabCliente other = (ImalabCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.infocenter.pom_01_ldomain.ImalabCliente[ id=" + id + " ]";
    }
    
}
