package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		boolean nomVendeurConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolé "+ nomVendeur+ " mais il faut etre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour "+ nomVendeur+ " je vais regarder si je peux vous trouver un étal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désole "+ nomVendeur+ " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			
				} else {
					installerVendeur(nomVendeur);
				}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		System.out.println("C'est parfait, il me reste un etal pour vous!");
		System.out.println("Il me faudrait quelques renseignements.");
		System.out.println("Quel produit souhaitez-vous vendre?");
		String produit= scan.nextLine();
		int nb_produit=Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numero_etal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nb_produit);
		if (numero_etal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installe a l'etal numero "+ (numero_etal+1));
		}
		
//		boolean entreeCorrecte;
//		try {
//			produit=scan.nextLine();
//			entreeCorrecte=true;
//		} catch (InputMissMatchException e) {
//			// TODO: handle exception
//			System.out.println("Il faut le nom du produit");
//			
//		}
	}
	
}
