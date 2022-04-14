package pong.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jsweet.util.StringTypes.canvas;
import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.vues.controles.CanvasPartie;
import pong.modeles.monde_pong2d.MondePong2d;

public class VuePartie extends ViewFx{
	
	@FXML
	private Button boutonQuitterPartie;
	
	@FXML
	private CanvasPartie canvasPartie;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		
		installerEvtAfficherFileAttente();
		
		Ntro.assertNotNull("canvasPartie", canvasPartie);
		initialiserCanvasPartie();
		
		
	}

	private void initialiserCanvasPartie() {
	
		canvasPartie.setWorldWidth(MondePong2d.LARGEUR_MONDE);
		canvasPartie.setWorldHeight(MondePong2d.HAUTEUR_MONDE);
		
	}

	private void installerEvtAfficherFileAttente() {
		
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
		
		boutonQuitterPartie.setOnAction(evtFx -> {
			
			evtNtro.trigger();
			
			System.out.println("[VuePartie] clic: " + evtFx.getEventType());
			
		});
		
	}

	public void viderCanvas() {
		canvasPartie.clearCanvas();
		
	}

	public void afficherImageParSeconde(String fps) {
		
		canvasPartie.displayFps(fps);
		
	}

	public void afficherPong2d(MondePong2d mondePong2d) {
		
		canvasPartie.displayWorld2d(mondePong2d);
		
	}

		
	

}
