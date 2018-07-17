package fr.projeti1.marketplace.server.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;
import fr.projeti1.marketplace.server.DAO.ParticulierDAO;
import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.entity.Particulier;


public class ParticulierService extends IntentService {

    private ParticulierDAO particulierDAO;

    public ParticulierService() {
        super("particulier");
    }

    public void onCreate(){super.onCreate();}

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        particulierDAO = AppDataBase.getAppDatabase(getApplicationContext()).getParticulierDAO();
        String nomFonction = intent.getStringExtra("nomFonction");
        switch (nomFonction){
            case "creerParticulier":
                ParticulierDTO particulierDTO = (ParticulierDTO) intent.getParcelableExtra("particulierDTO");
                creerParticulier(particulierDTO);
        }

    }

    public void creerParticulier(ParticulierDTO particulierDTO){

        // insert en base:
        particulierDAO = AppDataBase.getAppDatabase(getApplicationContext()).getParticulierDAO();
        Particulier particulier = entityFromDTO(particulierDTO);
        particulierDAO.insertParticulier(particulier);

        //
        Intent reponseIntent = new Intent();
        reponseIntent.putExtra("idParticulier", particulier.getId());
        sendBroadcast(reponseIntent);
    }

    /*
     *  Permet de convertir une Annonce DTO en entité Annonce
     */
    public static Particulier entityFromDTO(ParticulierDTO particulierDTO){

        Particulier particulier = new Particulier();

        particulier.setId(particulierDTO.getId());
        particulier.setNom(particulierDTO.getNomClient());
        particulier.setPrenom(particulierDTO.getPrenomClient());
        particulier.setDateNaissance(particulierDTO.getDateNaissance());
        particulier.setNumero(particulierDTO.getNumeroClient());
        particulier.setAdresse(particulierDTO.getAdresse());
        particulier.setCodePostal(particulierDTO.getCodePostal());
        particulier.setVille(particulierDTO.getVille());
        particulier.setNumeroTel(particulierDTO.getNumeroTelephone());
        particulier.setMail(particulierDTO.getMail());
        particulier.setMotDePasse(particulierDTO.getMotDePasse());

        return particulier;

    }


}
