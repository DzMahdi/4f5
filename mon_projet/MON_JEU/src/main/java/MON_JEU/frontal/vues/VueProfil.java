package mon_jeu.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mon_jeu.frontal.evenements.EvtAfficherFileAttente;
import mon_jeu.messages.MsgAjouterJoueur;

public class VueProfil extends ViewFx {
	
	
	@FXML
	private Button boutonQuitterMaVueProfil;
	
	@FXML
	private Button boutonAjouterJoueur;
	
	@FXML
	private Label labelMessage;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("boutonQuitterMaVueProfil", boutonQuitterMaVueProfil);
		Ntro.assertNotNull("boutonAjouterJoueur", boutonAjouterJoueur);
		Ntro.assertNotNull("labelMessage", labelMessage);
		
		installerEvtAfficherFileAttente();
		installerMsgAjouterJoueur();
	}
	
	


	private void installerMsgAjouterJoueur() {
		MsgAjouterJoueur msgAjouterJoueur = NtroApp.newMessage(MsgAjouterJoueur.class);
		
		boutonAjouterJoueur.setOnAction(evtFx ->{
			
			msgAjouterJoueur.setNomJoueur(nomAleatoire());
			msgAjouterJoueur.send();
		});
		
	}
	
	




	private String nomAleatoire() {
		
		List<String>nomJoueur = List.of("Mahdi",
				"Rayane", "Joseph", "Angelo", "Hassan", "Gio", "Achraf", "Cassandra", "Alicia");
		
		
		return Ntro.random().choice(nomJoueur);
	}




	private void installerEvtAfficherFileAttente() {
		
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);

		boutonQuitterMaVueProfil.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}




	public void afficherMessage(String message) {
		
		labelMessage.setText(message);
		
	}

}
