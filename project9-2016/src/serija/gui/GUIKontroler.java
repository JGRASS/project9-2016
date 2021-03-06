package serija.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import pomocno.Punjenje;
import serija.Epizoda;
import serija.Glumac;
import serija.Serija;
/**
 * 
 * @author �or�e Popovi�
 * @author Nevena Pe�i�
 *
 */
public class GUIKontroler {

	private static SerijaGUI glavniProzor;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		Punjenje.napunISerijalizujSerije();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new SerijaGUI();
					glavniProzor.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/**
 * Ucitava iz binarne datoteke listu serija
 * @return Listu serija iz fajla
 */
	public static LinkedList<Serija> ucitajIzFajla() {
		LinkedList<Serija> serije = new LinkedList<Serija>();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("resources\\serije.out"));
			try {
				while (true) {
					serije = (LinkedList<Serija>) in.readObject();
				}
			} catch (Exception e) {

			}
			in.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor, e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		}

		return serije;
	}
/**
 * Prikazuje detalje o izabranom glumcu
 * @param table -Tabela koja se koristi
 * @param index -Selektovan glumac
 */
	public static void prikaziProzorGlumac(JTable table, int index) {
		int glumac = table.getSelectedRow();
		if (index == 0 || index == 1 || index == 2) {
			GlumacGUI glumacProzor = new GlumacGUI(glumac);
			glumacProzor.setVisible(true);
		}
	}
/**
 * Prikazuje spisak epizoda, sa detaljima, izabrane serije
 * @param index -Selektovana serija
 */
	public static void PrikaziProzorEpizode(int index) {
		EpizodaGUI epizodeProzor = new EpizodaGUI(index);
		epizodeProzor.setVisible(true);
	}
/**
 * Pravi comboBox
 * @return Combobox koji odgovara aplikaciji
 */
	public static DefaultComboBoxModel<String> napuniCBModel() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		LinkedList<Serija> serije = GUIKontroler.ucitajIzFajla();

		model.addElement(serije.get(0).getNaziv());
		model.addElement(serije.get(1).getNaziv());
		model.addElement(serije.get(2).getNaziv());
		return model;
	}
/**
 * Upisuje listu serija u binarnu datoteku
 * @param serije -Lista serija koje se upisuju
 */
	public static void upisiUFajl(LinkedList<Serija> serije) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources\\serije.out", false));
			out.writeObject(serije);
			out.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
	}
/**
 * Menja status epizode u "pregledano" kada se klikne na nju i obrnuto
 * @param serije -Lista serija
 * @param index -Izabrana serija
 * @param listIndex -Izabrana epizoda
 */
	public static void promeniStatusEpizode(LinkedList<Serija> serije, int index, int listIndex) {
		Serija serija = serije.get(index);
		LinkedList<Epizoda> epizode = serija.getEpizode();
		Epizoda epizoda = epizode.get(listIndex);
		if (epizoda.getStatus().equals("Pogledano."))
			epizoda.setStatus("Nije pogledano.");
		if (epizoda.getStatus().equals("Nije pogledano."))
			epizoda.setStatus("Pogledano.");
		epizode.set(listIndex, epizoda);
		serije.set(index, serija);

		GUIKontroler.upisiUFajl(serije);
	}
/**
 * Pravi listu
 * @param index -Izabrana lista
 * @return Listu koja odgovara aplikaciji
 */
	public static DefaultListModel<String> napuniModelLista(int index) {
		LinkedList<Serija> serije = GUIKontroler.ucitajIzFajla();

		DefaultListModel<String> model = new DefaultListModel<String>();
		LinkedList<Epizoda> epizode = serije.get(index).getEpizode();
		for (int i = 0; i < epizode.size(); i++) {
			model.addElement(epizode.get(i).toString());
		}
		return model;
	}
}
