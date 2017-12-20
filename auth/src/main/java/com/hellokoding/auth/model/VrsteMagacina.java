package com.hellokoding.auth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name="vrste_magacina")
public class VrsteMagacina implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1562580907715592005L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
    private String code;
    private String name;
    private String remark;
    private String akcija;
	private Date timestamp;
	private boolean aktivan;
    
   // @OneToMany(mappedBy = "vrsteMagacina", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch (FetchMode.SELECT)
    @OneToMany(mappedBy = "vrsteMagacina", orphanRemoval = true, 
    		cascade = {CascadeType.ALL})
 //   .PERSIST, CascadeType.MERGE
    @JsonManagedReference
    
 //   private Set<Magacini> magacini;
    private List<Magacini> magacini;
    
    public VrsteMagacina(){
    }
    
    public VrsteMagacina(String name){
    	this.name = name;
    }
    
    // code
	@Column(name = "code")  	
	@NotEmpty 
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
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
  
    // remark
	@Column(name = "remark")  	

    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }   
    
    
        
    public String getAkcija() {
		return akcija;
	}

	public void setAkcija(String akcija) {
		this.akcija = akcija;
	}

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

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	// warehouse
//    public void setMagacini(Set<Magacini> magacini){
//    	this.magacini = magacini;
//    }
//    
//    public Set<Magacini> getMagacini(){
//    	return this.magacini;
//    }
    
    public List<Magacini> getMagacini(){
    	return this.magacini;
    }	
 //   public void setMagaciniAll(Set<Magacini> magacini) {
	
//	@NotEmpty 	
    public void setMagacini(List<Magacini> list) {
    	  if (this.magacini == null) {
    	    this.magacini = list;
    	  } else {
    	    this.magacini.retainAll(list);
    	   this.magacini.addAll(list);
    	  }
    	}
    
    public String toString(){
    	String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);
        
        JSONArray productArray = new JSONArray();
        if(this.magacini != null){
//            this.products.forEach(product->{
//                JSONObject subJson = new JSONObject();
//                subJson.put("name", product.getName());
//                productArray.put(subJson);
//            });
        }
        jsonInfo.put("products", productArray);
        info = jsonInfo.toString();
        return info;
    }
}
