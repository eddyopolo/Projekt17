package pro17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTable;
import java.awt.Window.Type;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class pro17DSP_Artikelauswahl extends JFrame {

	private JPanel contentPane;
	public static pro17DSP_Artikelauswahl frame = new pro17DSP_Artikelauswahl();
	public static int pos;
	public static JTable table;
	public static TableModel model;
	public static JSpinner spinner_bmen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public pro17DSP_Artikelauswahl() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				pro17DSP_Menü.frame.setVisible(true);
			}
		});
		setTitle("Artikel ausw\u00E4hlen");
		setBounds(100, 100, 647, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("In den Warenkorb");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		btnNewButton.setBounds(482, 5, 149, 47);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 462, 436);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(pro17PGM_Artikelauswahl.data_public, pro17PGM_Artikelauswahl.title_public);
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setVisible(true);
		table.setBounds(8, 5, 464, 436);
		table.add(header);
		//scrollPane.add(new JScrollPane(table));
		scrollPane.setViewportView(table);
		
		spinner_bmen = new JSpinner();
		spinner_bmen.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner_bmen.setBounds(538, 60, 47, 20);
		contentPane.add(spinner_bmen);
		
		JLabel lblMenge = new JLabel("Menge");
		lblMenge.setBounds(482, 63, 46, 14);
		contentPane.add(lblMenge);
		
		JButton btnZumWarenkorb = new JButton("Zum Warenkorb");
		btnZumWarenkorb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.go_to_basket(pro17PGM_Artikelauswahl.KDNR);
			}
		});
		btnZumWarenkorb.setBounds(482, 394, 149, 47);
		contentPane.add(btnZumWarenkorb);
		
		}
}
