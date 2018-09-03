package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Date;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.client.annonce.creerAnnonce.CreerAnnoncePresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;
import fr.projeti1.marketplace.server.service.AnnonceService;

public class ModifierAnnoncePresenter extends ActivityPresenter<ModifierAnnonceModel, ModifierAnnonceDisplay> implements ModifierAnnoncePresenterCallback {

    //private AnnonceService annonceService;

    public ModifierAnnoncePresenter(ModifierAnnonce view) {
        super(view);
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        model = new ModifierAnnonceModel();

        //Normalement Appel serveur lors de l'init en consultation
        //Pour test, on alimente le DTO
        AnnonceDTO annonceDTO = new AnnonceDTO();
        annonceDTO.setNumeroAnnonce(1L);
        annonceDTO.setTitre("Compteur en rade");
        annonceDTO.setDescription("Le compteur electrique en panne");
        annonceDTO.setStatut("A traiter");
        annonceDTO.setAdresse("20 quai de Tounis");
        annonceDTO.setCodePostale("31000");
        annonceDTO.setVille("Toulouse");
        // Compte particulier
        ParticulierDTO particulierDTO = new ParticulierDTO();
        particulierDTO.setNumeroClient(12l);
        particulierDTO.setNomClient("DELPRATRA");
        particulierDTO.setPrenomClient("Jack");
        particulierDTO.setNumeroTelephone(33648842536l);
        particulierDTO.setMail("jack.delpratra@gmali.com");
        particulierDTO.setMotDePasse("1234");
        particulierDTO.setAdresse("20 quai de Tounis");
        particulierDTO.setVille("Toulouse");
        particulierDTO.setCodePostal(31000l);
        annonceDTO.setParticulierDTO(particulierDTO);

        model.setAnnonceDTO(annonceDTO);
        view.initView();
    }

    @Override
    public void doModifier(){
        //On transmet à la vue pour qu'elle lance ConsulterAnnonce
        view.goToConsulter(99l);

        /*view.flush();
        AnnonceDTO inputDTO = model.getAnnonceDTO();

        // Déclaration de l'intent
        Intent intentAnnonceService = new Intent(view.getContext(), AnnonceService.class);

        // Mets les données dans les extras de l'intent
        // Sachant que le 1er extra, on va mettre le nom de la fonction
        // Plus les données que tu veux transferer coté Serveur
        intentAnnonceService.putExtra("nomFonction","modifierAnnonce");
        intentAnnonceService.putExtra("annonceDTO",inputDTO);

        // startService(nom de ton intent)
        view.startIntentService(intentAnnonceService);
        // Appel asynchrone, ici l'instance tourne toujours, on attends le renvoi des données du serveur

        //Déclaration du listener (receiver)
        ModifierAnnonceReceiver modifierAnnonceReceiver = new ModifierAnnonceReceiver();
        view.registerListener(modifierAnnonceReceiver);*/
    }

    public class ModifierAnnonceReceiver extends BroadcastReceiver {

        // Ici, en attente de catch un intent (celui que renverra le service), des qu'il le catch, lance la méthode onReceive()
        @Override
        public void onReceive(Context context, Intent intent) {
            //On récupère l'id de l'annonce
            Long idAnnonce = intent.getLongExtra("idAnnonce",0l);

            //On transmet à la vue pour qu'elle lance ConsulterAnnonce
            view.goToConsulter(idAnnonce);
        }
    }

    public ModifierAnnonceModel getModel() {
        return model;
    }
}
