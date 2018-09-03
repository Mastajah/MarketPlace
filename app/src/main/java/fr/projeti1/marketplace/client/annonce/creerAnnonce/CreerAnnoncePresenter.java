package fr.projeti1.marketplace.client.annonce.creerAnnonce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;
import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.server.service.AnnonceService;

public class CreerAnnoncePresenter extends ActivityPresenter<CreerAnnonceModel, CreerAnnonceDisplay> implements CreerAnnoncePresenterCallBack {

    //Receiver pour l'appel serveur
    private  CreerAnnonceReceiver creerAnnonceReceiver;

    public CreerAnnoncePresenter(CreerAnnonce view) {
        super(view);
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        model = new CreerAnnonceModel();
        view.initView();
    }

    @Override
    public void doValider(){
        /*view.flush();
        AnnonceDTO inputDTO = model.getAnnonceDTO();

        // Déclaration de l'intent
        Intent intentAnnonceService = new Intent(view.getContext(), AnnonceService.class);

        // Mets les données dans les extras de l'intent
        // Sachant que le 1er extra, on va mettre le nom de la fonction
        // Plus les données que tu veux transferer coté Serveur
        intentAnnonceService.putExtra("nomFonction","creerAnnonce");
        intentAnnonceService.putExtra("annonceDTO",inputDTO);

        // startService(nom de ton intent)
        view.startIntentService(intentAnnonceService);
        // Appel asynchrone, ici l'instance tourne toujours, on attends le renvoi des données du serveur

        //Déclaration du listener (receiver)
        creerAnnonceReceiver = new CreerAnnonceReceiver();
        IntentFilter intentFilter = new IntentFilter();
        view.registerListener(creerAnnonceReceiver, intentFilter);*/
        //On transmet à la vue pour qu'elle lance ConsulterAnnonce
        view.goToConsulter(99l);
    }

    public class CreerAnnonceReceiver extends BroadcastReceiver {

        // Ici, en attente de catch un intent (celui que renverra le service), des qu'il le catch, lance la méthode onReceive()
        @Override
        public void onReceive(Context context, Intent intent) {

            // view.unregisterListener(creerAnnonceReceiver);

            //On récupère l'id de l'annonce
            Long idAnnonce = intent.getLongExtra("idAnnonce",0l);

            //On transmet à la vue pour qu'elle lance ConsulterAnnonce
            view.goToConsulter(idAnnonce);
        }
    }

    public CreerAnnonceModel getModel() {
        return model;
    }
}
