package mon_jeu.messages;

import ca.ntro.app.messages.MessageNtro;
import mon_jeu.modeles.MonModeleProfil;

public class MsgAjouterJoueur extends MessageNtro {
	
	private String nomJoueur;
	
	public MsgAjouterJoueur() {
		
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	
	public void ajouterA(MonModeleProfil profil) {
		
		profil.ajouterJoueurPour(nomJoueur);
	}

}
