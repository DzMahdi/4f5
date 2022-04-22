package mon_jeu.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import mon_jeu.frontal.vues.VueProfil;
import mon_jeu.modeles.MonModeleProfil;

public class AfficherProfil {
	
	public static void creerTaches(FrontendTasks tasks) {
		
		tasks.taskGroup("AfficherProfil")
		
			.waitsFor("Initialisation")
			
			.andContains(subTasks ->{
				
				afficherProfil(subTasks);
				
				
			});
		
	}

	private static void afficherProfil(FrontendTasks tasks) {
		tasks.task("afficherProfil")
		
			.waitsFor(modified(MonModeleProfil.class))
		
			.executes(inputs ->{
				
				VueProfil vueProfil = inputs.get(created(VueProfil.class));
				Modified<MonModeleProfil> profil = inputs.get(modified(MonModeleProfil.class));
				
				MonModeleProfil ancienProfil = profil.previousValue();
				MonModeleProfil profilCourant = profil.currentValue();
				
				profilCourant.afficherSur(vueProfil);
				
			});
		

		
	}

}
