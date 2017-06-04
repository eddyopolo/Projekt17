package pro17;

public class pro17PGM_Rabatt {

	/*
	 * Datens�tze aus Artikelstamm und Warenkorb stehen sich gegen�ber und
	 * Werte/Merkmale werden verglichen um rabatt/preis je position ermitteln zu
	 * k�nnen.
	 */

	/*
	 * was fehlt: 1.1. anfangs warenkorb auslesen mit IDENs aus Warenkorb 1.2.
	 * array dataArtikelstammm f�llen (auusgew�hlte werte -> hei�t IDEN, Preis,
	 * Rabattmerkmale reichen eigentlich) 1.3. array dataWarenkob f�llen
	 * (ausgew�hlte werte -> hei�t IDEN, Menge reicht eigentlich. 2.1. Am Ende
	 * DB Warenkorb f�llen aus array dataWarenkob (alle werte die f�r Warenkorb
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
