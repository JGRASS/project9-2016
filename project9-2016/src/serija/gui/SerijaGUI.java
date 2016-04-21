package serija.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import pomocno.Punjenje;
import serija.Serija;

import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.ScrollPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SerijaGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxNaziviSerija;
	private JPanel panelCenter;
	private JLabel lblNaziv;
	private JLabel lblSlika;
	private JScrollPane scrollPaneOpis;
	private JTextArea textAreaOpis;
	private JLabel lblGodina;
	private JLabel lblPostava;
	private JLabel lblStvarnaPostava;
	private JButton btnEpizode;
	public static LinkedList<Serija> serije = new LinkedList<Serija>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerijaGUI frame = new SerijaGUI();
					frame.setVisible(true);
					Punjenje.napunISerijalizujSerije();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SerijaGUI() {
		setTitle("TvShows");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getComboBoxNaziviSerija(), BorderLayout.NORTH);
		contentPane.add(getPanelCenter(), BorderLayout.CENTER);

	}

	private JComboBox getComboBoxNaziviSerija() {

		if (comboBoxNaziviSerija == null) {
			comboBoxNaziviSerija = new JComboBox();
			
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream("C:\\Users\\djord\\git\\project9-2016\\project9-2016\\resources\\serije.out"));
				try {
					while (true) {
						serije = (LinkedList<Serija>) in.readObject();
					}
				} catch (Exception e) {

				}
				in.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(getContentPane(), e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
				System.out.println(e.getMessage());
				e.printStackTrace(System.out);
			}
			
			model.addElement(serije.get(0).getNaziv());
			model.addElement(serije.get(1).getNaziv());
			model.addElement(serije.get(2).getNaziv());
			
			comboBoxNaziviSerija.setModel(model);
			
			comboBoxNaziviSerija.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switch (comboBoxNaziviSerija.getSelectedIndex()) {
					case 0:
						lblNaziv.setText(serije.get(0).getNaziv());
						lblGodina.setText(serije.get(0).getGodina());
						lblStvarnaPostava.setText(serije.get(0).getPostava());
						ImageIcon image0 = new ImageIcon("resources\\0.jpg");
						lblSlika.setIcon(image0);
						getTextAreaOpis().setText(serije.get(0).getOpis());
					case 1:
						lblNaziv.setText(serije.get(1).getNaziv());
						lblGodina.setText(serije.get(1).getGodina());
						lblStvarnaPostava.setText(serije.get(1).getPostava());
						ImageIcon image1 = new ImageIcon("resources\\1.jpg");
						lblSlika.setIcon(image1);
						getTextAreaOpis().setText(serije.get(1).getOpis());
					case 2:
						lblNaziv.setText(serije.get(2).getNaziv());
						lblGodina.setText(serije.get(2).getGodina());
						lblStvarnaPostava.setText(serije.get(2).getPostava());
						ImageIcon image2 = new ImageIcon("resources\\2.jpg");
						lblSlika.setIcon(image2);
						getTextAreaOpis().setText(serije.get(2).getOpis());
					}
				}
			});
		}
		
		return comboBoxNaziviSerija;
	}

	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(new MigLayout("", "[][][][][][][grow]", "[][][][][][grow]"));
			panelCenter.add(getLblNaziv(), "cell 1 0");
			panelCenter.add(getLblGodina(), "cell 2 0");
			panelCenter.add(getLblPostava(), "cell 3 0");
			panelCenter.add(getLblStvarnaPostava(), "cell 3 1");
			panelCenter.add(getLblSlika(), "cell 0 2");
			panelCenter.add(getBtnEpizode(), "cell 0 3");
			panelCenter.add(getScrollPaneOpis(), "cell 3 4,grow");
		}
		return panelCenter;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}

		return lblNaziv;
	}

	private JLabel getLblSlika() {
		if (lblSlika == null) {
			lblSlika = new JLabel("");
		}
		return lblSlika;
	}

	private JScrollPane getScrollPaneOpis() {
		if (scrollPaneOpis == null) {
			scrollPaneOpis = new JScrollPane();
			scrollPaneOpis.setViewportView(getTextAreaOpis());
		}
		return scrollPaneOpis;
	}

	private JTextArea getTextAreaOpis() {
		if (textAreaOpis == null) {
			textAreaOpis = new JTextArea();
		}
		return textAreaOpis;
	}

	private JLabel getLblGodina() {
		if (lblGodina == null) {
			lblGodina = new JLabel("Godina");
		}
		return lblGodina;
	}

	private JLabel getLblPostava() {
		if (lblPostava == null) {
			lblPostava = new JLabel("Postava:");
		}
		return lblPostava;
	}

	private JLabel getLblStvarnaPostava() {
		if (lblStvarnaPostava == null) {
			lblStvarnaPostava = new JLabel("Stvarna postava...");
		}
		return lblStvarnaPostava;
	}

	private JButton getBtnEpizode() {
		if (btnEpizode == null) {
			btnEpizode = new JButton("Epizode");
		}
		return btnEpizode;
	}
}
