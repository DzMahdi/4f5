package mon_jeu.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import mon_jeu.dorsal.taches.InitialiserModeles;
import mon_jeu.dorsal.taches.ModifierProfil;


public class DorsalMonJeu extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {

		InitialiserModeles.creerTaches(tasks);
		ModifierProfil.creerTaches(tasks);

	}

	@Override
	public void execute() {

	}

}
