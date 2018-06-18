package fr.projeti1.marketplace.client.Avis.CreerAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface CreerAvisPresenterCallBack extends ActivityContract.PresenterCallBack <CreerAvisModel> {

    void onClickValider();
}
