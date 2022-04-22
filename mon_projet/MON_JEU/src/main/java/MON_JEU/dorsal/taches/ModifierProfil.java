package mon_jeu.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import mon_jeu.messages.MsgAjouterJoueur;
import mon_jeu.modeles.MonModeleProfil;

public class ModifierProfil {
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierProfil")
			
			.waitsFor("InitialiserModeles")
			
			.andContains(subTasks ->{
				
				ajouterJoueur(subTasks);
			});
		
	}

	private static void ajouterJoueur(BackendTasks tasks) {
		tasks.task("ajouterJoueur")
		
			.waitsFor(message(MsgAjouterJoueur.class))
			
			.thenExecutes(inputs ->{
				
				MsgAjouterJoueur msgAjouterJoueur = inputs.get(message(MsgAjouterJoueur.class));
				MonModeleProfil profil = inputs.get(model(MonModeleProfil.class));
				
				msgAjouterJoueur.ajouterA(profil);
				
			});
		
		
	}
	
	

}
