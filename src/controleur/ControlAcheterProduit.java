package controleur;



import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean verifierIdentiteAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] trouverVendeurProduit(String nomProduit) {
		Gaulois[] vendeurs= village.rechercherVendeursProduit(nomProduit);
		String[] nomVendeurs= new String[vendeurs.length];
		for(int i=0; i<vendeurs.length;i++) {
			nomVendeurs[i]=vendeurs[i].getNom();
		}
		return nomVendeurs;
	}
	
	public Etal[] trouverEtalsproduit(String[] nomVendeurs) {
		Etal[] etals= new Etal[nomVendeurs.length];
		for(int i=0; i<nomVendeurs.length;i++) {
			etals[i]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeurs[i]);
		}
		
		return etals;
	}
	
	public String[] donnerInfosproduit(String nomProduit) {
		String[] nomVendeurs= trouverVendeurProduit(nomProduit);
		Etal[] etals=trouverEtalsproduit(nomVendeurs);
		int tailleTableau = etals.length;
		String[] donnees = new String[tailleTableau];
		for (int i = 0; i < etals.length; i++) {
			Etal etal = etals[i];
			Gaulois vendeur = etal.getVendeur();
			donnees[i] = vendeur.getNom();
			
		}
		return donnees;
	}
	
	
	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantite);
	}
	
	
}
