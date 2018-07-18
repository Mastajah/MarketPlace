package fr.projeti1.marketplace.client.Map;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.service.AnnonceService;

public class MapsAnnoncePresenter{

    protected MapsAnnonceModel model;
    protected MapsAnnonce view;

    public MapsAnnoncePresenter(MapsAnnonce view){
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        this.model = new MapsAnnonceModel();
        AnnonceDTO annonceDTO1 = new AnnonceDTO();
        annonceDTO1.setNumeroAnnonce(1L);
        annonceDTO1.setTitre("Compteur en rade");
        annonceDTO1.setDescription("Le compteur electrique en panne");
        annonceDTO1.setAdresse("20 quai de Tounis");
        annonceDTO1.setCodePostale("31000");
        annonceDTO1.setVille("Toulouse");

        AnnonceDTO annonceDTO2 = new AnnonceDTO();
        annonceDTO2.setNumeroAnnonce(2L);
        annonceDTO2.setTitre("Radiateur en rade");
        annonceDTO2.setDescription("Le Radiateur ne marche plus");
        annonceDTO2.setAdresse("1 Rue de Metz");
        annonceDTO2.setCodePostale("31000");
        annonceDTO2.setVille("Toulouse");

        ArrayList<AnnonceDTO> listAnnonce = new ArrayList<AnnonceDTO>();
        listAnnonce.add(annonceDTO1);
        listAnnonce.add(annonceDTO2);
        model.setAnnonceDTOs(listAnnonce);
        //doRechercherAnnonce();
    }

    public void doRechercherAnnonce(){
        view.flush();
        ArrayList<AnnonceDTO> inputListDTO = model.getAnnonceDTOs();

        Intent intentAnnonceService = new Intent(view.getContext(),AnnonceService.class);

        // Mets les données dans les extras de l'intent
        // Sachant que le 1er extra, on va mettre le nom de la fonction
        // Plus les données que tu veux transferer coté Serveur
        intentAnnonceService.putExtra("nomFonction","findAllAnnonces");

        // startService(nom de ton intent)
        view.startIntentService(intentAnnonceService);

        //Déclaration du listener (receiver)
        MapsAnnonceReceiver mapsAnnonceReceiver = new MapsAnnonceReceiver();
        view.registerListener(mapsAnnonceReceiver);

    }

    public class MapsAnnonceReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            ArrayList<AnnonceDTO> listAnnonceDTOs = intent.getParcelableArrayListExtra("ArrayList<AnnonceDTLO>");
            model.setAnnonceDTOs(listAnnonceDTOs);
            view.initView();
        }
    }

    public MapsAnnonceModel getModel() {
        return model;
    }

}
