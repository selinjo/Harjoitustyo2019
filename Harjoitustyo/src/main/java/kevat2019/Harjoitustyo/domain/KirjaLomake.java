package kevat2019.Harjoitustyo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class KirjaLomake {
	@Size(min=2, max=50)
	private String nimi="";
	
	@Size(min=2, max=50)
	private String albumi="";
	
	@Size(max=30)
	private String isbn="";
	
	@Min(1)
	@Max(999)
	private int sivumaara;
	
	@Min(1)
	@Max(5)
	private int kunto;
	
	@Min(1900)
	@Max(2020)
	private int vuosi;
	
	private int painos;

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getAlbumi() {
		return albumi;
	}

	public void setAlbumi(String albumi) {
		this.albumi = albumi;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getSivumaara() {
		return sivumaara;
	}

	public void setSivumaara(int sivumaara) {
		this.sivumaara = sivumaara;
	}

	public int getKunto() {
		return kunto;
	}

	public void setKunto(int kunto) {
		this.kunto = kunto;
	}

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}

	public int getPainos() {
		return painos;
	}

	public void setPainos(int painos) {
		this.painos = painos;
	}
	
	
}
