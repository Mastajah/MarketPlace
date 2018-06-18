package fr.projeti1.marketplace.client.Avis.CreerAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface CreerAvisDisplay extends ActivityContract.Display<CreerAvisPresenterCallBack> {

    void consult(Long idAvis);
}
