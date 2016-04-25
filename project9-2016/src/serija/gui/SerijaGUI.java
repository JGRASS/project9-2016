package serija.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import pomocno.Punjenje;
import serija.Glumac;
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
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Glavni prozor aplikacije
 * @author Ðorðe Popoviæ
 * @author Nevena Pešiæ
 *
 */
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
	private JButton btnEpizode;
	/**
	 * Lista serija koje se ucitavaju iz binarne datoteke
	 */
	public LinkedList<Serija> serije = new LinkedList<Serija>();
	/**
	 * broj izabrane serije iz comboBoxa
	 */
	private int index;
	/**
	 * Izabrana serija iz comboBoxa
	 */
	public static Serija serija;
	private JTable table;

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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources\\starij_televizor-600x588.png"));
		setResizable(false);
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
						new FileInputStream("resources\\serije.out"));
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
				public void actionPerformed(ActionEvent e) {
					JComboBox cb = (JComboBox) e.getSource();
					/**
					 * Lista glumaca izabrane serije
					 */
					LinkedList<Glumac> postava=new LinkedList<Glumac>(); 
					
					if (cb.getSelectedIndex() == 0){
						serija=serije.get(0);
						lblNaziv.setText(serije.get(0).getNaziv());
						lblGodina.setText(serije.get(0).getGodina());
						postava=serije.get(0).getPostava();
						for (int i = 0; i < postava.size(); i++) {
							table.setValueAt(postava.get(i).getImePrezime(), i, 0);
						}
						
						ImageIcon image0 = new ImageIcon("resources\\0.jpg");
						lblSlika.setIcon(image0);
						getTextAreaOpis().setText(serije.get(0).getOpis());
					}
					
					if (cb.getSelectedIndex() == 1){
						serija=serije.get(1);
						lblNaziv.setText(serije.get(1).getNaziv());
						lblGodina.setText(serije.get(1).getGodina());
						postava=serije.get(1).getPostava();
						for (int i = 0; i < postava.size(); i++) {
							table.setValueAt(postava.get(i).getImePrezime(), i, 0);
						}
						ImageIcon image1 = new ImageIcon("resources\\1.jpg");
						lblSlika.setIcon(image1);
						getTextAreaOpis().setText(serije.get(1).getOpis());
					}
					
					if (cb.getSelectedIndex() == 2){
						serija=serije.get(2);
						lblNaziv.setText(serije.get(2).getNaziv());
						lblGodina.setText(serije.get(2).getGodina());
						postava=serije.get(2).getPostava();
						for (int i = 0; i < postava.size(); i++) {
							table.setValueAt(postava.get(i).getImePrezime(), i, 0);
						}
						ImageIcon image2 = new ImageIcon("resources\\2.jpg");
						lblSlika.setIcon(image2);
						getTextAreaOpis().setText(serije.get(2).getOpis());
					}
					
					index = comboBoxNaziviSerija.getSelectedIndex();
				}
			});
		}
		
		return comboBoxNaziviSerija;
	}

	private JPanel getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JPanel();
			panelCenter.setLayout(null);
			panelCenter.add(getLblNaziv());
			panelCenter.add(getLblGodina());
			panelCenter.add(getLblPostava());
			panelCenter.add(getLblSlika());
			panelCenter.add(getBtnEpizode());
			panelCenter.add(getScrollPaneOpis());
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int glumac=table.getSelectedRow();
					if(index==0 || index==1 || index==2){
						GlumacGUI glumacProzor = new GlumacGUI(glumac);
					glumacProzor.setVisible(true);
					}
				}
				});
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null},
					{null},
					{null},
				},
				new String[] {
					"New column"
				}
			));
			table.setShowGrid(false);
			table.setBounds(274, 90, 130, 47);
			panelCenter.add(table);
		}
		return panelCenter;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNaziv.setBounds(147, 11, 221, 33);
		}

		return lblNaziv;
	}

	private JLabel getLblSlika() {
		if (lblSlika == null) {
			lblSlika = new JLabel("");
			lblSlika.setPreferredSize(new Dimension(100, 200));
			lblSlika.setBounds(7, 11, 130, 175);
		}
		return lblSlika;
	}

	private JScrollPane getScrollPaneOpis() {
		if (scrollPaneOpis == null) {
			scrollPaneOpis = new JScrollPane();
			scrollPaneOpis.setBounds(147, 148, 277, 72);
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
			lblGodina.setBounds(147, 65, 171, 14);
		}
		return lblGodina;
	}

	private JLabel getLblPostava() {
		if (lblPostava == null) {
			lblPostava = new JLabel("Postava:");
			lblPostava.setBounds(147, 90, 106, 14);
		}
		return lblPostava;
	}

	private JButton getBtnEpizode() {
		if (btnEpizode == null) {
			btnEpizode = new JButton("Epizode");
			btnEpizode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EpizodaGUI epizodeProzor = new EpizodaGUI(index);
					epizodeProzor.setVisible(true);
				}
			});
			btnEpizode.setBounds(10, 197, 127, 23);
		}
		return btnEpizode;
	}
}
