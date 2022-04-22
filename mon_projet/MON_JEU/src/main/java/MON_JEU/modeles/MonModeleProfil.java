package mon_jeu.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import mon_jeu.frontal.vues.VueProfil;
import mon_jeu.modeles.valeurs.ListeJoueur;

public class MonModeleProfil implements Model {
	
	
    private long prochainIdJoueur = 1;
    private List<ListeJoueur> maListeJoueur = new ArrayList<>();

    

    public List<ListeJoueur> getMaListeJoueur() {
		return maListeJoueur;
	}

	public void setMaListeJoueur(List<ListeJoueur> maListeJoueur) {
		this.maListeJoueur = maListeJoueur;
	}

	public MonModeleProfil() {
    }

    public void initialiser() {
    }

	public void ajouterJoueurPour(String nomDesJoueur) {
		
		String idJoueur = genererIdJoueur();
		
		ListeJoueur listeJoueur = new ListeJoueur(idJoueur, nomDesJoueur);
		
		maListeJoueur.add(listeJoueur);
		
		
		
	}

	private String genererIdJoueur() {
		String idJoueur = String.valueOf(prochainIdJoueur);
		prochainIdJoueur++;
		
		return idJoueur;
	}
	
	public void afficherSur(VueProfil vueProfil) {
		
		vueProfil.afficherMessage(this.toString());
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		int numeroJoueur = 1;
		
		for(ListeJoueur listeJoueur : maListeJoueur) {
			builder.append(numeroJoueur);
			builder.append(". ");
			builder.append(listeJoueur.toString());
			builder.append("\n");
			
			numeroJoueur++;
			
		}
		
		return builder.toString();
		
	}
}
