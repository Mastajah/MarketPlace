package fr.projeti1.marketplace.server.service;

import android.app.IntentService;
import android.content.Intent;

import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.server.DAO.AnnonceDAO;
import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.entity.Annonce;

//Singleton
public class AnnonceService extends IntentService {

    private AnnonceDAO dao;

    public AnnonceService() {
        super("annonce");
    }

    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String nomFonction = intent.getStringExtra("nomFonction");

        switch (nomFonction){
            case "creerAnnonce":
                AnnonceDTO annonceDTO = (AnnonceDTO) intent.getSerializableExtra("annonceDTO");
                creerAnnonce(annonceDTO);
        }
    }

    public void creerAnnonce (AnnonceDTO annonceDTO){
        // Insertion en base
        dao = AppDataBase.getAppDatabase(getApplicationContext()).getAnnonceDAO();
        Annonce annonce = entityFromDTO(annonceDTO);
        dao.insertAnnonce(annonce);

        // Retour de l'id au presenter grace à l'intent
        Intent reponseIntent = new Intent();
        reponseIntent.putExtra("idAnnonce",annonce.getIdAnnonce());
        sendBroadcast(reponseIntent);
    }

    public void modifierAnnonce(){

    }

    /*
     *  Permet de convertir une Annonce DTO en entité Annonce
     */
    private Annonce entityFromDTO(AnnonceDTO dto){
        Annonce annonce = new Annonce();

        annonce.setNumeroAnnonce(dto.getNumeroAnnonce());
        annonce.setTitre(dto.getTitre());
        annonce.setDescription(dto.getDescription());
        annonce.setAdresse(String.valueOf(dto.getNumVoie()) + dto.getRue());
        annonce.setCodePostal(dto.getCodePostale());
        annonce.setVille(dto.getVille());

        // Long + lat + les autres
        // Il faut convertir le DTO
        //annonce.setParticulier(dto.getParticulierDTO());

        return annonce;
    }


}
