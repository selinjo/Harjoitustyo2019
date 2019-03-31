package kevat2019.Harjoitustyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PO_Kayttajat") // Nimetään tietokannassa oleva taulu
public class Kayttaja {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "kayttaja_id", nullable = false, updatable = false)
	private Long kayttaja_id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "etunimi", nullable = false)
	private String etunimi;
	
	@Column(name = "sukunimi", nullable = false)
	private String sukunimi;
	
	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	@Column(name = "rooli", nullable = false)
	private String rooli;

	public Kayttaja() {	
	}

	public Kayttaja(String username, String etunimi, String sukunimi, String passwordHash,
			String rooli) {
		super();
		this.username = username;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.passwordHash = passwordHash;
		this.rooli = rooli;
	}

	public Long getKayttaja_id() {
		return kayttaja_id;
	}

	public void setKayttaja_id(Long kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}	
	
}
