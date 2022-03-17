package pong.modeles.valeurs;

import ca.ntro.app.models.Value;

public class RendezVous implements Value {

	public RendezVous() {

	}
	
	public RendezVous(String idRendezVous, String nomPremierJoueur) {
		
		setIdRendezVous(idRendezVous);
		setNomPremierJoueur(nomPremierJoueur);
	}

	private String idRendezVous;
	private String nomPremierJoueur;

	public String getIdRendezVous() {
		return idRendezVous;
	}

	public void setIdRendezVous(String idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public String getNomPremierJoueur() {
		return nomPremierJoueur;
	}

	public void setNomPremierJoueur(String nomPremierJoueur) {
		this.nomPremierJoueur = nomPremierJoueur;
	}
	
	@Override
	public String toString() {
		return nomPremierJoueur;
	}

}
