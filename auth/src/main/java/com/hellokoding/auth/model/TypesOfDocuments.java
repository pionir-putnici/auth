package com.hellokoding.auth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="types_of_documents")
public class TypesOfDocuments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
//	private static final long serialVersionUID = -4361643849564698178L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
    private String name;
    private String code;
    private String remark;
	private String akcija;
	private Long strana;
	private String type;		
	private Date timestamp;
	private boolean aktivan;
	private String slika;
	private String video;
	private String zvuk;
    
 //   @OneToMany(mappedBy = "vrsteArtikala", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @Fetch (FetchMode.SELECT)
//    @OneToMany(mappedBy = "drzave", orphanRemoval = true, 
//    cascade = CascadeType.PERSIST)
	

    
    public TypesOfDocuments(){
    }
    
    public TypesOfDocuments(String name){
    	this.name = name;
    }
    
    // name
	@Column(name = "name")
	@NotEmpty
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
	@Column(name = "code", unique=true)
	@NotEmpty  
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "akcija")
	public String getAkcija() {
		return akcija;
	}

	public void setAkcija(String akcija) {
		this.akcija = akcija;
	}
		
	@Column(name = "strana")
	
	public Long getStrana() {
		return strana;
	}

	public void setStrana(Long strana) {
		this.strana = strana;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
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
	
	@Column(columnDefinition="tinyint(1) default 1")
	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public String getSlike() {
		return slika;
	}

	public void setSlike(String slika) {
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

	@Override
	public String toString() {
		return "Types of documents [id=" + id + ", name=" + name + ", code=" + code + ", remark=" + remark + ", akcija=" + akcija
				+ ", timestamp=" + timestamp + ", aktivan=" + aktivan + ", slika=" + slika + ", video=" + video
				+ ", zvuk=" + zvuk + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
//	@Override
//	public String toString() {
//		return "VrsteArtikala [id=" + id + ", name=" + name  + "]";
//	}
    
//    public String toString(){
//    	String info = "";
//        JSONObject jsonInfo = new JSONObject();
//        jsonInfo.put("name",this.name);
//        
//        JSONArray productArray = new JSONArray();
//        if(this. != null){
//            this.pttBrojevi.forEach(pttBrojevi->{
//                JSONObject subJson = new JSONObject();
//                subJson.put("name", pttBrojevi.getName());
//                pttBrojeviArray.put(subJson);
//            });
//        }
//        jsonInfo.put("pttBrojevi", pttBrojeviArray);
//        info = jsonInfo.toString();
//        return info;
//    }
    
    
    
}
