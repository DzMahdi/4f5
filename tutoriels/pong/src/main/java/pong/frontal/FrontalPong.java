package pong.frontal;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.taches.Initialisation;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.NtroApp;

public class FrontalPong implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {

	
		
		Initialisation.creerTaches(tasks);

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
		registrar.registerView(VueRacine.class, "/racine.xml");
		
		registrar.registerView(VueFileAttente.class, "/file_attente.xml");
		
		registrar.registerStylesheet("/dev.css");
		
		//registrar.registerStylesheet("/prod.css");
		
		
		registrar.registerDefaultResources("/chaine_fr.properties");
		
		registrar.registerResources(NtroApp.locale("en"), "/chaine_en.properties");
		

	}

}
