package fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ConsulterProfilPresenterCallBack extends ActivityContract.PresenterCallBack<ConsulterProfilModel> {

    ConsulterProfilModel getModel();
    void supprimerProfilPro();
    Long getIdProfilPro ();
}
