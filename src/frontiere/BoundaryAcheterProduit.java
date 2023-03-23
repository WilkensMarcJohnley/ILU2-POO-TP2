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
					System.out.println((i+1)+"-"+nomVendeur[i]);
					}
				int indice=Clavier.entrerEntier("Chez quel commercant voulez-vous acheter des "+produit);
				String vendeur=nomVendeur[indice-1];
				
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+vendeur);
				
				int nbproduit=Clavier.entrerEntier("Bonjour "+nomAcheteur+"\nCombien de "+produit+" voulez-vous acheter ?");
				
				int prod_acheter=controlAcheterProduit.acheterProduit(vendeur, nbproduit);
				if (prod_acheter==0) {
					System.out.println(nomAcheteur+ " veut acheter "+ nbproduit+ " "+ produit+ ", malheureusement il n’y en a plus !");
				}else if(prod_acheter<nbproduit) {
					System.out.println(nomAcheteur+" veut acheter "+ nbproduit+" "+ produit+ ", malheureusement " + vendeur+ " n’en a plus que 3.\n" +nomAcheteur+" achète tout le stock de "+vendeur+".");
				}else {
					System.out.println(nomAcheteur+" achete "+ prod_acheter+" "+ produit+" a "+vendeur);
				}
				
				
			} else {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			
		}
		
	}
}
