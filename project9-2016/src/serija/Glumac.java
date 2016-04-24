package serija;

import java.io.Serializable;

public class Glumac implements Serializable{
	private String imePrezime;
	private String datumRodjenja;
	private String mestoRodjenja;
	
	
	public Glumac(String imePrezime, String datumRodjenja, String mestoRodjenja) {
		super();
		this.imePrezime = imePrezime;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
	}
	public String getImePrezime() {
		return imePrezime;
	}
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getMestoRodjenja() {
		return mestoRodjenja;
	}
	public void setMestoRodjenja(String mestoRodjenja) {
		this.mestoRodjenja = mestoRodjenja;
	}
	
	
	
}
