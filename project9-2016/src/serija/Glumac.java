package serija;

import java.io.Serializable;
/**
 * 
 * @author Ðorðe Popoviæ
 * @author Nevena Pešiæ
 *
 */
public class Glumac implements Serializable{
	/**
	 * Ime i prezime glumca
	 */
	private String imePrezime;
	/**
	 * Datum rodjenja glumca
	 */
	private String datumRodjenja;
	/**
	 * Mesto rodjenja glumca
	 */
	private String mestoRodjenja;
	
	
	public Glumac(String imePrezime, String datumRodjenja, String mestoRodjenja) {
		super();
		this.imePrezime = imePrezime;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
	}
	/**
	 * 
	 * @return Ime i prezime glumca
	 */
	public String getImePrezime() {
		return imePrezime;
	}
	/**
	 * Dodaje ime i prezime glumca
	 * @param imePrezime -Ime i prezime glumca
	 * @throws RuntimeException ako je string null
	 */
	public void setImePrezime(String imePrezime) {
		if(imePrezime==null)
			throw new RuntimeException("Greska! ");
		this.imePrezime = imePrezime;
	}
	/**
	 * 
	 * @return Datum rodjenja glumca
	 */
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	/**
	 * Dodaje datum rodjenja glumca
	 * @param datumRodjenja Datum rodjenja glumca
	 * @throws RuntimeException ako je string null
	 */
	public void setDatumRodjenja(String datumRodjenja) {
		if(datumRodjenja==null)
			throw new RuntimeException("Greska! ");
		this.datumRodjenja = datumRodjenja;
	}
	/**
	 * 
	 * @return Mesto rodjenja glumca
	 */
	public String getMestoRodjenja() {
		return mestoRodjenja;
	}
	/**
	 * Dodaje mesto rodjenja glumca
	 * @param mestoRodjenja Mesto rodjenja glumca
	 * @throws RuntimeException ako je string null
	 */
	public void setMestoRodjenja(String mestoRodjenja) {
		if(mestoRodjenja==null)
			throw new RuntimeException("Greska! ");
		this.mestoRodjenja = mestoRodjenja;
	}
}
