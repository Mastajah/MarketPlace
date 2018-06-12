package fr.projeti1.marketplace.client.annonce.creerAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface CreerAnnonceDisplay extends ActivityContract.Display<CreerAnnoncePresenterCallBack> {

    void goToConsulter(Long idAnnonce);
}
