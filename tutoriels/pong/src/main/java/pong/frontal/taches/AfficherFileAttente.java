package pong.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.fragments.FragmentPartieEnCours;
import pong.frontal.vues.fragments.FragmentRendezVous;
import pong.modeles.ModeleFileAttente;

public class AfficherFileAttente {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("AfficherFileAttente")

				.waitsFor("Initialisation")

				.andContains(subTasks -> {

					afficherFileAttente(subTasks);

				});

	}

	private static void afficherFileAttente(FrontendTasks tasks) {
		
		tasks.task("afficherFileAttente")
		
			.waitsFor(modified(ModeleFileAttente.class))
			
			.waitsFor(viewLoader(FragmentRendezVous.class))
			
			.waitsFor(viewLoader(FragmentPartieEnCours.class))
			
			.executes(inputs ->{
				
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				Modified<ModeleFileAttente> fileAttente = inputs.get(modified(ModeleFileAttente.class));
				
				ViewLoader<FragmentRendezVous> viewLoaderRendezVous = inputs.get(viewLoader(FragmentRendezVous.class));
				ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours = inputs.get(viewLoader(FragmentPartieEnCours.class));
				
				ModeleFileAttente ancienneFile = fileAttente.previousValue();
				ModeleFileAttente fileCourante = fileAttente.currentValue();
				
				fileAttente.currentValue().afficherSur(vueFileAttente, 
													   viewLoaderRendezVous, 
													   viewLoaderPartieEnCours);
				
			});
		
	}

}
