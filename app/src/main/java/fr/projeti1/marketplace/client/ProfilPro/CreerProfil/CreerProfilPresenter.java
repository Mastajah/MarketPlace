package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;
import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;
import fr.projeti1.marketplace.server.service.ProfilProService;

public class CreerProfilPresenter extends ActivityPresenter<CreerProfilModel,CreerProfilDisplay> implements CreerProfilPresenterCallBack {

    public CreerProfilPresenter(CreerProfil vue) {
        super(vue);
        vue.setPresenter(this);
        initPresenter();
    }

    private void initPresenter() {
        model = new CreerProfilModel();
        view.initView();
    }

    @Override
    public void onClickValider() {
        view.flush();
        ProfilProDTO inputDTO = model.getCreateProfilProDTO();

        //déclaration de l'intent
        Intent intentProfilProService = new Intent (view.getContext(), ProfilProService.class);

        // Mets les données dans les extras de l'intent
        // Sachant que le 1er extra, on va mettre le nom de la fonction
        // Plus les données que tu veux transferer coté Serveur
        intentProfilProService.putExtra("nomFonction","creerProfilPro");
        intentProfilProService.putExtra("profilProDTO",inputDTO);

        // startService(nom de ton intent)
        view.startIntentService(intentProfilProService);
        // Appel asynchrone, ici l'instance tourne toujours, on attends le renvoi des données du serveur

        //Déclaration du listener (receiver)
        CreerProfilProReceiver creerProfilProReceiver = new CreerProfilProReceiver();
        view.registerListener(creerProfilProReceiver);
    }

    public class CreerProfilProReceiver extends BroadcastReceiver{
        // Ici, en attente de catch un intent (celui que renverra le service), des qu'il le catch, lance la méthode onReceive()
        @Override
        public void onReceive(Context context, Intent intent) {
            //on récupère l'ID du profilPro
            Long idProfilPro = intent.getLongExtra("idProfilPro",01);
            //on transmet à la vue pour qu'elle lance ConsulterProfilPro
            view.consult(idProfilPro);
        }

    }

    @Override
    public CreerProfilModel getModel(){
        return model;
    }
}
