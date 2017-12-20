/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.auth.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ms
 */
@Entity
@Table(name = "prijemnica_stavke")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrijemnicaStavke.findAll", query = "SELECT p FROM PrijemnicaStavke p")
    , @NamedQuery(name = "PrijemnicaStavke.findById", query = "SELECT p FROM PrijemnicaStavke p WHERE p.id = :id")
    , @NamedQuery(name = "PrijemnicaStavke.findByDatum", query = "SELECT p FROM PrijemnicaStavke p WHERE p.datum = :datum")
    , @NamedQuery(name = "PrijemnicaStavke.findByIdRoba", query = "SELECT p FROM PrijemnicaStavke p WHERE p.idRoba = :idRoba")
    , @NamedQuery(name = "PrijemnicaStavke.findByRobaNaziv", query = "SELECT p FROM PrijemnicaStavke p WHERE p.robaNaziv = :robaNaziv")
    , @NamedQuery(name = "PrijemnicaStavke.findByKolicina", query = "SELECT p FROM PrijemnicaStavke p WHERE p.kolicina = :kolicina")
    , @NamedQuery(name = "PrijemnicaStavke.findByCena", query = "SELECT p FROM PrijemnicaStavke p WHERE p.cena = :cena")
    , @NamedQuery(name = "PrijemnicaStavke.findByIznos", query = "SELECT p FROM PrijemnicaStavke p WHERE p.iznos = :iznos")
    , @NamedQuery(name = "PrijemnicaStavke.findByAktivan", query = "SELECT p FROM PrijemnicaStavke p WHERE p.aktivan = :aktivan")
    , @NamedQuery(name = "PrijemnicaStavke.findByDatumvreme", query = "SELECT p FROM PrijemnicaStavke p WHERE p.datumvreme = :datumvreme")
    , @NamedQuery(name = "PrijemnicaStavke.findByAkcija", query = "SELECT p FROM PrijemnicaStavke p WHERE p.akcija = :akcija")
    , @NamedQuery(name = "PrijemnicaStavke.findByHost", query = "SELECT p FROM PrijemnicaStavke p WHERE p.host = :host")
    , @NamedQuery(name = "PrijemnicaStavke.findByUlaz", query = "SELECT p FROM PrijemnicaStavke p WHERE p.ulaz = :ulaz")
    , @NamedQuery(name = "PrijemnicaStavke.findByIzlaz", query = "SELECT p FROM PrijemnicaStavke p WHERE p.izlaz = :izlaz")
    , @NamedQuery(name = "PrijemnicaStavke.findByNapomena", query = "SELECT p FROM PrijemnicaStavke p WHERE p.napomena = :napomena")
    , @NamedQuery(name = "PrijemnicaStavke.findByPrijemnicaStavkecol", query = "SELECT p FROM PrijemnicaStavke p WHERE p.prijemnicaStavkecol = :prijemnicaStavkecol")})
public class PrijemnicaStavke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Column(name = "id_roba")
    private Integer idRoba;
    @Size(max = 45)
    @Column(name = "roba_naziv")
    private String robaNaziv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kolicina")
    private BigDecimal kolicina;
    @Column(name = "cena")
    private BigDecimal cena;
    @Column(name = "iznos")
    private BigDecimal iznos;
    @Column(name = "aktivan")
    private Boolean aktivan;
    @Column(name = "datumvreme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumvreme;
    @Size(max = 45)
    @Column(name = "akcija")
    private String akcija;
    @Size(max = 45)
    @Column(name = "host")
    private String host;
    @Column(name = "ulaz")
    private BigDecimal ulaz;
    @Column(name = "izlaz")
    private BigDecimal izlaz;
    @Size(max = 255)
    @Column(name = "napomena")
    private String napomena;
    @Size(max = 45)
    @Column(name = "prijemnica_stavkecol")
    private String prijemnicaStavkecol;
    @JoinColumn(name = "id_prijemnica", referencedColumnName = "id")
    @ManyToOne
    private Prijemnica idPrijemnica;

    public PrijemnicaStavke() {
    }

    public PrijemnicaStavke(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getIdRoba() {
        return idRoba;
    }

    public void setIdRoba(Integer idRoba) {
        this.idRoba = idRoba;
    }

    public String getRobaNaziv() {
        return robaNaziv;
    }

    public void setRobaNaziv(String robaNaziv) {
        this.robaNaziv = robaNaziv;
    }

    public BigDecimal getKolicina() {
        return kolicina;
    }

    public void setKolicina(BigDecimal kolicina) {
        this.kolicina = kolicina;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Date getDatumvreme() {
        return datumvreme;
    }

    public void setDatumvreme(Date datumvreme) {
        this.datumvreme = datumvreme;
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

    public BigDecimal getUlaz() {
        return ulaz;
    }

    public void setUlaz(BigDecimal ulaz) {
        this.ulaz = ulaz;
    }

    public BigDecimal getIzlaz() {
        return izlaz;
    }

    public void setIzlaz(BigDecimal izlaz) {
        this.izlaz = izlaz;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getPrijemnicaStavkecol() {
        return prijemnicaStavkecol;
    }

    public void setPrijemnicaStavkecol(String prijemnicaStavkecol) {
        this.prijemnicaStavkecol = prijemnicaStavkecol;
    }

    public Prijemnica getIdPrijemnica() {
        return idPrijemnica;
    }

    public void setIdPrijemnica(Prijemnica idPrijemnica) {
        this.idPrijemnica = idPrijemnica;
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
        if (!(object instanceof PrijemnicaStavke)) {
            return false;
        }
        PrijemnicaStavke other = (PrijemnicaStavke) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenwebapplication.PrijemnicaStavke[ id=" + id + " ]";
    }
    
}
