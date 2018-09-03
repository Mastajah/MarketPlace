package fr.projeti1.marketplace.client.annonce.consulterAnnonce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.client.annonce.modifierAnnonce.ModifierAnnoncePresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;
import fr.projeti1.marketplace.server.service.AnnonceService;

public class ConsulterAnnoncePresenter extends ActivityPresenter<ConsulterAnnonceModel, ConsulterAnnonceDisplay> implements ConsulterAnnoncePresenterCallback{

    //private AnnonceService annonceService;

    /**
     * Id de l'annonce
     */
    private Long idAnnonce;

    public ConsulterAnnoncePresenter(ConsulterAnnonce view,Long idAnnonce) {
        super(view);
        view.setPresenter(this);
        this.idAnnonce = idAnnonce;
        initPresenter();
    }

    private void initPresenter(){
        this.model = new ConsulterAnnonceModel();

        AnnonceDTO annonceDTO = new AnnonceDTO();
        annonceDTO.setNumeroAnnonce(1L);
        annonceDTO.setTitre("Compteur en rade");
        annonceDTO.setDescription("Le compteur electrique est en panne");
        annonceDTO.setStatut("Traitée");
        annonceDTO.setAdresse("20 quai de Tounis");
        annonceDTO.setCodePostale("31000");
        annonceDTO.setVille("Toulouse");
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

        // Déclaration de l'intent
        //Intent intentAnnonceService = new Intent(view.getContext(), AnnonceService.class);

        // Mets les données dans les extras de l'intent
        // Sachant que le 1er extra, on va mettre le nom de la fonction
        // Plus les données que tu veux transferer coté Serveur
        //intentAnnonceService.putExtra("nomFonction","consulterAnnonce");
        //intentAnnonceService.putExtra("annonceDTO",idAnnonce);

        // startService(nom de ton intent)
        //view.startIntentService(intentAnnonceService);
        // Appel asynchrone, ici l'instance tourne toujours, on attends le renvoi des données du serveur

        //Déclaration du listener (receiver)
        //ConsulterAnnonceReceiver consulterAnnonceReceiver = new ConsulterAnnonceReceiver();
        //view.registerListener(consulterAnnonceReceiver);
    }

    public class ConsulterAnnonceReceiver extends BroadcastReceiver {

        // Ici, en attente de catch un intent (celui que renverra le service), des qu'il le catch, lance la méthode onReceive()
        @Override
        public void onReceive(Context context, Intent intent) {
            //On récupère l'id de l'annonce
            AnnonceDTO annonceDTO = intent.getParcelableExtra("annonceDTO");
            model.setAnnonceDTO(annonceDTO);
            view.initView();
        }
    }

    public ConsulterAnnonceModel getModel() {
        return this.model;
    }

    @Override
    public Long getIdAnnonce() {
        return this.idAnnonce;
    }
}
