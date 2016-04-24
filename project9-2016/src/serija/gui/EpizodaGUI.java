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

public class EpizodaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblEpizode;
	private JList listEpizode;
	public LinkedList<Epizoda> epizode = new LinkedList<Epizoda>();
	public LinkedList<Serija> serije = new LinkedList<Serija>();
	public int index;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EpizodaGUI frame = new EpizodaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

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
					Serija serija = serije.get(index);
					Epizoda epizoda = epizode.get(listEpizode.getSelectedIndex());
					if (epizoda.getStatus().equals("Pogledano.")) epizoda.setStatus("Nije pogledano.");
					if (epizoda.getStatus().equals("Nije pogledano.")) epizoda.setStatus("Pogledano.");
					epizode.set(listEpizode.getSelectedIndex(), epizoda);
					serije.set(index, serija);
					
					try {
						ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
								"resources\\serije.out"));
						out.writeObject(serije);
						out.close();
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						e1.printStackTrace();
					}
				}
			});

			try {
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("resources\\serije.out")));
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

			DefaultListModel<String> model = new DefaultListModel<String>();
			LinkedList<Epizoda> epizode = serije.get(index).getEpizode();
			System.out.println(index);
			for (int i = 0; i < epizode.size(); i++) {
				model.addElement(epizode.get(i).toString());
			}
			listEpizode.setModel(model);

		}
		return listEpizode;
	}
}
