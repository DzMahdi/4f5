package mon_jeu.modeles.valeurs;

import ca.ntro.app.models.Value;

public class MaValeur implements Value {
	
	private int attributUn;
	private boolean attributDeux;
	private String attributTrois;

	public int getAttributUn() {
		return attributUn;
	}

	public void setAttributUn(int attributUn) {
		this.attributUn = attributUn;
	}

	public boolean getAttributDeux() {
		return attributDeux;
	}

	public void setAttributDeux(boolean attributDeux) {
		this.attributDeux = attributDeux;
	}

	public String getAttributTrois() {
		return attributTrois;
	}

	public void setAttributTrois(String attributTrois) {
		this.attributTrois = attributTrois;
	}

	public MaValeur() {
	}
}
