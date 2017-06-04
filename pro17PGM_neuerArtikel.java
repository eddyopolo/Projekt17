package pro17;

import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class pro17PGM_neuerArtikel {

	public static String KDNR = new String();
	private static String iden_string;
	private static String preis_wrk1;
	private static int preis_wrk2;
	private static int preis_int;
	private static int bmen;
	private static int preis;
	private static String ID;
	private static String actioncode;
	public static DefaultListModel DLM = new DefaultListModel<>();
	public static Object[][] data_public = new Object[100][3];
	public static Object[] title_public = new Object[3];

	public static void write_new(int iden, String bez, int preis) {
		iden_string = String.valueOf(iden);
		DBMain.main("write", "artikel", "", "", iden_string, 0, preis);
	}

	public static void neuerArtikel() {
		pro17DSP_neuerArtikel.frame.setVisible(true);
	}

	public static void fillTable(String iden, String bez, String preis, String action) {
		actioncode = action;
		pro17DSP_neuerArtikel.textField_iden.setText(iden);
		pro17DSP_neuerArtikel.textField_bez.setText(bez);
		pro17DSP_neuerArtikel.textField_preis.setText(preis);
	}

}