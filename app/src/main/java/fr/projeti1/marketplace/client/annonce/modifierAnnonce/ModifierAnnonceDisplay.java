package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ModifierAnnonceDisplay extends ActivityContract.Display<ModifierAnnoncePresenterCallback> {

    void goToConsulter(Long idAnnonce);
}
