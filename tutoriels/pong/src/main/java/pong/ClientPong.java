package pong;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import pong.dorsal.DorsalPong;
import pong.frontal.FrontalPong;
import pong.messages.MsgAjouterRendezVous;
import pong.modeles.ModeleFileAttente;
import pong.modeles.valeurs.PartieEnCours;
import pong.modeles.valeurs.RendezVous;

public class ClientPong implements NtroClientFx {

	public static void main(String[] args) {
		
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		
		registrar.registerBackend(new DorsalPong());
		
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		
		registrar.registerFrontend(new FrontalPong());
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		
		
		registrar.registerMessage(MsgAjouterRendezVous.class);
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		registrar.registerModel(ModeleFileAttente.class);
		
		registrar.registerValue(RendezVous.class);
		
		registrar.registerValue(PartieEnCours.class);
		
	}

}
