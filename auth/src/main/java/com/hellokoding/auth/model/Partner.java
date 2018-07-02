package com.hellokoding.auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.json.JSONObject;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="partner")

public class Partner implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
    private String name;
    private String remark;
    private String akcija;
    private String asoft_sifra;
    private String maticni_broj;
    private String pib;
    private String adresa;
    private String telefon;    
    private Boolean aktivan;
    private Date timestamp;
    private Long ptt_broj_id;
    private String ptt_broj_naziv;
    private String slika;
    private String video;
    private String zvuk;
    
    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "pttBrojevi_id")
//  //  @JsonIgnore
//    @JsonBackReference
//    
//    private Drzave drzave;
    
 //   @JsonIgnore
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner") // LAZY is default
    private List<Magacini> magacini = new ArrayList<>();    
    
    @ManyToOne(optional = false)
    @JoinColumn(name="ptt_id") 
    private PttBrojevi pttbrojevi;  
    
    public Partner(){
    }
    
//    public PttBrojevi(String name, Drzave drzave){
//    	this.name = name;
//    	this.drzave = drzave;
//    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAkcija() {
        return akcija;
    }

    public void setAkcija(String akcija) {
        this.akcija = akcija;
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
	@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Date getTimestamp() {
        return timestamp;
    }
    @PrePersist
    protected void onCreate() {
    	timestamp = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
    	timestamp = new Date();
    }  
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }   
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
		
	public String getAsoft_sifra() {
		return asoft_sifra;
	}

	public void setAsoft_sifra(String asoft_sifra) {
		this.asoft_sifra = asoft_sifra;
	}

	public String getMaticni_broj() {
		return maticni_broj;
	}

	public void setMaticni_broj(String maticni_broj) {
		this.maticni_broj = maticni_broj;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Long getPtt_broj_id() {
		return ptt_broj_id;
	}

	public void setPtt_broj_id(Long ptt_broj_id) {
		this.ptt_broj_id = ptt_broj_id;
	}

	public String getPtt_broj_naziv() {
		return ptt_broj_naziv;
	}

	public void setPtt_broj_naziv(String ptt_broj_naziv) {
		this.ptt_broj_naziv = ptt_broj_naziv;
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
	
	
	public List<Magacini> getMagacini() {
		return magacini;
	}

	public void setMagacini(List<Magacini> magacini) {
		this.magacini = magacini;
	}

	
	
	
//	@PreRemove
//	private void preRemove() {
//	    if (!magacini.isEmpty()) {
//	        try {
//				throw new Exception();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    }
//	}
	
//	// drzave  
//	public void setDrzava(Drzave drzave){
//    	this.drzave = drzave;
//    }
//    
//    public Drzave getDrzava(){
//    	return this.drzave;
//    }
    

	public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
//        JSONObject drzavaObj = new JSONObject();
//        drzavaObj.put("name", this.drzave.getName());
//        jsonInfo.put("drzava", drzavaObj);
        
        info = jsonInfo.toString();
        return info;
    }

	public PttBrojevi getPttbrojevi() {
		return pttbrojevi;
	}

	public void setPttbrojevi(PttBrojevi pttbrojevi) {
		this.pttbrojevi = pttbrojevi;
	}
	
	
}
