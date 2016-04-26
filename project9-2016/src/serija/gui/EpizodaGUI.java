package serija.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import serija.Epizoda;
import serija.Serija;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

/**
 * Prozor koji pokazuje spisak epizoda izabrane serije
 * 
 * @author Ðorðe Popoviæ
 * @author Nevena Pešiæ
 *
 */
public class EpizodaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblEpizode;
	private JList listEpizode;
	/**
	 * Lista epizoda izabrane serije
	 */
	public LinkedList<Epizoda> epizode = new LinkedList<Epizoda>();
	public LinkedList<Serija> serije = new LinkedList<Serija>();
	/**
	 * Broj izabrane serije
	 */
	public int index;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { EpizodaGUI frame = new
	 * EpizodaGUI(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public EpizodaGUI(int i) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\starij_televizor-600x588.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		index = i;
		contentPane.add(getListEpizode(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblEpizode());
		}
		return panel;
	}

	private JLabel getLblEpizode() {
		if (lblEpizode == null) {
			lblEpizode = new JLabel("Epizode:");
		}
		return lblEpizode;
	}

	private JList getListEpizode() {
		if (listEpizode == null) {
			listEpizode = new JList();
			listEpizode.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GUIKontroler.promeniStatusEpizode(serije, index, listEpizode.getSelectedIndex());
				}
			});

			serije = GUIKontroler.ucitajIzFajla();

			listEpizode.setModel(GUIKontroler.napuniModelLista(index));

		}
		return listEpizode;
	}
}
