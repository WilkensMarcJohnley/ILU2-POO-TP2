package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois obelix;
	private Etal etal;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		obelix= new Gaulois("Obelix", 15);
		village.ajouterHabitant(obelix);
		int indice= village.installerVendeur(obelix, "poisson", 2);
		etal= new Etal();
		etal.occuperEtal(obelix, "poisson", 2);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controleur= new ControlTrouverEtalVendeur(village);
		assertNotNull(controleur, "controleur ne renvoie pas vide");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controleur= new ControlTrouverEtalVendeur(village);
		assertEquals(etal.getVendeur(), controleur.trouverEtalVendeur("Obelix").getVendeur());
		
	}

}
