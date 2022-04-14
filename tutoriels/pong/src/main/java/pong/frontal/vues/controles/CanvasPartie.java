package pong.frontal.vues.controles;

import ca.ntro.app.views.controls.canvas.World2dCanvas;
import javafx.scene.image.Image;

public class CanvasPartie extends World2dCanvas {

	private Image logo;

	@Override
	protected void initialize() {

		setEpsilon(2);

		logo = new Image("/logo.png");

	}
/*
	@Override
	protected void onInitialSize(int initialWidth, int initialHeight) {

		dessiner(initialWidth, initialHeight);

	}

	@Override
	protected void onNewSize(int oldWidth, int oldHeight, int newWidth, int newHeight) {
		
		dessiner(newWidth, newHeight);

	}

	private void dessiner(int largeurCanvas, int hauteurCanvas) {
		
		getGc().clearRect(0, 0, largeurCanvas, hauteurCanvas);
		getGc().strokeRect(0, 0, largeurCanvas, hauteurCanvas);
		
		double rectangleHautGaucheX = 0.25 * largeurCanvas;
		double rectangleHautGaucheY = 0.25 * hauteurCanvas;
		double largeurRectangle = 0.5 * largeurCanvas;
		double hauteurRectangle = 0.5 * hauteurCanvas;
		
		
		getGc().setFill(Color.color(0.81, 0.37, 0.2));
		getGc().fillRect(rectangleHautGaucheX,
					   rectangleHautGaucheY,
					   largeurRectangle,
					   hauteurRectangle);
		
		double imageHautGaucheX = rectangleHautGaucheX + 0.25 * largeurRectangle;
		double imageHautGaucheY = rectangleHautGaucheY + 0.25 * hauteurRectangle;
		double largeurImage = 0.5 * largeurRectangle;
		double hauteurImage = 0.5 * hauteurRectangle;
		
		getGc().drawImage(logo,
						  imageHautGaucheX,
						  imageHautGaucheY,
						  largeurImage,
						  hauteurImage);
		
		
		

	}
*/
}
