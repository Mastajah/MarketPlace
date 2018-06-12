package fr.projeti1.marketplace.client.ProfilPro.rechercherProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface RechercherProfilProPresenterCallback extends ActivityContract.PresenterCallBack<RechercherProfilProModel> {

    /**
     * Retourne le modèle.
     *
     * @return le modèle
     */
    RechercherProfilProModel getModel();

    void rechercher();
}
