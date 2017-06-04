package pro17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pro17DSP_Artikelpflege extends JFrame {

	private JPanel contentPane;
	public static pro17DSP_Artikelpflege frame = new pro17DSP_Artikelpflege();
	private JTable table;
	public static TableModel model;
	public static int pos;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pro17DSP_Artikelpflege frame = new pro17DSP_Artikelpflege();
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
	public pro17DSP_Artikelpflege() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				main.Start();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 353, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(pro17PGM_Artikelpflege.data_public, pro17PGM_Artikelpflege.title_public);
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setVisible(true);
		table.setBounds(8, 5, 464, 436);
		table.add(header);
		//scrollPane.add(new JScrollPane(table));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u00C4ndern");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pos = table.getSelectedRow();
				String iden = (String) model.getValueAt(pos, 0);
				pro17PGM_Artikelpflege.editArtikel(iden);	
				}
		});
		btnNewButton.setBounds(373, 14, 165, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNeu = new JButton("Neu");
		btnNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pro17PGM_Artikelpflege.neuerArtikel();
			}
		});
		btnNeu.setBounds(373, 195, 165, 55);
		contentPane.add(btnNeu);
		}
}
