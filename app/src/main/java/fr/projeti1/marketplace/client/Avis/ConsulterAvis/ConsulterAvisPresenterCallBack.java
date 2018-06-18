package fr.projeti1.marketplace.client.Avis.ConsulterAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ConsulterAvisPresenterCallBack extends ActivityContract.PresenterCallBack<ConsulterAvisModel>{
    /**
     * Retourne le Model
     */

    ConsulterAvisModel getModel();

    Long getIdAvis();
}
