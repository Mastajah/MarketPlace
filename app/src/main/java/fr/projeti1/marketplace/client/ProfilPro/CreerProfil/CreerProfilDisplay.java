package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface CreerProfilDisplay extends ActivityContract.Display <CreerProfilPresenterCallBack> {
    void consult(Long idProfil);
}
