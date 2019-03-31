package kevat2019.Harjoitustyo.domain;

import javax.validation.constraints.Size;

public class KayttajaLomake {
	@Size(min=4, max=30)
	private String username = "";
	
	@Size(min=2, max=30)
	private String etunimi = "";
	
	@Size(min=2, max=30)
	private String sukunimi = "";
	
	@Size(min=5, max=30)
	private String password = "";
	
	private String rooli = "";

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}
	
}
