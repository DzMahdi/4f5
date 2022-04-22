package mon_jeu.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mon_jeu.frontal.evenements.EvtAfficherVueMaVueProfil;

public class VueFileAttente extends ViewFx {
	
	
	@FXML
	private Button boutonOuvrirMaVueProfil;

	@FXML
	private Label labelMessage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("boutonOuvrirMaVueProfil", boutonOuvrirMaVueProfil);
		Ntro.assertNotNull("labelMessage", labelMessage);

		installerEvtAfficherProfil();
	}

	private void installerEvtAfficherProfil() {
		
		EvtAfficherVueMaVueProfil evtNtro = NtroApp.newEvent(EvtAfficherVueMaVueProfil.class);

		boutonOuvrirMaVueProfil.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}


}
