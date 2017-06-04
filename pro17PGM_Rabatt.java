package pro17;

public class pro17PGM_Rabatt {

	/*
	 * Datensätze aus Artikelstamm und Warenkorb stehen sich gegenüber und
	 * Werte/Merkmale werden verglichen um rabatt/preis je position ermitteln zu
	 * können.
	 */

	/*
	 * was fehlt: 1.1. anfangs warenkorb auslesen mit IDENs aus Warenkorb 1.2.
	 * array dataArtikelstammm füllen (auusgewählte werte -> heißt IDEN, Preis,
	 * Rabattmerkmale reichen eigentlich) 1.3. array dataWarenkob füllen
	 * (ausgewählte werte -> heißt IDEN, Menge reicht eigentlich. 2.1. Am Ende
	 * DB Warenkorb füllen aus array dataWarenkob (alle werte die für Warenkorb
	 * anzeige wichtig sind.
	 */

	private int[][] dataArtikelstamm = new int[100][5];
	private int[][] dataWarenkorb = new int[100][5];
	/*
	 * [][1]==IDEN; [][2]==RKZ; [][3]==RWERT; [][4]==BMEN; [][5]==PREIS;
	 */

	// DBMain.main("read", "warenkorb", "", kdnr, "", 0, 0);

	for(
	int i = 0;a<dataWarenkob.length;i++)
	{
		if (dataArtikelstamm[i][2] != 0) {
			if (dataWarenkorb[i][2] >= dataArtikelstamm[i][4]) {
				int preis = dataArtikelstamm[i][5];
				int bMen = dataWarenkorb[i][4];
				int rWert = dataArtikelstamm[i][3];
				dataWarenkorb[i][5] = preis * (100 - (rWert / 100)) * bMen;
			}
		}

	};
}
