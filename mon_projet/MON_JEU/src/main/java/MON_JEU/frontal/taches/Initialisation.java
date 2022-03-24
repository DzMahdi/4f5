package mon_jeu.frontal.taches;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import mon_jeu.frontal.vues.VueMaVue;
import mon_jeu.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;

public class Initialisation {
	
	public static void creerTaches(FrontendTasks tasks) {
		
		tasks.taskGroup("Initialisation")

		     .contains(subTasks -> {

				afficherFenetre(subTasks);
		    	 
				creerVueRacine(subTasks);
				installerVueRacine(subTasks);

				creerVueMaVue(subTasks);
				installerVueMaVue(subTasks);

		     });
	}

	private static void creerVueRacine(FrontendTasks tasks) {

		tasks.task(create(VueRacine.class))

		     .waitsFor(viewLoader(VueRacine.class))
		     
		     .thenExecutesAndReturnsValue(inputs -> {

		    	 ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));
		    	 
		    	 VueRacine vueRacine = viewLoader.createView();
		    	 
		    	 return vueRacine;
		     });
	}

	private static void installerVueRacine(FrontendTasks tasks) {

		tasks.task("installerVueRacine")
		
		      .waitsFor(window())
		      
		      .waitsFor(created(VueRacine.class))
		      
		      .thenExecutes(inputs -> {
		    	  
		    	  VueRacine vueRacine = inputs.get(created(VueRacine.class));
		    	  Window    window    = inputs.get(window());

		    	  window.installRootView(vueRacine);
		      });
	}

	private static void creerVueMaVue(FrontendTasks tasks) {

		tasks.task(create(VueMaVue.class))

		     .waitsFor(viewLoader(VueMaVue.class))

		     .thenExecutesAndReturnsValue(inputs -> {
		    	 
		    	 ViewLoader<VueMaVue> viewLoader = inputs.get(viewLoader(VueMaVue.class));
		    	 
		    	 VueMaVue vueMaVue = viewLoader.createView();

		    	 return vueMaVue;
		     });
	}


	private static void installerVueMaVue(FrontendTasks tasks) {

		tasks.task("installerVueMaVue")
		
		      .waitsFor(created(VueRacine.class))

		      .waitsFor(created(VueMaVue.class))

		      .thenExecutes(inputs -> {
		    	  
		    	  VueRacine vueRacine = inputs.get(created(VueRacine.class));
		    	  VueMaVue vueMaVue = inputs.get(created(VueMaVue.class));

		    	  vueRacine.afficherSousVue(vueMaVue);
		      });
	}


	private static void afficherFenetre(FrontendTasks tasks) {
		tasks.task("afficherFenetre")
		
		     .waitsFor(window())
		     
		     .thenExecutes(inputs -> {

		    	 Window window = (Window) inputs.get(window());

		    	 window.show();
		     });
	}

}
