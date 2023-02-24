package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		//TODO a completer
		int numeroEtal = -1;
//		if (!verifierIdentite(nomVendeur)) {
//			System.out.println("Je suis désolé "+ nomVendeur+ " je vais regarder si je peux vous trouver un étal.");
//		} else {
//			System.out.println("Bonjour "+ nomVendeur+ " je vais regarder si je peux vous trouver un étal.");
//			if (!resteEtals()) {
//				System.out.println("Désole "+ nomVendeur+ " je n'ai plus d'étal qui ne soit pas déjà occupé.");
//		
//			} else {
//				
//			}
//		}
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		//TODO a completer, attention le retour ne dit pas etre false :-)
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
