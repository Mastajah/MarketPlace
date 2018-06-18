package fr.projeti1.marketplace.client.Avis.ModifierAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ModifierAvisPresenterCallBack extends ActivityContract.PresenterCallBack<ModifierAvisModel>{
    void onClickValiderModif();
}
