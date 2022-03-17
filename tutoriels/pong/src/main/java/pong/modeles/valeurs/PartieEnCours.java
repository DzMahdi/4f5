package pong.modeles.valeurs;

public class PartieEnCours extends RendezVous {

	public PartieEnCours() {

	}

	private String nomDeuxiemeJoueur;
	private String idPartie;

	public String getNomDeuxiemeJoueur() {
		return nomDeuxiemeJoueur;
	}

	public void setNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
		this.nomDeuxiemeJoueur = nomDeuxiemeJoueur;
	}

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Vs " + nomDeuxiemeJoueur;
	}
}
