package com.hellokoding.auth.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="zapisnici")

public class Zapisnici implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
    private String remark;
    private String predao;
    private String primio;
    private String slika_zapisnika;        
    private String akcija;
    private Boolean aktivan;
    private Date timestamp;
    private String slika;
    private String video;
    private String zvuk;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dokument_id", referencedColumnName = "id")
    
  //  @JsonIgnore
  //  @JsonBackReference
    
    private Dokument dokument;
    
    public Zapisnici(){
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
        jsonInfo.put("name",this.code);
        
//        JSONObject drzavaObj = new JSONObject();
//        drzavaObj.put("name", this.drzave.getName());
//        jsonInfo.put("drzava", drzavaObj);
        
        info = jsonInfo.toString();
        return info;
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

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	public String getSlika_zapisnika() {
		return slika_zapisnika;
	}

	public void setSlika_zapisnika(String slika_zapisnika) {
		this.slika_zapisnika = slika_zapisnika;
	}
	
	
}
