package com.hellokoding.auth.model;

import java.math.BigDecimal;

public class SumMagacinArtikal {
    
    private Long id;
    private Long id_magacin;
    private Long id_artikal;
    private BigDecimal stanje;
    
    public SumMagacinArtikal() {}

	public SumMagacinArtikal(long l, long m, long n, BigDecimal d) {
		// TODO Auto-generated constructor stub
		this.id=l;
		this.id_magacin=m;
		this.id_artikal=n;
		this.stanje=d;		
	}

	public SumMagacinArtikal(Long l, Long m, Long n, BigDecimal d) {
		this.id=l;
		this.id_magacin=m;
		this.id_artikal=n;
		this.stanje=d;
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_magacin() {
		return id_magacin;
	}

	public void setId_magacin(Long id_magacin) {
		this.id_magacin = id_magacin;
	}

	public Long getId_artikal() {
		return id_artikal;
	}

	public void setId_artikal(Long id_artikal) {
		this.id_artikal = id_artikal;
	}

	public BigDecimal getStanje() {
		return stanje;
	}

	public void setStanje(BigDecimal stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "SumMagacinArtikal [id=" + id + ", id_magacin=" + id_magacin + ", id_artikal=" + id_artikal + ", stanje="
				+ stanje + "]";
	}
    
    
}
