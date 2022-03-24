package mon_jeu;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import mon_jeu.dorsal.DorsalDessin;
import mon_jeu.frontal.FrontalMonJeu;
import mon_jeu.modeles.MonModele;
import mon_jeu.modeles.valeurs.MaValeur;


public class ClientMonJeu implements NtroClientFx {
	
	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {

		registrar.registerFrontend(new FrontalMonJeu());

	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {


	}

	@Override
	public void registerModels(ModelRegistrar registrar) {

		registrar.registerModel(MonModele.class);

		registrar.registerValue(MaValeur.class);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {

		registrar.registerBackend(new DorsalDessin());
	}

}
