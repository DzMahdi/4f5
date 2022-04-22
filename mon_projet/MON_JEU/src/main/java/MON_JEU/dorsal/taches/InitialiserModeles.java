package mon_jeu.dorsal.taches;

import ca.ntro.app.tasks.backend.BackendTasks;
import mon_jeu.modeles.MonModeleProfil;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public class InitialiserModeles {
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("InitialiserModeles")
		
		      .contains(subTasks -> {
		    	  
					initialiserModeleProfil(subTasks);

		      });
	}

	private static void initialiserModeleProfil(BackendTasks tasks) {
		tasks.task("initialiserModeleProfil")

		     .waitsFor(model(MonModeleProfil.class))
		     
		     .thenExecutes(inputs -> {

		    	 MonModeleProfil modeleProfil = inputs.get(model(MonModeleProfil.class));

		    	 modeleProfil.initialiser();

		     });
	}

}
