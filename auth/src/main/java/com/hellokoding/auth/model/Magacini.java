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

import org.hibernate.validator.constraints.NotEmpty;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="magacini")
@NamedQueries({
//    @NamedQuery(name = "rptMagacini", query = "SELECT m.aktivan, m.name, "
//    		+ " m.akcija, m.code, "
//    		+ " m.remark, m.timestamp, m.slika, m.video,"
//    		+ " m.zvuk,  m.vrste_magacina_naziv FROM Magacini m" +  
//    		"")
    @NamedQuery(name = "Magacini.rptMagacini", query = " FROM Magacini " +  
    		"")
    
})
public class Magacini implements Serializable {
	
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
    private Boolean aktivan;
    private Date timestamp;
    private String vrste_magacina_naziv;
    private String slika;
    private String video;
    private String zvuk;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vrsteMagacina_id")
  //  @JsonIgnore
    @JsonBackReference
    private VrsteMagacina vrsteMagacina;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id" , referencedColumnName = "id")
  //  @JsonIgnore
    @JsonBackReference
    private Partner partner;    
    
    
    public Magacini(){
    }
    
    public Magacini(String name, VrsteMagacina vrsteMagacina){
    	this.name = name;
    	this.vrsteMagacina = vrsteMagacina;
    }
    
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
    @NotEmpty
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
    
    @NotEmpty
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
		
	public String getVrste_magacina_naziv() {
		return vrste_magacina_naziv;
	}

	public void setVrste_magacina_naziv(String vrste_magacina_naziv) {
		this.vrste_magacina_naziv = vrste_magacina_naziv;
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

	// vrste magacina

    public void setVrsteMagacina(VrsteMagacina vrsteMagacina){
    	this.vrsteMagacina = vrsteMagacina;
    }
    
    public VrsteMagacina getVrsteMagacina(){
    	return this.vrsteMagacina;
    }
    
    public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject vrsteMagacinaObj = new JSONObject();
        vrsteMagacinaObj.put("name", this.vrsteMagacina.getName());
        jsonInfo.put("vrsteMagacina", vrsteMagacinaObj);
        
        info = jsonInfo.toString();
        return info;
    }

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}
    
    
}
