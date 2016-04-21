package serija;

public class Epizoda {

	private String naziv;
	private String sxe;
	private String status;
	private String datum;
	
	public Epizoda(String n, String s, String st, String d) {
		naziv = n;
		sxe = s;
		status = st;
		datum = d;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSxe() {
		return sxe;
	}

	public void setSxe(String sxe) {
		this.sxe = sxe;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	public String toString(){
		return naziv + " " + sxe + " " + status + " " + datum;
	}
}
