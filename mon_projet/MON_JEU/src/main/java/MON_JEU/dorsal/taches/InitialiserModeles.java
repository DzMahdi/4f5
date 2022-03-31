package mon_jeu.dorsal.taches;

import ca.ntro.app.tasks.backend.BackendTasks;
import mon_jeu.modeles.ModeleNomJoueur;
import mon_jeu.modeles.MonModele;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public class InitialiserModeles {
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("InitialiserModeles")
		
		      .contains(subTasks -> {
		    	  
					initialiserModeleNomJoueur(subTasks);

		      });
	}

	private static void initialiserModeleNomJoueur(BackendTasks tasks) {
		tasks.task("initialiserModeleNomJoueur")

		     .waitsFor(model(ModeleNomJoueur.class))
		     
		     .thenExecutes(inputs -> {

		    	 ModeleNomJoueur nomJoueur = inputs.get(model(ModeleNomJoueur.class));

		    	 nomJoueur.initialiser();

		     });
	}

}
