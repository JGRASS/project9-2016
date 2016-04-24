package serija;

import java.io.Serializable;
import java.util.LinkedList;

public class Serija implements Serializable{
	
	private String naziv;
	private String opis;
	public LinkedList<Glumac> postava = new LinkedList<Glumac>();
	private String godina;
	
	public LinkedList<Epizoda> epizode = new LinkedList<Epizoda>();
	
	public Serija(String n, String o, LinkedList<Glumac> p, String g, LinkedList<Epizoda> e) {
		naziv = n;
		opis = o;
		postava = p;
		godina = g;
		epizode = e;
	}

	public void dodajEpizodu(Epizoda e){
		epizode.add(e);
	}
	
	public void dodajEpizodu(String n, String s, String st, String d){
		Epizoda e = new Epizoda(n, s, st, d);
		epizode.add(e);
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public LinkedList<Glumac> getPostava() {
		return postava;
	}

	public void setPostava(LinkedList<Glumac> postava) {
		this.postava = postava;
	}

	public String getGodina() {
		return godina;
	}

	public void setGodina(String godina) {
		this.godina = godina;
	}

	public LinkedList<Epizoda> getEpizode() {
		return epizode;
	}

	public void setEpizode(LinkedList<Epizoda> epizode) {
		this.epizode = epizode;
	}
	
	
}




