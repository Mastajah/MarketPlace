package fr.projeti1.marketplace.client.annonce.consulterAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ConsulterAnnoncePresenterCallback extends ActivityContract.PresenterCallBack<ConsulterAnnonceModel> {

    /**
     * Retourne le modèle.
     *
     * @return le modèle
     */
    ConsulterAnnonceModel getModel();

    Long getIdAnnonce();
}
