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
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ms
 */
@Entity
@Table(name = "dokument_stavke")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DokumentStavke.findAll", query = "SELECT p FROM DokumentStavke p")
    , @NamedQuery(name = "DokumentStavke.findById", query = "SELECT p FROM DokumentStavke p WHERE p.id = :id")
    , @NamedQuery(name = "DokumentStavke.findByDatum", query = "SELECT p FROM DokumentStavke p WHERE p.datum = :datum")
 //   , @NamedQuery(name = "DokumentStavke.findByIdRoba", query = "SELECT p FROM DokumentStavke p WHERE p.idRoba = :idRoba")
    , @NamedQuery(name = "DokumentStavke.findByRobaNaziv", query = "SELECT p FROM DokumentStavke p WHERE p.robaNaziv = :robaNaziv")
    , @NamedQuery(name = "DokumentStavke.findByKolicina", query = "SELECT p FROM DokumentStavke p WHERE p.kolicina = :kolicina")
    , @NamedQuery(name = "DokumentStavke.findByCena", query = "SELECT p FROM DokumentStavke p WHERE p.cena = :cena")
    , @NamedQuery(name = "DokumentStavke.findByIznos", query = "SELECT p FROM DokumentStavke p WHERE p.iznos = :iznos")
    , @NamedQuery(name = "DokumentStavke.findByAktivan", query = "SELECT p FROM DokumentStavke p WHERE p.aktivan = :aktivan")
    , @NamedQuery(name = "DokumentStavke.findByDatumvreme", query = "SELECT p FROM DokumentStavke p WHERE p.datumvreme = :datumvreme")
    , @NamedQuery(name = "DokumentStavke.findByAkcija", query = "SELECT p FROM DokumentStavke p WHERE p.akcija = :akcija")
    , @NamedQuery(name = "DokumentStavke.findByHost", query = "SELECT p FROM DokumentStavke p WHERE p.host = :host")
    , @NamedQuery(name = "DokumentStavke.findByUlaz", query = "SELECT p FROM DokumentStavke p WHERE p.ulaz = :ulaz")
    , @NamedQuery(name = "DokumentStavke.findByIzlaz", query = "SELECT p FROM DokumentStavke p WHERE p.izlaz = :izlaz")
    , @NamedQuery(name = "DokumentStavke.findByNapomena", query = "SELECT p FROM DokumentStavke p WHERE p.napomena = :napomena")
//    , @NamedQuery(name = "DokumentStavke.findByIdDokument", query = "SELECT p FROM DokumentStavke p WHERE p.idDokument = :idDokument")

    , @NamedQuery(name = "DokumentStavke.findByDokumentStavkecol", query = "SELECT p FROM DokumentStavke p WHERE p.dokumentStavkecol = :dokumentStavkecol")})

public class DokumentStavke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
//    @Column(name = "id_vrsta_dokumenta")
//    private Long idVrstaDokumenta;    
    
    @ManyToOne(optional = false)
    @JoinColumn(name="id_vrsta_dokumenta")
    private TypesOfDocuments typesofdocuments;   
    
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    
    @ManyToOne(optional = false)
    @JoinColumn(name="id_magacin")
    private Magacini magacini;  

    @ManyToOne(optional = false)
    @JoinColumn(name="id_roba")
    private Artikli artikli; 
    
//    @Column(name = "id_magacin")
//    private Long idMagacin;    
    
//    @Column(name = "id_roba")
//    private Long idRoba;
    
    @Size(max = 45)
    @Column(name = "roba_naziv")
    private String robaNaziv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kolicina")
    private BigDecimal kolicina;
    @Column(name = "ulaz")
    private BigDecimal ulaz;
    @Column(name = "izlaz")
    private BigDecimal izlaz;    
    @Column(name = "cena")
    private BigDecimal cena;
    @Column(name = "iznos")
    private BigDecimal iznos;
    @Column(name = "duguje")
    private BigDecimal duguje;
    @Column(name = "potrazuje")
    private BigDecimal potrazuje;       
    @Column(name = "aktivan", columnDefinition="tinyint(1) default 1")
    
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
    @Size(max = 255)
    @Column(name = "napomena")
    private String napomena;
    @Size(max = 45)
    @Column(name = "dokument_stavkecol")
    private String dokumentStavkecol;
    
    @JoinColumn(name = "id_dokument", referencedColumnName = "id")
    @ManyToOne
