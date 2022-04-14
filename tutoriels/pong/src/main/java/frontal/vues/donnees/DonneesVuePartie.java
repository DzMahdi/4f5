package frontal.vues.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;
import pong.frontal.vues.VuePartie;
import pong.modeles.monde_pong2d.MondePong2d;

public class DonneesVuePartie implements ViewData {
	
	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDE = 200;
	
	private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	private long imageAfficheesDepuisDernierCalculFps = 0;

	private MondePong2d mondePong2d = new MondePong2d();
	private String fpsCourant = "0";

	public void reagirTempsQuiPasse(double elapsedTime) {
		mondePong2d.onTimePasses(elapsedTime);

	}

	public void afficherSur(VuePartie vuePartie) {
		
		calculerFpsSiNecessaire();

		vuePartie.viderCanvas();
		vuePartie.afficherImageParSeconde("FPS " + fpsCourant);
		vuePartie.afficherPong2d(mondePong2d);
		
		imageAfficheesDepuisDernierCalculFps++;

	}

	private void calculerFpsSiNecessaire() {
		
		long horodatageMaintenant = Ntro.time().nowMilliseconds();
		long millisecondeEcoulee = horodatageMaintenant - horodatageDernierCalculFps;
		
		if(millisecondeEcoulee > CALCULER_FPS_A_CHAQUE_X_MILLISECONDE) {
			calculerFpsMaintenant(millisecondeEcoulee);
			
			imageAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintenant;
			
			
		}
		
		
		
	}

	private void calculerFpsMaintenant(long millisecondeEcoulee) {
		
		double secondesEcoulees = millisecondeEcoulee / 1E3;
		double fps = imageAfficheesDepuisDernierCalculFps / secondesEcoulees;
		fpsCourant = String.valueOf(Math.round(fps));
		
	}

}
