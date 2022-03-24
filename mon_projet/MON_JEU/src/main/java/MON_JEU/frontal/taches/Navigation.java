package mon_jeu.frontal.taches;

import mon_jeu.frontal.evenements.EvtAfficherVueMaVue;
import mon_jeu.frontal.evenements.EvtAfficherFileAttente;
import mon_jeu.frontal.vues.VueFileAttente;
import mon_jeu.frontal.vues.VueMaVue;
import mon_jeu.frontal.vues.VueRacine;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;


public class Navigation {
	
	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Navigation")
		
		     .waitsFor("Initialisation")

		     .andContains(subTasks -> {

			     afficherVueMaVue(subTasks);

		         creerVueFileAttente(subTasks);
			     afficherVueFileAttente(subTasks);

		     });
	}

	private static void creerVueFileAttente(FrontendTasks tasks) {

		tasks.task(create(VueFileAttente.class))

		     .waitsFor(viewLoader(VueFileAttente.class))

		     .thenExecutesAndReturnsValue(inputs -> {
		    	 
		    	 ViewLoader<VueFileAttente> viewLoader = inputs.get(viewLoader(VueFileAttente.class));
		    	 
		    	 VueFileAttente vueFileAttente = viewLoader.createView();

		    	 return vueFileAttente;
		     });
	}

	private static void afficherVueFileAttente(FrontendTasks tasks) {

		tasks.task("afficherVueFileAttente")
		
		     .waitsFor(created(VueFileAttente.class))
		
		     .waitsFor(event(EvtAfficherFileAttente.class))

		     .thenExecutes(inputs -> {

		    	 VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
		    	 VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
		    	  
		    	 vueRacine.afficherSousVue(vueFileAttente);
		     });
	}

	private static void afficherVueMaVue(FrontendTasks tasks) {

		tasks.task("afficherVueMaVue")
		
		      .waitsFor(event(EvtAfficherVueMaVue.class))
		      
		      .thenExecutes(inputs -> {
		    	  
		    	  VueRacine vueRacine = inputs.get(created(VueRacine.class));
		    	  VueMaVue vueMaVue = inputs.get(created(VueMaVue.class));
		    	  
		    	  vueRacine.afficherSousVue(vueMaVue);

		      });
	}
}