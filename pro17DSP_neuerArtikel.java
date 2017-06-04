package pro17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pro17DSP_neuerArtikel extends JFrame {

	private JPanel contentPane;
	public static pro17DSP_neuerArtikel frame = new pro17DSP_neuerArtikel();
	public static JTextField textField_preis;
	public static JTextField textField_bez;
	public static JTextField textField_iden;
	public static JTextField textField_rabatt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pro17DSP_neuerArtikel frame = new pro17DSP_neuerArtikel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pro17DSP_neuerArtikel() {
		setTitle("Wartung Artikel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer");
		contentPane.add(lblArtikelnummer);
		
		textField_iden = new JTextField();
		contentPane.add(textField_iden);
		textField_iden.setColumns(10);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung");
		contentPane.add(lblBezeichnung);
		
		textField_bez = new JTextField();
		contentPane.add(textField_bez);
		textField_bez.setColumns(10);
		
		JLabel lblPreis = new JLabel("Preis");
		contentPane.add(lblPreis);
		
		textField_preis = new JTextField();
		contentPane.add(textField_preis);
		textField_preis.setColumns(10);
		
		JCheckBox chckbxRabatt = new JCheckBox("Rabatt?");
		contentPane.add(chckbxRabatt);
		
		textField_rabatt = new JTextField();
		contentPane.add(textField_rabatt);
		textField_rabatt.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iden = Integer.valueOf(textField_iden.getText());
				String bez = textField_bez.getText();
				int preis = Integer.valueOf(textField_preis.getText());
				
				pro17PGM_neuerArtikel.write_new(iden, bez, preis);
			}
		});
		contentPane.add(btnOk);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		contentPane.add(btnAbbrechen);
	}
}
