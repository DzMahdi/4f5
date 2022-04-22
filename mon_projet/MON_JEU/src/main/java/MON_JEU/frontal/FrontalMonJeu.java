package mon_jeu.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import mon_jeu.frontal.evenements.EvtAfficherVueMaVueProfil;
import mon_jeu.frontal.evenements.EvtAfficherFileAttente;
import mon_jeu.frontal.taches.AfficherProfil;
import mon_jeu.frontal.taches.Initialisation;
import mon_jeu.frontal.taches.Navigation;
import mon_jeu.frontal.vues.VueFileAttente;
import mon_jeu.frontal.vues.VueProfil;
import mon_jeu.frontal.vues.VueRacine;


public class FrontalMonJeu implements FrontendFx {
	
	@Override
	public void createTasks(FrontendTasks tasks) {
		
		Initialisation.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		AfficherProfil.creerTaches(tasks);

	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		registrar.registerEvent(EvtAfficherVueMaVueProfil.class);
		registrar.registerEvent(EvtAfficherFileAttente.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerDefaultResources("/chaines_fr.properties");
		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
		
		//registrar.registerStylesheet("/dev.css");
		registrar.registerStylesheet("/prod.css");
		
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueFileAttente.class, "/file_attente.xml");
		registrar.registerView(VueProfil.class, "/profil.xml");
	}

	@Override
	public void execute() {

	}

}
