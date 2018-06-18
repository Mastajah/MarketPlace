package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface CreerProfilPresenterCallBack extends ActivityContract.PresenterCallBack<CreerProfilModel> {
    void onClickValider();
}
