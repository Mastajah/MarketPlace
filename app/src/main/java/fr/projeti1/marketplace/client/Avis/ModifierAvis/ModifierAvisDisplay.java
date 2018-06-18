package fr.projeti1.marketplace.client.Avis.ModifierAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ModifierAvisDisplay extends ActivityContract.Display<ModifierAvisPresenterCallBack>{
    void consult(Long idAvis);
}
