package fr.projeti1.marketplace.client.annonce.consulterAnnonce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;

public interface ConsulterAnnonceDisplay extends ActivityContract.Display<ConsulterAnnoncePresenterCallback>{

    Context getContext();

    void startIntentService(Intent intentService);

    void registerListener(BroadcastReceiver receiver);
}
