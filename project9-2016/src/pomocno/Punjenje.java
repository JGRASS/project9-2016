package pomocno;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import serija.Epizoda;
import serija.Serija;

public class Punjenje {

	public static LinkedList<Serija> serije = new LinkedList<Serija>();

	public static LinkedList<Epizoda> napuniLisuEpizoda0() {
		LinkedList<Epizoda> ep = new LinkedList<Epizoda>();
		ep.add(new Epizoda("Pilot", "1x1", "Nije pogledano.", "Jan 8, 2015"));
		ep.add(new Epizoda("The Outspoken King", "1x2", "Nije pogledano.", "Jan 15, 2015"));
		ep.add(new Epizoda("The Devil...", "1x3", "Nije pogledano.", "Jan 29, 2015"));
		return ep;
	}

	public static LinkedList<Epizoda> napuniLisuEpizoda1() {
		LinkedList<Epizoda> ep = new LinkedList<Epizoda>();
		ep.add(new Epizoda("Pilot", "1x1", "Nije pogledano.", "Jan 10, 2011"));
		ep.add(new Epizoda("Frank The Plank", "1x2", "Nije pogledano.", "Jan 17, 2011"));
		ep.add(new Epizoda("Aunt Ginger", "1x3", "Nije pogledano.", "Jan 24, 2011"));
		return ep;
	}

	public static LinkedList<Epizoda> napuniLisuEpizoda2() {
		LinkedList<Epizoda> ep = new LinkedList<Epizoda>();
		ep.add(new Epizoda("Crybaby Usagi...", "1x1", "Nije pogledano.", "Mar 7, 1992"));
		ep.add(new Epizoda("Punish Them!...", "1x2", "Nije pogledano.", "Mar 14, 1992"));
		ep.add(new Epizoda("Mzsterious Sleeping...", "1x3", "Nije pogledano.", "Mar 21, 1992"));
		return ep;
	}

	private static Serija Empire = new Serija("Empire",
			"A hip-hop mogul must choose between his three sons who are battling for control over his multi-million dollar company, while his ex-wife schemes to get what's hers.",
			"Terrence Howard, Taraji P. Henson, Jussie Smollett", "2015", Punjenje.napuniLisuEpizoda0());
	private static Serija Shameless = new Serija("Shameless",
			"An alcoholic man lives in a perpetual stupor while his six children with whom he lives cope as best they can.",
			"Emmy Rossum, William H. Macy, Ethan Cutkosky", "2011", Punjenje.napuniLisuEpizoda1());
	private static Serija SailorMoon = new Serija("Sailor Moon",
			"The magical action-adventures of a teenage girl who learns of her destiny as the legendary warrior Sailor Moon and must band together with the other Sailor Soldiers to defend the Earth and Galaxy.",
			"Susan Roman, Jill Frappier, Katie Griffin", "1992", Punjenje.napuniLisuEpizoda2());

	public static void napunISerijalizujSerije() {
		try {
			serije.add(Empire);
			serije.add(Shameless);
			serije.add(SailorMoon);
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(
					"resources\\serije.out")));
			out.writeObject(serije);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
