package pong;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import pong.dorsal.DorsalPong;
import pong.frontal.FrontalPong;

public class PongLocal implements NtroClientFx {

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

		Declarations.declarerMessages(registrar);

	}

	@Override
	public void registerModels(ModelRegistrar registrar) {

		Declarations.declarerModeles(registrar);

	}

}
