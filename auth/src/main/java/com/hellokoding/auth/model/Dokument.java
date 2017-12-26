/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.auth.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author ms
 */
@Entity
@Table(name = "dokument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokument.findAll", query = "SELECT p FROM Dokument p")
    , @NamedQuery(name = "Dokument.findById", query = "SELECT p FROM Dokument p WHERE p.id = :id")
    , @NamedQuery(name = "Dokument.findByBrojPrijemnice", query = "SELECT p FROM Dokument p WHERE p.brojPrijemnice = :brojPrijemnice")
    , @NamedQuery(name = "Dokument.findByIdMagacin", query = "SELECT p FROM Dokument p WHERE p.idMagacin = :idMagacin")
    , @NamedQuery(name = "Dokument.findByIdKomitent", query = "SELECT p FROM Dokument p WHERE p.idKomitent = :idKomitent")
    , @NamedQuery(name = "Dokument.findByDatum", query = "SELECT p FROM Dokument p WHERE p.datum = :datum")
    , @NamedQuery(name = "Dokument.findByNapomena", query = "SELECT p FROM Dokument p WHERE p.napomena = :napomena")
    , @NamedQuery(name = "Dokument.findByAktivan", query = "SELECT p FROM Dokument p WHERE p.aktivan = :aktivan")
    , @NamedQuery(name = "Dokument.findByDatumVreme", query = "SELECT p FROM Dokument p WHERE p.datumVreme = :datumVreme")
    , @NamedQuery(name = "Dokument.findByAkcija", query = "SELECT p FROM Dokument p WHERE p.akcija = :akcija")
    , @NamedQuery(name = "Dokument.findByHost", query = "SELECT p FROM Dokument p WHERE p.host = :host")
    , @NamedQuery(name = "Dokument.findByUser", query = "SELECT p FROM Dokument p WHERE p.user = :user")})
public class Dokument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 45)
    @Column(name = "brojPrijemnice")
    private String brojPrijemnice;
    @Column(name = "id_magacin")
    private Long idMagacin;
    @Column(name = "id_vrsta_dokumenta")
    private Long idVrstaDokumenta;
    @Column(name = "id_komitent")
    private Long idKomitent;
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
    private String slika;
    private String video;
    private String zvuk;
    
    @OneToMany(mappedBy = "idDokument", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<DokumentStavke> dokumentStavkeCollection;
    

    public Dokument() {
    }

    public Dokument(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojPrijemnice() {
        return brojPrijemnice;
    }

    public void setBrojPrijemnice(String brojPrijemnice) {
        this.brojPrijemnice = brojPrijemnice;
    }

    public Long getIdMagacin() {
        return idMagacin;
    }

    public void setIdMagacin(Long idMagacin) {
        this.idMagacin = idMagacin;
    }

    public Long getIdKomitent() {
        return idKomitent;
    }

    public void setIdKomitent(Long idKomitent) {
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
        
    public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getZvuk() {
		return zvuk;
	}

	public void setZvuk(String zvuk) {
		this.zvuk = zvuk;
	}

	@XmlTransient
    public Set<DokumentStavke> getDokumentStavkeCollection() {
        return dokumentStavkeCollection;
    }

    public void setDokumentStavkeCollection(Set<DokumentStavke> dokumentStavkeCollection) {
        this.dokumentStavkeCollection = dokumentStavkeCollection;
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
        if (!(object instanceof Dokument)) {
            return false;
        }
        Dokument other = (Dokument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenwebapplication.Dokument[ id=" + id + " ]";
    }
    
}
