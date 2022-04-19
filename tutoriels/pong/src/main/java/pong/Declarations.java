package pong;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import pong.messages.MsgAjouterRendezVous;
import pong.modeles.ModeleFileAttente;
import pong.modeles.valeurs.PartieEnCours;
import pong.modeles.valeurs.RendezVous;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterRendezVous.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleFileAttente.class);

		registrar.registerValue(RendezVous.class);

		registrar.registerValue(PartieEnCours.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {
		
		registrar.registerName("localhost");
		
		registrar.registerPort(8002);
		
	}

}
