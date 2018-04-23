package gilm10129104.laboratoire8;

import gilm10129104.laboratoire8.comparateur.Comparateur;

import java.util.List;

/**
 * Created by GILM101291 on 2018-03-27.
 */
public class TriBulle {

    private Comparateur comparateur;

// -------------Constructor----------------

    public TriBulle(Comparateur comparateur) {
        this.comparateur = comparateur;
    }

// ---------------Methode------------------

//    Trier : Trie une personne sur different champs
    public void trier(List<Personne> personnes) {

        int n = personnes.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (comparateur.comparer(personnes.get(j), personnes.get(i)) < 0) {
                    Personne tmp = personnes.get(i);
                    personnes.set(i,personnes.get(j));
                    personnes.set(j,tmp);
                }
            }
        }
    }
}
