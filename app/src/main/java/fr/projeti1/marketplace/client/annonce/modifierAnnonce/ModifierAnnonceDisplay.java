package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ModifierAnnonceDisplay extends ActivityContract.Display<ModifierAnnoncePresenterCallback> {

    void goToConsulter(Long idAnnonce);

    Context getContext();

    void startIntentService(Intent intentService);

    void registerListener(BroadcastReceiver receiver);
}
