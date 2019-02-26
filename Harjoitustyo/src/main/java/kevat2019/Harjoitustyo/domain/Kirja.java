package kevat2019.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PO_Kirjat") // Nimetään tietokannassa oleva taulu
public class Kirja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kirja_id;
	private String nimi;
	private String albumi;
	private String isbn;
	private int sivumaara;
	private int kunto;
	private int vuosi;
	private int painos;
	
	public Kirja() {
			
	}

	public Kirja(String nimi, String albumi, String isbn, int sivumaara, int kunto, int vuosi,
		int painos) {
		super();
		this.nimi = nimi;
		this.albumi = albumi;
		this.isbn = isbn;
		this.sivumaara = sivumaara;
		this.kunto = kunto;
		this.vuosi = vuosi;
		this.painos = painos;
	}

	public Long getKirja_id() {
		return kirja_id;
	}

	public void setKirja_id(Long kirja_id) {
		this.kirja_id = kirja_id;
	}

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

	@Override
	public String toString() {
		return "Kirja [kirja_id=" + kirja_id + ", nimi=" + nimi + ", albumi=" + albumi + ", isbn=" + isbn
				+ ", sivumaara=" + sivumaara + ", kunto=" + kunto + ", vuosi=" + vuosi + ", painos=" + painos + "]";
	}

	
}
