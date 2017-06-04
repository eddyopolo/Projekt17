package pro17;

public class pro17PGM_Warenkorb {
	
	public static Object[][] data_public = new Object[100][3];
	public static Object[] title_public = new Object[3];
	
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
