package pomocno;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import serija.Epizoda;
import serija.Glumac;
import serija.Serija;
/**
 * Pomocna funkcija koja pravi listu serija i puni ih u binarnu datoteku
 * @author Ðorðe Popoviæ
 * @author Nevena Pešiæ
 *
 */
public class Punjenje {
	/**
	 * Pomocna lista serija
	 */
	public static LinkedList<Serija> serije = new LinkedList<Serija>();
	/**
	 * 
	 * @return Listu epizoda koja se ubacuje u seriju
	 */
	public static LinkedList<Epizoda> napuniLisuEpizoda0() {
		LinkedList<Epizoda> ep = new LinkedList<Epizoda>();
		ep.add(new Epizoda("Pilot", "1x1", "Nije pogledano.", "Jan 8, 2015"));
		ep.add(new Epizoda("The Outspoken King", "1x2", "Nije pogledano.", "Jan 15, 2015"));
		ep.add(new Epizoda("The Devil...", "1x3", "Nije pogledano.", "Jan 29, 2015"));
		return ep;
	}
	/**
	 * 
	 * @return Listu epizoda koja se ubacuje u seriju
	 */
	public static LinkedList<Epizoda> napuniLisuEpizoda1() {
		LinkedList<Epizoda> ep = new LinkedList<Epizoda>();
		ep.add(new Epizoda("Pilot", "1x1", "Nije pogledano.", "Jan 10, 2011"));
		ep.add(new Epizoda("Frank The Plank", "1x2", "Nije pogledano.", "Jan 17, 2011"));
		ep.add(new Epizoda("Aunt Ginger", "1x3", "Nije pogledano.", "Jan 24, 2011"));
		return ep;
	}
	/**
	 * 
	 * @return Listu epizoda koja se ubacuje u seriju
	 */
	public static LinkedList<Epizoda> napuniLisuEpizoda2() {
		LinkedList<Epizoda> ep = new LinkedList<Epizoda>();
		ep.add(new Epizoda("Crybaby Usagi...", "1x1", "Nije pogledano.", "Mar 7, 1992"));
		ep.add(new Epizoda("Punish Them!...", "1x2", "Nije pogledano.", "Mar 14, 1992"));
		ep.add(new Epizoda("Mzsterious Sleeping...", "1x3", "Nije pogledano.", "Mar 21, 1992"));
		return ep;
	}
	/**
	 * 
	 * @return Listu glumaca koja se ubacuje u seriju
	 */
	public static LinkedList<Glumac> napuniListuGlumac0(){
		LinkedList<Glumac> gl=new LinkedList<Glumac>();
		gl.add(new Glumac("Terrence Howard", "Mart 11, 1969", "Chicago, Illinois, USA"));
		gl.add(new Glumac("Taraji P. Henson", "Sept 11, 1970", "Washington, District of Columbia, USA"));
		gl.add(new Glumac("Jussie Smollett", "Jun 21, 1983", "Santa Rosa, California, USA"));
		return gl;
	}
	/**
	 * 
	 * @return Listu glumaca koja se ubacuje u seriju
	 */
	public static LinkedList<Glumac> napuniListuGlumac1(){
		LinkedList<Glumac> gl=new LinkedList<Glumac>();
		gl.add(new Glumac("Emmy Rossum", "Sept 12, 1986", "New York City, New York, USA"));
		gl.add(new Glumac("William H. Macy", "Mart 13, 1950", "Miami, Florida, USA"));
		gl.add(new Glumac("Ethan Cutkosky", "Avg 19, 1999", "St. Charles, Illinois, USA"));
		return gl;
	}
	/**
	 * 
	 * @return Listu glumaca koja se ubacuje u seriju
	 */
	public static LinkedList<Glumac> napuniListuGlumac2(){
		LinkedList<Glumac> gl=new LinkedList<Glumac>();
		gl.add(new Glumac("Susan Roman", "April 17, 1957", "Edmonton, Alberta, Canada"));
		gl.add(new Glumac("Jill Frappier", "Mart 13, 1950", "Edmonton, Alberta, Canada"));
		gl.add(new Glumac("Katie Griffin", "Jan 14, 1973", "Toronto, Ontario, Canada"));
		return gl;
	}

	private static Serija Empire = new Serija("Empire",
			"A hip-hop mogul must choose between\n his three sons who are battling for control over his\n multi-million dollar company, \nwhile his ex-wife schemes to get what's hers.",
			Punjenje.napuniListuGlumac0(), "2015", Punjenje.napuniLisuEpizoda0());
	private static Serija Shameless = new Serija("Shameless",
			"An alcoholic man lives in a perpetual\n stupor while his six children with whom he lives cope\n as best they can.",
			Punjenje.napuniListuGlumac1(), "2011", Punjenje.napuniLisuEpizoda1());
	private static Serija SailorMoon = new Serija("Sailor Moon",
			"The magical action-adventures of a\n teenage girl who learns of her destiny as the legendary\n warrior Sailor Moon and must band\n together with the other Sailor Soldiers\n to defend the Earth and Galaxy.",
			Punjenje.napuniListuGlumac2(), "1992", Punjenje.napuniLisuEpizoda2());
	/**
	 * Dodaje serije u pomocnu listu i ubacuje ih u binarnu datoteku
	 */
	public static void napunISerijalizujSerije() {
		try {
			serije.add(Empire);
			serije.add(Shameless);
			serije.add(SailorMoon);
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(
					"resources\\serije.out",false)));
			out.writeObject(serije);
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
