package pong;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import pong.dorsal.DorsalPong;
import pong.dorsal.DorsalPongDistant;
import pong.frontal.FrontalPong;
import pong.modeles.enums.Cadran;

public class ClientPong implements NtroClientFx {

	public static void main(String[] args) {

		
		
		if(args.length > 0) {
			Session.nomUsager = args[0];
		}
		
		if(args.length > 1) {
			Session.cadran = Cadran.valueOf(args[1]);
		}
		
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {

		registrar.registerBackend(new DorsalPongDistant());

	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {

		registrar.registerFrontend(new FrontalPong());

	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {

		Declarations.declarerMessages(registrar);

	}

	@Override
	public void registerModels(ModelRegistrar registrar) {

		Declarations.declarerModeles(registrar);

	}

}
