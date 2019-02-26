package kevat2019.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kayttaja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kayttaja_id;
	private String tunnus;
	private String etunimi;
	private String sukunimi;
	private String salasana;
	private Boolean admin;
	
	public Kayttaja() {
		super();
		
	}

	public Kayttaja(Long kayttaja_id, String tunnus, String etunimi, String sukunimi, String salasana, Boolean admin) {
		super();
		this.kayttaja_id = kayttaja_id;
		this.tunnus = tunnus;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.salasana = salasana;
		this.admin = admin;
	}

	public Long getKayttaja_id() {
		return kayttaja_id;
	}

	public void setKayttaja_id(Long kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}

	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Kayttaja [kayttaja_id=" + kayttaja_id + ", tunnus=" + tunnus + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", salasana=" + salasana + ", admin=" + admin + "]";
	}
	
	
}
