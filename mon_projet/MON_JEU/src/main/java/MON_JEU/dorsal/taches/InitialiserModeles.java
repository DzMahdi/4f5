package mon_jeu.dorsal.taches;

import ca.ntro.app.tasks.backend.BackendTasks;
import mon_jeu.modeles.MonModele;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public class InitialiserModeles {
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("InitialiserModeles")
		
		      .contains(subTasks -> {
		    	  
					initialiserModeleDessin(subTasks);

		      });
	}

	private static void initialiserModeleDessin(BackendTasks tasks) {
		tasks.task("initialiserModeleDessin")

		     .waitsFor(model(MonModele.class))
		     
		     .thenExecutes(inputs -> {

		    	 MonModele modeleDessin = inputs.get(model(MonModele.class));

		    	 modeleDessin.initialiser();

		     });
	}

}
