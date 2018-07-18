package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface CreerProfilDisplay extends ActivityContract.Display <CreerProfilPresenterCallBack> {
    void consult(Long idProfil);

    Context getContext();

    void startIntentService(Intent intentService);

    void registerListener(BroadcastReceiver receiver);
}
