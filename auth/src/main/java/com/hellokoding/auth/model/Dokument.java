/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellokoding.auth.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author Nenad Kolar
 */
@Entity
@Table(name = "dokument")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dokument.findAll", query = "SELECT p FROM Dokument p")
    , @NamedQuery(name = "Dokument.findById", query = "SELECT p FROM Dokument p WHERE p.id = :id")
    , @NamedQuery(name = "Dokument.findByBrojDokumenta", query = "SELECT p FROM Dokument p WHERE p.brojDokumenta = :brojDokumenta")
 //   , @NamedQuery(name = "Dokument.findByIdMagacin", query = "SELECT p FROM Dokument p WHERE p.idMagacin = :idMagacin")
 //   , @NamedQuery(name = "Dokument.findByIdKomitent", query = "SELECT p FROM Dokument p WHERE p.idKomitent = :idKomitent")
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
    @Column(name = "brojDokumenta")
    private String brojDokumenta;
    
    // @Size(max = 45)
    @Column(name = "interniBrojDokumenta")
    private Long interniBrojDokumenta;    
    
//    @Column(name = "id_magacin")
//    private Long idMagacin;
     
    @ManyToOne(optional = false)
    @JoinColumn(name="id_magacin")
    private Magacini magacini;   
    
    @ManyToOne(optional = false)
    @JoinColumn(name="id_vrsta_dokumenta")
    private TypesOfDocuments typesofdocuments;
        
    @ManyToOne(optional = false)
    @JoinColumn(name="id_komitent")
    private Partner partner;  
    
    @ManyToOne(optional = true)
    @JoinColumn(name="id_komitent2")
    private Partner partner2;  

    @ManyToOne(optional = true)
    @JoinColumn(name="id_magacin2")
    private Magacini magacini2;   
    
    @ManyToOne(optional = true)
    @JoinColumn(name="id_vrsta_dokumenta2")
    private TypesOfDocuments typesofdocuments2;
    
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date datum;
    @Size(max = 255)
    @Column(name = "napomena")
    private String napomena;
    @Column(name = "aktivan")
    private Boolean aktivan;
    @Column(name = "datumVreme")
    @Temporal(TemporalType.TIMESTAMP)
    
    private Date datumVreme;
//    @Size(max = 45)
    @PrePersist
    protected void onCreate() {
    	datumVreme = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
    	datumVreme = new Date();
    }  
    @Column(name = "akcija")
    
    private String akcija;
    
    @Column(name = "iznos")
    private BigDecimal iznos;
    @Column(name = "porez")
    private BigDecimal porez;
    @Column(name = "iznos_bez_poreza")
    private BigDecimal iznos_bez_poreza;
    
    @Column(name = "host")
    private String host;
    
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    private String slika;
    private String video;
    private String zvuk;
    private String predao;
    private String primio;
    private String osnov;
    // @Value("0")
    @Column(name = "status")
    private int status;
    private Long veza;
    
//    @OneToMany(mappedBy = "idDokument", orphanRemoval = true, cascade = CascadeType.ALL)
//    @JsonManagedReference
        
//    private Set<DokumentStavke> dokumentStavkeCollection;
    

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

    public String getBrojDokumenta() {
        return brojDokumenta;
    }

    public void setBrojDokumenta(String brojDokumenta) {
        this.brojDokumenta = brojDokumenta;
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
//        return idMagacin;
//    }
//
//    public void setIdMagacin(Long idMagacin) {
//        this.idMagacin = idMagacin;
//    }

    public Magacini getMagacini() {
        return magacini;
    }
 
    public void setMagacini(Magacini magacini) {
        this.magacini = magacini;
    }
    
//    public Long getIdKomitent() {
//        return idKomitent;
//    }
//
//    public void setIdKomitent(Long idKomitent) {
//        this.idKomitent = idKomitent;
//    }

    public Partner getPartner() {
        return partner;
    }
 
    public void setPartner(Partner partner) {
        this.partner = partner;
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
	
	public BigDecimal getIznos() {
		return iznos;
	}
	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}
	public BigDecimal getPorez() {
		return porez;
	}
	public void setPorez(BigDecimal porez) {
		this.porez = porez;
	}
	public BigDecimal getIznos_bez_poreza() {
		return iznos_bez_poreza;
	}
	public void setIznos_bez_poreza(BigDecimal iznos_bez_poreza) {
		this.iznos_bez_poreza = iznos_bez_poreza;
	}
	
// if you have one to many
//	@XmlTransient
//    public Collection<DokumentStavke> getDokumentStavkeCollection() {
//        return dokumentStavkeCollection;
//    }
//
//    public void setDokumentStavkeCollection(Set<DokumentStavke> dokumentStavkeCollection) {
//        this.dokumentStavkeCollection = dokumentStavkeCollection;
//    }    

    public Long getInterniBrojDokumenta() {
		return interniBrojDokumenta;
	}
    
	public void setInterniBrojDokumenta(Long interniBrojDokumenta) {
		this.interniBrojDokumenta = interniBrojDokumenta;
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
        return "Dokument[ id=" + id + " ]";
    }
	public String getPredao() {
		return predao;
	}
	public void setPredao(String predao) {
		this.predao = predao;
	}
	public String getPrimio() {
		return primio;
	}
	public void setPrimio(String primio) {
		this.primio = primio;
	}
	public String getOsnov() {
		return osnov;
	}
	public void setOsnov(String osnov) {
		this.osnov = osnov;
	}
	public TypesOfDocuments getTypesofdocuments() {
		return typesofdocuments;
	}
	public void setTypesofdocuments(TypesOfDocuments typesofdocuments) {
		this.typesofdocuments = typesofdocuments;
	}
	public Partner getPartner2() {
		return partner2;
	}
	public void setPartner2(Partner partner2) {
		this.partner2 = partner2;
	}
	public Magacini getMagacini2() {
		return magacini2;
	}
	public void setMagacini2(Magacini magacini2) {
		this.magacini2 = magacini2;
	}
	public TypesOfDocuments getTypesofdocuments2() {
		return typesofdocuments2;
	}
	public void setTypesofdocuments2(TypesOfDocuments typesofdocuments2) {
		this.typesofdocuments2 = typesofdocuments2;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getVeza() {
		return veza;
	}
	public void setVeza(Long veza) {
		this.veza = veza;
	}   
    
    
}
