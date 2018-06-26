package com.hellokoding.auth.model;

import java.math.BigDecimal;

public class SpecifikacijaKartica {

    private Long idArtikal;
    private Long idMagacin;
    private Long idPartner;
 
    private String ArtikalCode;
    private String MagacinCode;
    private String PartnerCode;
    
    private String ArtikalNaziv;
    private String MagacinNaziv;
    private String PartnerNaziv;
    
    private BigDecimal ulaz;
    private BigDecimal izlaz;
    private BigDecimal stanje;
    private BigDecimal duguje;
    private BigDecimal potrazuje;  
    private BigDecimal vrednost;
    
	public SpecifikacijaKartica() {
		super();
	}

	public SpecifikacijaKartica(Long idArtikal, Long idMagacin, Long idPartner) {
		super();
		this.idArtikal = idArtikal;
		this.idMagacin = idMagacin;
		this.idPartner = idPartner;
	}

	public SpecifikacijaKartica(Long idArtikal, Long idMagacin, Long idPartner, 
			String artikalCode, String magacinCode,
			String partnerCode, String artikalNaziv, String magacinNaziv, String partnerNaziv, BigDecimal ulaz,
			BigDecimal izlaz, BigDecimal stanje, BigDecimal duguje, BigDecimal potrazuje, BigDecimal vrednost) {
		super();
		this.idArtikal = idArtikal;
		this.idMagacin = idMagacin;
		this.idPartner = idPartner;
		ArtikalCode = artikalCode;
		MagacinCode = magacinCode;
		PartnerCode = partnerCode;
		ArtikalNaziv = artikalNaziv;
		MagacinNaziv = magacinNaziv;
		PartnerNaziv = partnerNaziv;
		this.ulaz = ulaz;
		this.izlaz = izlaz;
		this.stanje = stanje;
		this.duguje = duguje;
		this.potrazuje = potrazuje;
		this.vrednost = vrednost;
	}

	public Long getIdArtikal() {
		return idArtikal;
	}

	public void setIdArtikal(Long idArtikal) {
		this.idArtikal = idArtikal;
	}

	public Long getIdMagacin() {
		return idMagacin;
	}

	public void setIdMagacin(Long idMagacin) {
		this.idMagacin = idMagacin;
	}

	public Long getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(Long idPartner) {
		this.idPartner = idPartner;
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

	public BigDecimal getStanje() {
		return stanje;
	}

	public void setStanje(BigDecimal stanje) {
		this.stanje = stanje;
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

	public BigDecimal getVrednost() {
		return vrednost;
	}

	public void setVrednost(BigDecimal vrednost) {
		this.vrednost = vrednost;
	}

	public String getArtikalCode() {
		return ArtikalCode;
	}

	public void setArtikalCode(String artikalCode) {
		ArtikalCode = artikalCode;
	}

	public String getMagacinCode() {
		return MagacinCode;
	}

	public void setMagacinCode(String magacinCode) {
		MagacinCode = magacinCode;
	}

	public String getPartnerCode() {
		return PartnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		PartnerCode = partnerCode;
	}

	public String getArtikalNaziv() {
		return ArtikalNaziv;
	}

	public void setArtikalNaziv(String artikalNaziv) {
		ArtikalNaziv = artikalNaziv;
	}

	public String getMagacinNaziv() {
		return MagacinNaziv;
	}

	public void setMagacinNaziv(String magacinNaziv) {
		MagacinNaziv = magacinNaziv;
	}

	public String getPartnerNaziv() {
		return PartnerNaziv;
	}

	public void setPartnerNaziv(String partnerNaziv) {
		PartnerNaziv = partnerNaziv;
	}
  
	
    
}
