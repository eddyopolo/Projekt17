package pro17;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class pro17DSP_Warenkorb extends JFrame {

	private JPanel contentPane;
	public static pro17DSP_Warenkorb frame = new pro17DSP_Warenkorb();
	private int pos;
	private JTable table;
	private TableModel model;
	private JTextField txtRabattcode;
	private JSpinner spinner_bmen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pro17DSP_Warenkorb frame = new pro17DSP_Warenkorb();
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
	public pro17DSP_Warenkorb() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 462, 436);
		contentPane.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel(pro17PGM_Warenkorb.data_public, pro17PGM_Warenkorb.title_public);
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setVisible(true);
		table.setBounds(8, 5, 464, 436);
		table.add(header);
		scrollPane.setViewportView(table);

		// Bestellmenge ausgew‰hlter Posistion ‰ndern
		JLabel lblMenge = new JLabel("Menge");
		lblMenge.setBounds(484, 5, 133, 22);
		contentPane.add(lblMenge);

		JButton btnMengeAendern = new JButton("Menge \u00E4ndern");
		btnMengeAendern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object iden = 0;
				int bmen = 0;
				Object preis = (int) 0;
				pos = table.getSelectedRow();
				iden = model.getValueAt(pos, 0);
				preis = model.getValueAt(pos, 2);
				bmen = (int) spinner_bmen.getValue();
				pro17PGM_Artikelauswahl.to_basket(iden, bmen, preis);
			}
		});
		btnMengeAendern.setBounds(484, 62, 133, 25);
		contentPane.add(btnMengeAendern);

		JSpinner spinner_bmen = new JSpinner();
		spinner_bmen.setBounds(484, 27, 133, 22);
		spinner_bmen.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		contentPane.add(spinner_bmen);

		// Rabattcode Pruefen.
		txtRabattcode = new JTextField();
		txtRabattcode.setBounds(484, 147, 133, 22);
		contentPane.add(txtRabattcode);
		txtRabattcode.setColumns(10);

		JButton btnRabattcodePruefen = new JButton("Rabattcode pr\u00FCfen");
		btnRabattcodePruefen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// read artikelstammm mit iden = txtRabattcode
				main.check_discount();
				// write warenkorb wenn erfolgreich gelesen
				Object iden = txtRabattcode;
				int bmen = 1;
				Object preis = (int) 0;
				pro17PGM_Artikelauswahl.to_basket(iden, bmen, preis);
			}
		});
		btnRabattcodePruefen.setBounds(484, 182, 133, 25);
		contentPane.add(btnRabattcodePruefen);

		JLabel lblRabattcode = new JLabel("Rabattcode eingeben");
		lblRabattcode.setBounds(484, 125, 133, 22);
		contentPane.add(lblRabattcode);

		// Rechnungsbetrag abbilden
		JLabel lblGesamtpreis = new JLabel("Gesamtpreis");
		lblGesamtpreis.setBounds(484, 338, 133, 22);
		contentPane.add(lblGesamtpreis);

		String summe = null;
		JLabel lblSumme = new JLabel(summe);
		lblSumme.setBackground(Color.WHITE);
		lblSumme.setBounds(484, 363, 133, 22);
		contentPane.add(lblSumme);
		
		// Kauf Abschlieﬂen.
		JButton btnKaufAbschliessen = new JButton("Kauf abschlie\u00DFen");
		btnKaufAbschliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKaufAbschliessen.setBounds(484, 398, 133, 25);
		contentPane.add(btnKaufAbschliessen);
	}
}