//    @JsonBackReference
    private Dokument idDokument;
        
    public DokumentStavke() {
    }

    public DokumentStavke(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

//    public Long getIdRoba() {
//        return idRoba;
//    }
//
//    public void setIdRoba(Long idRoba) {
//        this.idRoba = idRoba;
//    }

    public Artikli getArtikli() {
        return artikli;
    }
 
    public void setArtikli(Artikli artikli) {
        this.artikli = artikli;
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
    
//    public Long getIdVrstaDokumenta() {
//		return idVrstaDokumenta;
//	}
//
//	public void setIdVrstaDokumenta(Long idVrstaDokumenta) {
//		this.idVrstaDokumenta = idVrstaDokumenta;
//	}

    public TypesOfDocuments getTypesOfDocuments() {
        return typesofdocuments;
    }
 
    public void setTypesOfDocuments(TypesOfDocuments typesofdocuments) {
        this.typesofdocuments = typesofdocuments;
    }
    
//	public Long getIdMagacin() {
//		return idMagacin;
//	}
//
//	public void setIdMagacin(Long idMagacin) {
//		this.idMagacin = idMagacin;
//	}

    public Magacini getMagacini() {
        return magacini;
    }
 
    public void setMagacini(Magacini magacini) {
        this.magacini = magacini;
    }
    
	public BigDecimal getDuguje() {
		return duguje;
	}

	public void setDuguje(BigDecimal duguje) {
		this.duguje = duguje;
	}

	public BigDecimal getPotrazuje() {
		return potrazuje;
	}

	public void setPotrazuje(BigDecimal potrazuje) {
		this.potrazuje = potrazuje;
	}

	public String getDokumentStavkecol() {
        return dokumentStavkecol;
    }

    public void setDokumentStavkecol(String dokumentStavkecol) {
        this.dokumentStavkecol = dokumentStavkecol;
    }
    
    public Dokument getIdDokument() {
        return idDokument;
    }

    public void setIdDokument(Dokument idDokument) {
        this.idDokument = idDokument;
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
        if (!(object instanceof DokumentStavke)) {
            return false;
        }
        DokumentStavke other = (DokumentStavke) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String toString1() {
        return "DokumentStavke[ id=" + id + " ]";
    }

	@Override
	public String toString() {
		return "DokumentStavke [id=" + id + ",  datum=" + datum + ", partner=" + idDokument.getPartner().getName()
				+ ", magacini=" + idDokument.getMagacini().getName() + ", artikli=" + artikli.getName() + ",  kolicina="
				+ kolicina + ", cena=" + cena + ", iznos=" + iznos + ", idDokument=" + idDokument + "br/" + "]";
	}
    
//	@Override
//	public String toString() {
//		return "DokumentStavke [id=" + id + ", typesofdocuments=" + typesofdocuments + ", datum=" + datum
//				+ ", magacini=" + magacini + ", artikli=" + artikli + ", robaNaziv=" + robaNaziv + ", kolicina="
//				+ kolicina + ", ulaz=" + ulaz + ", izlaz=" + izlaz + ", cena=" + cena + ", iznos=" + iznos + ", duguje="
//				+ duguje + ", potrazuje=" + potrazuje + ", aktivan=" + aktivan + ", datumvreme=" + datumvreme
//				+ ", akcija=" + akcija + ", host=" + host + ", napomena=" + napomena + ", dokumentStavkecol="
//				+ dokumentStavkecol + ", idDokument=" + idDokument + "]";
//	} 
    
}
