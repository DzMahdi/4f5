package mon_jeu.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mon_jeu.frontal.evenements.EvtAfficherVueMaVue;

public class VueFileAttente extends ViewFx {
	
	
	@FXML
	private Button boutonOuvrirMaVue;

	@FXML
	private Button boutonAjouterRendezVous;

	@FXML
	private Label labelMessage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("boutonOuvrirMaVue", boutonOuvrirMaVue);
		Ntro.assertNotNull("boutonAjouterRendezVous", boutonAjouterRendezVous);
		Ntro.assertNotNull("labelMessage", labelMessage);

		installerEvtAfficherPartie();
	}

	private void installerEvtAfficherPartie() {
		
		EvtAfficherVueMaVue evtNtro = NtroApp.newEvent(EvtAfficherVueMaVue.class);

		boutonOuvrirMaVue.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}


}
