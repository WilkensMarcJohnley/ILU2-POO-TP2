package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		
		if (!controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur)) {
			System.out.println("Il faut etre un habitant du village pour pouvoir acheter dans le marche");
		}else {
			System.out.println("Quel produit voulez-vous acheter?");
			String produit=scan.nextLine();
			String[] nomVendeur=controlAcheterProduit.donnerInfosproduit(produit);
			if (nomVendeur!=null) {
				System.out.println(nomAcheteur+",vous trouverez au marche:");
				for (int i = 0; i < (nomVendeur.length);i++) {
					System.out.println(i+" "+nomVendeur[i]);
					}
				int indice=Clavier.entrerEntier("Chez quel commercant voulez-vous acheter des "+produit);
				String vendeur=nomVendeur[indice-1];
				
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+vendeur);
				
				int nbproduit=Clavier.entrerEntier("Bonjour "+nomAcheteur+" Combien de fleurs voulez-vous acheter ?");
				
			} else {
				System.out.println("Il n'y a aucun vendeur qui propose ce produit");
			}
			
		}
		
	}
}
