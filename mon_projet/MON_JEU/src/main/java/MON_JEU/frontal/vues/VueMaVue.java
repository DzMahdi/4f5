package mon_jeu.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mon_jeu.frontal.evenements.EvtAfficherFileAttente;

public class VueMaVue extends ViewFx {
	
	
	@FXML
	private Button boutonQuitterMaVue;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("boutonQuitterMaVue", boutonQuitterMaVue);
		
		installerEvtAfficherFileAttente();
	}


	private void installerEvtAfficherFileAttente() {
		
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);

		boutonQuitterMaVue.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}

}
