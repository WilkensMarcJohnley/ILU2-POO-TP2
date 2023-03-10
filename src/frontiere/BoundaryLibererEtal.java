package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui!");
		} else {
			String[] chaine=controlLibererEtal.libererEtal(nomVendeur);
			if (Boolean.parseBoolean(chaine[0])) {
				System.out.println("Vous avez vendu "+chaine[4]+" sur "+ chaine[3]+" "+chaine[2]);
				System.out.println("En revoir "+chaine[1]+",passez une bonne journee.");
			}
		}
	}

}
