package fr.projeti1.marketplace.client.ProfilPro.ModifierProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ModifierProfilDisplay extends  ActivityContract.Display<ModifierProfilPresenterCallBack> {
    void consult(Long idProfilPro);
}

