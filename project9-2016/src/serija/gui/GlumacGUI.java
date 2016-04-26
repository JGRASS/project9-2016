package serija.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import serija.Glumac;
import serija.Serija;

import javax.swing.JLabel;

/**
 * Prozor koji pokazujedetalje izabranog glumca
 * 
 * @author Ðorðe Popoviæ
 * @author Nevena Pešiæ
 *
 */
public class GlumacGUI extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { GlumacGUI frame = new GlumacGUI();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public GlumacGUI(int glumac) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\starij_televizor-600x588.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblImePrezime = new JLabel("");
		lblImePrezime.setBounds(171, 23, 169, 32);
		contentPane.add(lblImePrezime);

		JLabel lblSlika = new JLabel("");
		lblSlika.setBounds(10, 36, 134, 199);
		contentPane.add(lblSlika);

		JLabel lblDatumRodjenja11 = new JLabel("Datum rodjenja: ");
		lblDatumRodjenja11.setBounds(171, 102, 113, 26);
		contentPane.add(lblDatumRodjenja11);

		JLabel lblMestoRodjenja11 = new JLabel("Mesto rodjenja:");
		lblMestoRodjenja11.setBounds(171, 184, 113, 26);
		contentPane.add(lblMestoRodjenja11);

		JLabel lblDatumRodjenja = new JLabel("");
		lblDatumRodjenja.setBounds(294, 108, 91, 14);
		contentPane.add(lblDatumRodjenja);

		JLabel lblMestoRodjenja = new JLabel("");
		lblMestoRodjenja.setBounds(294, 190, 91, 14);
		contentPane.add(lblMestoRodjenja);

		Serija izabranaSerija = SerijaGUI.serija;
		lblImePrezime.setText(izabranaSerija.getPostava().get(glumac).getImePrezime());
		lblDatumRodjenja.setText(izabranaSerija.getPostava().get(glumac).getDatumRodjenja());
		lblMestoRodjenja.setText(izabranaSerija.getPostava().get(glumac).getMestoRodjenja());

		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Terrence Howard")) {
			ImageIcon image1 = new ImageIcon("resources\\terrenceHoward.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Taraji P. Henson")) {
			ImageIcon image1 = new ImageIcon("resources\\tarajiPHenson.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Jussie Smollett")) {
			ImageIcon image1 = new ImageIcon("resources\\jussieSmollett.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Emmy Rossum")) {
			ImageIcon image1 = new ImageIcon("resources\\emmyRossum.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("William H. Macy")) {
			ImageIcon image1 = new ImageIcon("resources\\williamHMacy.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Ethan Cutkosky")) {
			ImageIcon image1 = new ImageIcon("resources\\ethanCutkosky.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Susan Roman")) {
			ImageIcon image1 = new ImageIcon("resources\\susanRoman.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Jill Frappier")) {
			ImageIcon image1 = new ImageIcon("resources\\jillFrappier.jpg");
			lblSlika.setIcon(image1);
			return;
		}
		if (izabranaSerija.getPostava().get(glumac).getImePrezime().equals("Katie Griffin")) {
			ImageIcon image1 = new ImageIcon("resources\\katieGriffin.jpg");
			lblSlika.setIcon(image1);
			return;
		}
	}
}
