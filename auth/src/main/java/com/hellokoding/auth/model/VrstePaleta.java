package com.hellokoding.auth.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "vrste_paleta")
public class VrstePaleta {

	private Long uid;
	private String code;
	private String name;
	private String remark;
	private String akcija;
	private Date timestamp;
	private boolean aktivan;

//    @OneToMany(mappedBy = "vrstePaleta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @Fetch (FetchMode.SELECT)
//    @JsonManagedReference
//    private Set<Artikli> artikli;
    
	public VrstePaleta(String name) {
		this.name = name;
		timestamp = new Date();
	}

	// no argument constructor zbog Hibernate
	public VrstePaleta() {
	}
	
	@Id
	@GeneratedValue
//	@NotNull
	@Column(name = "uid", unique = true)
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
	
	@Column
	@NotEmpty
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name")
	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
    @Column
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    @Column	
	public String getAkcija() {
		return akcija;
	}

	public void setAkcija(String akcija) {
		this.akcija = akcija;
	}

	
//	@Column
//	@DefaultValue(1)
	@Column(columnDefinition="tinyint(1) default 1")
	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
	// @NotNull
	@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	// @Column(name = "timestamp")
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

	// articles
//    public vouid setArtikli(Set<Artikli> artikli){
//    	this.artikli = artikli;
//    }
//    
//    public Set<Artikli> getArtikli(){
//    	return this.artikli;
//    }	
    
	@Override
	public String toString() {
		return "VrstePaleta [uid=" + uid + ", code=" + code + ", name=" + name + ", remark=" + remark + ", akcija="
				+ akcija + ", timestamp=" + timestamp + ", aktivan=" + aktivan + "]";
	}
	
	

}
