package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ModifierAnnoncePresenterCallback extends ActivityContract.PresenterCallBack<ModifierAnnonceModel> {

    void doModifier();
}
