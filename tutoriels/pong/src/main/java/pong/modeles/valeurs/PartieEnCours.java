package pong.modeles.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import pong.frontal.vues.fragments.FragmentPartieEnCours;
import pong.frontal.vues.fragments.FragmentRendezVous;

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
	
	
	@Override
	public FragmentRendezVous creerFragment(ViewLoader<FragmentRendezVous> viewLoaderRendezVous,
											 ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours	) {
		return viewLoaderPartieEnCours.createView();
		
	}
	
	@Override
	public void afficherSur(FragmentRendezVous fragmentRendezVous) {
		super.afficherSur(fragmentRendezVous);
		
		FragmentPartieEnCours fragmentPartieEnCours = (FragmentPartieEnCours) fragmentRendezVous;
		
		fragmentPartieEnCours.afficherNomDeuxiemeJoueur(nomDeuxiemeJoueur);
		
	}
}
