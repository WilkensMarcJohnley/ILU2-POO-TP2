package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Gaulois abraracourcix;
	private Chef chef;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		chef= new Chef("Obelix",15,village);
		village.setChef(chef);
		abraracourcix = new Gaulois("Abraracourcix", 10);
		village.ajouterHabitant(abraracourcix);
	}
	
	@Test
	public void testControlVerifierIdentite() {
		ControlVerifierIdentite controleur= new ControlVerifierIdentite(village);
		assertNotNull(controleur, "controleur ne renvoie pas vide");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controleur= new ControlVerifierIdentite(village);
		assertTrue(controleur.verifierIdentite(abraracourcix.getNom()));
		assertFalse(controleur.verifierIdentite("Bonemine"));
		assertTrue(controleur.verifierIdentite("Abraracourcix"));
		assertTrue(controleur.verifierIdentite("Obelix"));
	}

}
