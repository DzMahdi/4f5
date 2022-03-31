package pong.frontal;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.evenements.EvtAfficherPartie;
import pong.frontal.taches.AfficherFileAttente;
import pong.frontal.taches.Initialisation;
import pong.frontal.taches.Navigation;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;
import pong.frontal.vues.fragments.FragmentPartieEnCours;
import pong.frontal.vues.fragments.FragmentRendezVous;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.NtroApp;

public class FrontalPong implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {

		Initialisation.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		AfficherFileAttente.creerTaches(tasks);

	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerEvents(EventRegistrar registrar) {

		registrar.registerEvent(EvtAfficherFileAttente.class);

		registrar.registerEvent(EvtAfficherPartie.class);

	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {

		registrar.registerView(VueRacine.class, "/racine.xml");

		registrar.registerView(VueFileAttente.class, "/file_attente.xml");

		registrar.registerStylesheet("/dev.css");

		// registrar.registerStylesheet("/prod.css");

		registrar.registerDefaultResources("/chaine_fr.properties");

		registrar.registerResources(NtroApp.locale("en"), "/chaine_en.properties");

		registrar.registerView(VuePartie.class, "/partie.xml");
		
		
		registrar.registerView(FragmentRendezVous.class, "/fragments/rendez_vous.xml");
		registrar.registerView(FragmentPartieEnCours.class, "/fragments/partie_en_cours.xml");
		
		

	}

}
