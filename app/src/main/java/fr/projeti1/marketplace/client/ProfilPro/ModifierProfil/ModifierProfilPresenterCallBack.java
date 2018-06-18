package fr.projeti1.marketplace.client.ProfilPro.ModifierProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ModifierProfilPresenterCallBack  extends ActivityContract.PresenterCallBack <ModifierProfilModel>{
    void onClickValiderModif();
}
