package serija;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 * @author Ðorðe Popoviæ
 * @author Nevena Pešiæ
 *
 */
public class Serija implements Serializable {
	/**
	 * Naziv serije
	 */
	private String naziv;
	/**
	 * Opis serije
	 */
	private String opis;
	/**
	 * Lista glumaca
	 */
	public LinkedList<Glumac> postava = new LinkedList<Glumac>();
	/**
	 * Godina kada je film izasao
	 */
	private String godina;
	/**
	 * Lista epizoda koje su izasle
	 */
	public LinkedList<Epizoda> epizode = new LinkedList<Epizoda>();

	public Serija(String n, String o, LinkedList<Glumac> p, String g, LinkedList<Epizoda> e) {
		naziv = n;
		opis = o;
		postava = p;
		godina = g;
		epizode = e;
	}

	/**
	 * 
	 * @return Naziv serije
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Dodaje naziv serije
	 * 
	 * @param naziv
	 *            -Naziv serije
	 * @throws RuntimeException
	 *             ako je string null
	 */
	public void setNaziv(String naziv) {
		if (naziv == null)
			throw new RuntimeException("Greska! ");
		this.naziv = naziv;
	}

	/**
	 * 
	 * @return Opis serije
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * Dodaje opis serije
	 * 
	 * @param opis
	 *            Opis serije
	 * @throws RuntimeException
	 *             ako je string null
	 */
	public void setOpis(String opis) {
		if (opis == null)
			throw new RuntimeException("Greska! ");
		this.opis = opis;
	}

	/**
	 * 
	 * @return Listu glumaca
	 */
	public LinkedList<Glumac> getPostava() {
		return postava;
	}

	/**
	 * Dodaje listu glumaca
	 * 
	 * @param postava
	 *            Lista glumaca
	 * @throws RuntimeException
	 *             ako je lista null
	 */
	public void setPostava(LinkedList<Glumac> postava) {
		if (postava == null)
			throw new RuntimeException("Greska! ");
		this.postava = postava;
	}

	/**
	 * 
	 * @return Godina kada je film izasao
	 */
	public String getGodina() {
		return godina;
	}

	/**
	 * Dodaje godinu kada je film izasao
	 * 
	 * @param godina
	 *            -Godina kada je film izasao
	 * @throws RuntimeException
	 *             ako je string null
	 */
	public void setGodina(String godina) {
		if (godina == null)
			throw new RuntimeException("Greska! ");
		this.godina = godina;
	}

	/**
	 * 
	 * @return Lista epizoda
	 */
	public LinkedList<Epizoda> getEpizode() {
		return epizode;
	}

	/**
	 * Dodaje listu epizoda
	 * 
	 * @param epizode
	 *            -Lista epizoda
	 * @throws RuntimeException
	 *             ako je lista null
	 */
	public void setEpizode(LinkedList<Epizoda> epizode) {
		if (epizode == null)
			throw new RuntimeException("Greska! ");
		this.epizode = epizode;
	}

}
