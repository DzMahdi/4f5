package pong.frontal.vues.fragments;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pong.frontal.evenements.EvtAfficherPartie;

public class FragmentRendezVous extends ViewFx{

	@FXML
	private Button boutonOuvrirPartie;
	
	@FXML
	private Label labelNomPremierJoueur;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("boutonOuvrirPartie", boutonOuvrirPartie);
		Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
		
		installerEvtAfficherPartie();
		
	}



	private void installerEvtAfficherPartie() {
		
		EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);
		
		boutonOuvrirPartie.setOnAction(evtFx ->{
			
			evtNtro.trigger();
			
		});
		
	}
	
	public void afficherNomPremierJoueur(String nomPremierJoueur) {
		labelNomPremierJoueur.setText(nomPremierJoueur);
	}

}
