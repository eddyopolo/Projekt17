package pro17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pro17DSP_Menü extends JFrame {

	private JPanel contentPane;
	public static pro17DSP_Menü frame = new pro17DSP_Menü();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pro17DSP_Menü frame = new pro17DSP_Menü();
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
	public pro17DSP_Menü() {
		setTitle("Hauptmen\u00FC");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 94);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEinkaufen = new JButton("Einkaufen");
		btnEinkaufen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.go_shopping();
			}
		});
		btnEinkaufen.setBounds(10, 11, 119, 43);
		contentPane.add(btnEinkaufen);
		
		JButton button = new JButton("Artikelpflege");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.maintain_item();
			}
		});
		button.setBounds(139, 11, 119, 43);
		contentPane.add(button);
	}

}
