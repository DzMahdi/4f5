package mon_jeu.frontal.taches;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import mon_jeu.frontal.evenements.EvtAfficherFileAttente;
import mon_jeu.frontal.vues.VueFileAttente;
import mon_jeu.frontal.vues.VueProfil;
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

					creerVueMaVueProfil(subTasks);
					installerVueMaVueProfil(subTasks);


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
					Window window = inputs.get(window());

					window.installRootView(vueRacine);
				});
	}

	private static void creerVueMaVueProfil(FrontendTasks tasks) {

		tasks.task(create(VueProfil.class))

				.waitsFor(viewLoader(VueProfil.class))

				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueProfil> viewLoader = inputs.get(viewLoader(VueProfil.class));

					VueProfil vueMaVue = viewLoader.createView();

					return vueMaVue;
				});
	}

	private static void installerVueMaVueProfil(FrontendTasks tasks) {

		tasks.task("installerVueMaVue")

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueProfil.class))

				.thenExecutes(inputs -> {

					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VueProfil vueProfil = inputs.get(created(VueProfil.class));

					vueRacine.afficherSousVue(vueProfil);
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
