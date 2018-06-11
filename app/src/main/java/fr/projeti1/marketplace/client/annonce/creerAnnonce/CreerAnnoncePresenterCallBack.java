package fr.projeti1.marketplace.client.annonce.creerAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface CreerAnnoncePresenterCallBack extends ActivityContract.PresenterCallBack<CreerAnnonceModel> {

    void doValider();
}
