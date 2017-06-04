package pro17;

import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class pro17PGM_Artikelauswahl {

	public static String KDNR = new String();
	private static String iden_string;
	private static String preis_wrk1;
	private static int preis_wrk2;
	private static int preis_int;
	private static int bmen;
	private static int preis;
	private static String ID;
	public static DefaultListModel DLM = new DefaultListModel<>();
	public static Object[][] data_public = new Object[100][3];
	public static Object[] title_public = new Object[3];

	public static void to_basket(Object iden, int bmen, Object preis) {
		iden_string = (String) iden;
		preis_wrk1 = (String) preis;
		preis_wrk2 = Integer.valueOf(preis_wrk1);
		preis_int = (preis_wrk2 * bmen);
		System.out.println(iden_string);
		if(KDNR.equalsIgnoreCase("")) {
			nextID();
		}
		DBMain.main("write", "warenkorb", "", KDNR, iden_string, bmen, preis_int);
	}

	private static void nextID() {
		ID = String.valueOf((int) (Math.random() * 999 + 1));
		String allowedChars = "0123456789";
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			String randomString = generateRandomString(allowedChars, random);
			KDNR = randomString;
		}
	}

	private static String generateRandomString(String allowedChars, Random random) {
		int max = allowedChars.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			int value = random.nextInt(max);
			buffer.append(allowedChars.charAt(value));
		}
		return buffer.toString();
	}

	public static void fillTable(Object data[][]) {
		for (int j = 0; j < data.length; j++) {
			data_public[j][0] = data[j][0];
			data_public[j][1] = data[j][1];
			data_public[j][2] = data[j][2];
		}
		title_public = new Object[]{
				"Artikelnummer", "Bezeichnung", "Preis"
		};
	}

}