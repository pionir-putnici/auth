/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.auth.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ms
 */
@Entity
@Table(name = "prijemnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prijemnica.findAll", query = "SELECT p FROM Prijemnica p")
    , @NamedQuery(name = "Prijemnica.findById", query = "SELECT p FROM Prijemnica p WHERE p.id = :id")
    , @NamedQuery(name = "Prijemnica.findByBrojPrijemnice", query = "SELECT p FROM Prijemnica p WHERE p.brojPrijemnice = :brojPrijemnice")
    , @NamedQuery(name = "Prijemnica.findByIdMagacin", query = "SELECT p FROM Prijemnica p WHERE p.idMagacin = :idMagacin")
    , @NamedQuery(name = "Prijemnica.findByIdKomitent", query = "SELECT p FROM Prijemnica p WHERE p.idKomitent = :idKomitent")
    , @NamedQuery(name = "Prijemnica.findByDatum", query = "SELECT p FROM Prijemnica p WHERE p.datum = :datum")
    , @NamedQuery(name = "Prijemnica.findByNapomena", query = "SELECT p FROM Prijemnica p WHERE p.napomena = :napomena")
    , @NamedQuery(name = "Prijemnica.findByAktivan", query = "SELECT p FROM Prijemnica p WHERE p.aktivan = :aktivan")
    , @NamedQuery(name = "Prijemnica.findByDatumVreme", query = "SELECT p FROM Prijemnica p WHERE p.datumVreme = :datumVreme")
    , @NamedQuery(name = "Prijemnica.findByAkcija", query = "SELECT p FROM Prijemnica p WHERE p.akcija = :akcija")
    , @NamedQuery(name = "Prijemnica.findByHost", query = "SELECT p FROM Prijemnica p WHERE p.host = :host")
    , @NamedQuery(name = "Prijemnica.findByUser", query = "SELECT p FROM Prijemnica p WHERE p.user = :user")})
public class Prijemnica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "brojPrijemnice")
    private String brojPrijemnice;
    @Column(name = "id_magacin")
    private Integer idMagacin;
    @Column(name = "id_komitent")
    private Integer idKomitent;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Size(max = 255)
    @Column(name = "napomena")
    private String napomena;
    @Column(name = "aktivan")
    private Boolean aktivan;
    @Column(name = "datumVreme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumVreme;
    @Size(max = 45)
    @Column(name = "akcija")
    private String akcija;
    @Size(max = 45)
    @Column(name = "host")
    private String host;
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    @OneToMany(mappedBy = "idPrijemnica")
    private Collection<PrijemnicaStavke> prijemnicaStavkeCollection;

    public Prijemnica() {
    }

    public Prijemnica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrojPrijemnice() {
        return brojPrijemnice;
    }

    public void setBrojPrijemnice(String brojPrijemnice) {
        this.brojPrijemnice = brojPrijemnice;
    }

    public Integer getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(Integer idMagacin) {
        this.idMagacin = idMagacin;
    }

    public Integer getIdKomitent() {
        return idKomitent;
    }

    public void setIdKomitent(Integer idKomitent) {
        this.idKomitent = idKomitent;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getAkcija() {
        return akcija;
    }

    public void setAkcija(String akcija) {
        this.akcija = akcija;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @XmlTransient
    public Collection<PrijemnicaStavke> getPrijemnicaStavkeCollection() {
        return prijemnicaStavkeCollection;
    }

    public void setPrijemnicaStavkeCollection(Collection<PrijemnicaStavke> prijemnicaStavkeCollection) {
        this.prijemnicaStavkeCollection = prijemnicaStavkeCollection;
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
        if (!(object instanceof Prijemnica)) {
            return false;
        }
        Prijemnica other = (Prijemnica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenwebapplication.Prijemnica[ id=" + id + " ]";
    }
    
}
