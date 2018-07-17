package fr.projeti1.marketplace.server.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import fr.projeti1.marketplace.interfaceS.DTO.AvisDTO;
import fr.projeti1.marketplace.server.DAO.AnnonceDAO;
import fr.projeti1.marketplace.server.DAO.AvisDAO;
import fr.projeti1.marketplace.server.DAO.ParticulierDAO;
import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.entity.Avis;

public class AvisService extends IntentService{

    private AvisDAO avisDAO;
    private ParticulierDAO particulierDAO;
    private AnnonceDAO annonceDAO;

    public AvisService(){ super("avis");}

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        avisDAO = AppDataBase.getAppDatabase(getApplicationContext()).getAvisDAO();
        String nomFonction = intent.getStringExtra("nomFonction");
        switch (nomFonction){
            case "creerAvis":

            case "findAllAvis":

        }
    }

    public void creerAvis(AvisDTO avisDTO){
        avisDAO = AppDataBase.getAppDatabase(getApplicationContext()).getAvisDAO();
        Avis avis = entityFromDTO(avisDTO);
        avisDAO.insertAvis(avis);

        Intent reponseIntent = new Intent();
        reponseIntent.putExtra("idAvis", avis.getIdAvis());
        sendBroadcast(reponseIntent);

    }

    public static Avis entityFromDTO(AvisDTO avisDTO){

        Avis avis = new Avis();

        avis.setIdAvis(avisDTO.getId());
        avis.setDescriptionAvis(avisDTO.getDescriptionAvis());
        avis.setNumero(avisDTO.getNumAvis());
        avis.setNotePrestation(avisDTO.getNotePrestation());

        return avis;
    }
}
