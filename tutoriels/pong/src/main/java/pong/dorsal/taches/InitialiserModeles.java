package pong.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import pong.modeles.ModeleFileAttente;

public class InitialiserModeles {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("InitialiserModeles")

				.contains(subTasks -> {
					
					initialiserModeleFileAttente(subTasks);

				});

	}

	private static void initialiserModeleFileAttente(BackendTasks tasks) {

		tasks.task("InitialiserModeleFileAttente")

				.waitsFor(model(ModeleFileAttente.class))

				.thenExecutes(inputs -> {

					ModeleFileAttente fileAttente = inputs.get(model(ModeleFileAttente.class));

					fileAttente.initialiser();

				});

	}

}
