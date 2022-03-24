package mon_jeu.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import mon_jeu.modeles.valeurs.MaValeur;

public class MonModele implements Model {
    
    private List<MaValeur> maListe = new ArrayList<>();

    public List<MaValeur> getMaListe() {
        return maListe;
    }

    public void setMaListe(List<MaValeur> maListe) {
        this.maListe = maListe;
    }

    public MonModele() {
    }

    public void initialiser() {
    }
}
