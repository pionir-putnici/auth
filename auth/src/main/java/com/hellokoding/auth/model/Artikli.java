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
@Table(name="artikli")
@NamedQueries({
//    @NamedQuery(name = "rptArtikli", query = "SELECT m.aktivan, m.name, "
//    		+ " m.akcija, m.code, "
//    		+ " m.remark, m.timestamp, m.slika, m.video,"
//    		+ " m.zvuk,  m.vrste_artikala_naziv FROM Artikli m" +  
//    		"")
    @NamedQuery(name = "Artikli.rptArtikli", query = " FROM Artikli " +  
    		"")
    
})
public class Artikli implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String code1;
	private String code2;
    private String name;
    private String remark;
    private String akcija;
    private Boolean aktivan;
    private Date timestamp;
    private String vrste_artikala_naziv;
    private String slika;
    private String video;
    private String zvuk;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vrsteArtikala_id")
  //  @JsonIgnore
    @JsonBackReference
    private VrsteArtikala vrsteArtikala;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jediniceMera_id")
    @JsonIgnore
    @JsonBackReference
    private JediniceMera jediniceMera;  
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "poreskeGrupe_id")
  //  @JsonIgnore
    @JsonBackReference
    private PoreskeGrupe poreskeGrupe;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "klasifikacije_id")
  //  @JsonIgnore
    @JsonBackReference
    private Klasifikacije klasifikacije;
    
    public Artikli(){
    }
    
    public Artikli(String name, VrsteArtikala vrsteArtikala){
    	this.name = name;
    	this.vrsteArtikala = vrsteArtikala;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	@Column(name = "akcija")  	
   
    public String getAkcija() {
        return akcija;
    }

    public void setAkcija(String akcija) {
        this.akcija = akcija;
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
    
	@Column(name = "aktivan")  	
 
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
    
	@Column(name = "code")  	
	@NotEmpty 
	
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "code1")	
	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}
	@Column(name = "code2")
	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}
	@Column(name = "remark")	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
		
	@Column(name = "vrste_artikala_naziv")
	public String getVrste_artikala_naziv() {
		return vrste_artikala_naziv;
	}

	public void setVrste_artikala_naziv(String vrste_artikala_naziv) {
		this.vrste_artikala_naziv = vrste_artikala_naziv;
	}
	@Column(name = "slika")
	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}
	@Column(name = "video")
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	@Column(name = "zvuk")
	public String getZvuk() {
		return zvuk;
	}

	public void setZvuk(String zvuk) {
		this.zvuk = zvuk;
	}

	// vrste Artikala
    public void setVrsteArtikala(VrsteArtikala vrsteArtikala){
    	this.vrsteArtikala = vrsteArtikala;
    }
    
    public VrsteArtikala getVrsteArtikala(){
    	return this.vrsteArtikala;
    }
    
	// jedinice mera
    public void setJediniceMera(JediniceMera jediniceMera){
    	this.jediniceMera = jediniceMera;
    }
    
    public JediniceMera getJediniceMera(){
    	return this.jediniceMera;
    }    
    
	// poreske grupe
    public void setPoreskeGrupe(PoreskeGrupe poreskeGrupe){
    	this.poreskeGrupe = poreskeGrupe;
    }
    
    public PoreskeGrupe getPoreskeGrupe(){
    	return this.poreskeGrupe;
    }        
    
	// klasifikacije
    public void setKlasifikacije(Klasifikacije klasifikacije){
    	this.klasifikacije = klasifikacije;
    }
    
    public Klasifikacije getKlasifikacije(){
    	return this.klasifikacije;
    }     
    public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONObject vrsteArtikalaObj = new JSONObject();
        vrsteArtikalaObj.put("name", this.vrsteArtikala.getName());
        jsonInfo.put("vrsteArtikala", vrsteArtikalaObj);
        
        info = jsonInfo.toString();
        return info;
    }
}
