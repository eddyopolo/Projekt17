package pro17;

import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class pro17PGM_Artikelpflege {

	public static String KDNR = new String();
	private static String iden_string;
	private static String preis_wrk1;
	private static int preis_wrk2;
	private static int preis_int;
	private static int bmen;
	private static String preis;
	private static String bez;
	private static String iden;
	private static String ID;
	public static DefaultListModel DLM = new DefaultListModel<>();
	public static Object[][] data_public = new Object[100][3];
	public static Object[] title_public = new Object[3];


	public static void editArtikel(String iden) {
		String where = "WHERE IDEN = " + iden + "";
		DBMain.main("read", "artikel", where, "", "", 0, 0);
		iden = DBMain.ArtikelArray[0][0];
		bez = DBMain.ArtikelArray[0][1];
		preis = String.valueOf(DBMain.ArtikelArray[0][2]);
		pro17PGM_neuerArtikel.fillTable(iden, bez, preis, "edit");
		pro17DSP_neuerArtikel.frame.setVisible(true);
	}

	public static void neuerArtikel() {
		pro17PGM_neuerArtikel.fillTable(iden, bez, preis, "neu");
		pro17DSP_neuerArtikel.frame.setVisible(true);
	}
	
	public static void fillTable(Object data[][]) {
		for (int j = 0; j < data.length; j++) {
			data_public[j][0] = data[j][0];
			data_public[j][1] = data[j][1];
			data_public[j][2] = data[j][2];
		}
		title_public = new Object[] { "Artikelnummer", "Bezeichnung", "Preis" };
	}

}