package pong.modeles.monde_pong2d;

import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;

public class Balle2d extends ObjetPong2d {

	private static final double EPSILON = 1;

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (balleFrappeMurGauche()) {

			balleRebondiSurMurGauche();

		} else if (balleFrappeMurDroit()) {

			balleRebondiSurMurDroite();

		} else if (balleFrappePlafond()) {

			balleRebondiSurPlafond();

		} else if (balleFrappePlancher()) {

			balleRebondiSurPlancher();
		}

	}

	private void balleRebondiSurPlancher() {
		setTopLeftY(getWorld().getHeight() - this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
		
	}

	private boolean balleFrappePlancher() {
		
		
		return collidesWith(0, getWorld().getHeight(), getWorld().getWidth(), 1);
	}

	private void balleRebondiSurPlafond() {
		
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
		
		
	}

	private boolean balleFrappePlafond() {
		
		return collidesWith(0, 0, getWorld().getWidth(), 1);
	}

	private void balleRebondiSurMurDroite() {
		setTopLeftX(getWorld().getWidth() - this.getWidth() - EPSILON);
		setSpeedX(-getSpeedX());
		
	}

	private boolean balleFrappeMurDroit() {
		
		return collidesWith(getWorld().getWidth(), 0, 1, getWorld().getHeight());
	}

	private void balleRebondiSurMurGauche() {
		
		setTopLeftX(0 + EPSILON);
		setSpeedX(-getSpeedX());
		
	}

	private boolean balleFrappeMurGauche() {
		
		return collidesWith(0, 0, 1, getWorld().getHeight());
	}

	@Override
	protected boolean onMouseEvent(MouseEvent evtFx, double worldX, double worldY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {

		gc.fillArc(getTopLeftX(), getTopLeftY(), getWidth(), getHeight(), 0, 360, ArcType.CHORD);

	}

	@Override
	public void initialize() {

		setTopLeftX(100);
		setTopLeftY(100);
		setWidth(10);
		setHeight(10);

		setSpeedX(100 + Ntro.random().nextInt(100));
		setSpeedY(100 + Ntro.random().nextInt(100));

	}

}
