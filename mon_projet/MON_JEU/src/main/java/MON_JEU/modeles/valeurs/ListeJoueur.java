package mon_jeu.modeles.valeurs;

import ca.ntro.app.models.Value;

public class ListeJoueur implements Value {

	private String idJoueur;
	private String nomJoueur;
	private int nombrePartieJouer;

	public ListeJoueur() {
	}
	
	public ListeJoueur(String idJoueur, String nomJoueur) {
		setIdJoueur(idJoueur);
		setNomJoueur(nomJoueur);
	}

	public int getNombrePartieJouer() {
		return nombrePartieJouer;
	}

	public void setNombrePartieJouer(int nombrePartieJouer) {
		this.nombrePartieJouer = nombrePartieJouer;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(String idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	@Override
	public String toString() {
		return nomJoueur;
	}

}
