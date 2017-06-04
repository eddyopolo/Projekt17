package pro17;

public class main {

	public static void main(String[] args) {
		
		Start();
	}
	
	public static void Start() {
		pro17DSP_Menü.frame.setVisible(true);
	}
	
	public static void go_to_basket(String kdnr) {
		DBMain.main("read", "warenkorb", "", kdnr, "", 0, 0);
		pro17PGM_Artikelauswahl.fillTable(DBMain.ArtikelArray);
		pro17DSP_Artikelauswahl.frame.setVisible(true);
		pro17DSP_Warenkorb.frame.setVisible(true);
	}
	
	public static void go_shopping() {
		//1. Anzeige Artikel um einzukaufen
		DBMain.main("read", "artikel", "", "", "", 0, 0);
		pro17PGM_Artikelauswahl.fillTable(DBMain.ArtikelArray);
		pro17DSP_Artikelauswahl.frame.setVisible(true);
	}
	
	public static void maintain_item() {
		DBMain.main("read", "artikel", "", "", "", 0, 0);
		pro17PGM_Artikelpflege.fillTable(DBMain.ArtikelArray);
		pro17DSP_Artikelpflege.frame.setVisible(true);
	}

	public static void check_discount() {
		//Eingegebenen Rabattcode prüfen
		DBMain.main("read", "artikel", "", "", "", 0, 0);
		pro17PGM_Warenkorb.fillTable(DBMain.ArtikelArray);
	}

}