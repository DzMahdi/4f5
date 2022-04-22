package pong.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;

import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import pong.Session;
import pong.frontal.vues.fragments.FragmentRendezVous;
import pong.messages.MsgAjouterRendezVous;

public class VueFileAttente extends ViewFx {

	
	
	@FXML
	private Button boutonAjouterRendezVous;
	
	@FXML
	private VBox conteneurRendezVous;

	

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		Ntro.assertNotNull("boutonAjouterRendezvous", boutonAjouterRendezVous);
		
		Ntro.assertNotNull("conteneurRendezVous", conteneurRendezVous);

		
		installerMsgAjouterRendezVous();
	}

	private void installerMsgAjouterRendezVous() {
		
		MsgAjouterRendezVous msgAjouterRendezVous = NtroApp.newMessage(MsgAjouterRendezVous.class);
		
		boutonAjouterRendezVous.setOnAction(evtFx -> {
			
			
			msgAjouterRendezVous.setNomPremierJoueur(Session.nomUsager);
			
			msgAjouterRendezVous.send();
		
			
		//	System.out.println("[VueAjouterRendezVous] clic: " + evtFx.getEventType());
			
			
		});
		
	}

	private String nomAleatoire() {
		
		
		List<String> choixDeNoms = List.of("Alice",
											"Bob",
											"Chaaya",
											"Dominic",
											"Élisabeth",
											"Firas",
											"Gregson",
											"Hana",
											"Ichiro",
											"Jun");
		
		return Ntro.random().choice(choixDeNoms);
	}
	
	
	public void viderListeRendezVous() {
		conteneurRendezVous.getChildren().clear();
	}
	
	private Pane petitEspaceVertical() {
		
		Pane petitEspaceVertical = new Pane();
		
		petitEspaceVertical.getStyleClass().add("petit-espace-vertical");
		
		return petitEspaceVertical;
		
	}
	
	
	public void ajouterRendezVous(FragmentRendezVous fragmentRendezVous) {
		
		conteneurRendezVous.getChildren().add(fragmentRendezVous.rootNode());
		
		conteneurRendezVous.getChildren().add(petitEspaceVertical());
		
	}

	



}
