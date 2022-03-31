package pong.modeles;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.fragments.FragmentPartieEnCours;
import pong.frontal.vues.fragments.FragmentRendezVous;
import pong.modeles.valeurs.RendezVous;

public class ModeleFileAttente implements Model {

	public ModeleFileAttente() {

	}

	private long horodatageOuverture = -1;

	public long getHorodatageOuverture() {
		return horodatageOuverture;
	}

	public void setHorodatageOuverture(long horodatageOuverture) {
		this.horodatageOuverture = horodatageOuverture;
	}

	public void initialiser() {

		Date maintenant = new Date(0, 0, 0);
		horodatageOuverture = maintenant.getTime();

		System.out.println("[ModeleFileAttente " + new SimpleDateFormat("EEEE DD MMMM, HH:mm").format(maintenant));

	}

	private long prochainIdRendezVous = 1;
	private List<RendezVous> rendezVousDansOrdre = new ArrayList<>();

	public List<RendezVous> getRendezVousDansOrdre() {
		return rendezVousDansOrdre;
	}

	public void setRendezVousDansOrdre(List<RendezVous> rendezVousDansOrdre) {
		this.rendezVousDansOrdre = rendezVousDansOrdre;
	}

	public void ajouterRendezVousPour(String nomPremierJoueur) {

		String idRendezVous = genererIdRendezVous();

		RendezVous rendezVous = new RendezVous(idRendezVous, nomPremierJoueur);

		rendezVousDansOrdre.add(rendezVous);

	}

	private String genererIdRendezVous() {

		String idRendezVous = String.valueOf(prochainIdRendezVous);

		prochainIdRendezVous++;

		return idRendezVous;
	}

	public void afficherSur(VueFileAttente vueFileAttente, ViewLoader<FragmentRendezVous> viewLoaderRendezVous,
			ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours) {

		vueFileAttente.viderListeRendezVous();

		for (RendezVous rendezVous : rendezVousDansOrdre) {

			FragmentRendezVous fragmentRendezVous = rendezVous.creerFragment(viewLoaderRendezVous,
					viewLoaderPartieEnCours);

			rendezVous.afficherSur(fragmentRendezVous);

			vueFileAttente.ajouterRendezVous(fragmentRendezVous);

		}

	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numeroRendezVous = 1;

		for (RendezVous rendezVous : rendezVousDansOrdre) {

			builder.append(numeroRendezVous);
			builder.append(". ");
			builder.append(rendezVous.toString());
			builder.append("\n");

			numeroRendezVous++;

		}

		return builder.toString();

	}

}
