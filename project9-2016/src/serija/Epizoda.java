package serija;

import java.io.Serializable;
/**
 * 
 * @author Ðorðe Popoviæ
 * @author Nevena Pešiæ
 *
 */
public class Epizoda implements Serializable{
	/**
	 * Naziv epizode
	 */
	private String naziv;
	/**
	 * Broj sezone i epizode
	 */
	private String sxe;
	/**
	 * Da li je pregledana
	 */
	private String status;
	/**
	 * Datum kada je izasla epizoda
	 */
	private String datum;
	
	public Epizoda(String n, String s, String st, String d) {
		naziv = n;
		sxe = s;
		status = st;
		datum = d;
	}
	/**
	 * 
	 * @return Naziv epizode
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Dodaje naziv epizode
	 * @param naziv -Naziv epizode
	 * @throws RuntimeException ako je string null
	 */
	public void setNaziv(String naziv) {
		if(naziv==null)
			throw new RuntimeException("Greska! ");
		this.naziv = naziv;
	}
	/**
	 * 
	 * @return Broj sezone i epizode
	 */
	public String getSxe() {
		return sxe;
	}
	/**
	 * Dodaje broj sezone i epizode
	 * @param sxe -Broj sezone i epizode
	 * @throws RuntimeException ako je string null
	 */
	public void setSxe(String sxe) {
		if(sxe==null)
			throw new RuntimeException("Greska! ");
		this.sxe = sxe;
	}
	/**
	 * 
	 * @return Da li je pregledana 
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Dodaje status da li je epizoda pregledana
	 * @param status -Da li je epizoda pregledana
	 * @throws RuntimeException ako je string null
	 */
	public void setStatus(String status) {
		if(status==null)
			throw new RuntimeException("Greska! ");
		this.status = status;
	}
	/**
	 * 
	 * @return kada je epizoda izasla
	 */
	public String getDatum() {
		return datum;
	}
	/**
	 * Dodaje datum kada je epizoda izasla
	 * @param datum -Kada je epizoda izasla
	 * @throws RuntimeException ako je string null
	 */
	public void setDatum(String datum) {
		if(datum==null)
			throw new RuntimeException("Greska! ");
		this.datum = datum;
	}
	
	public String toString(){
		return naziv + " " + sxe + " " + status + " " + datum;
	}
}
