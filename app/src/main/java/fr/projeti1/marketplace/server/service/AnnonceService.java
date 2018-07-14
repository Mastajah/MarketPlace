package fr.projeti1.marketplace.server.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

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
            case "findAllAnnonces":
                findAllAnnonces();
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

    public void findAllAnnonces(){
        dao = AppDataBase.getAppDatabase(getApplicationContext()).getAnnonceDAO();
        ArrayList<AnnonceDTO> annonceDTOList = new ArrayList<AnnonceDTO>();

        for (Annonce annonce : dao.getAnnonces()){
            annonceDTOList.add(DTOFromEntity(annonce));
        }
        // Retour de l'id au presenter grace à l'intent
        Intent reponseIntent = new Intent();
        reponseIntent.putParcelableArrayListExtra("annonceList", annonceDTOList);
        sendBroadcast(reponseIntent);
    }

    /*
     *  Permet de convertir une Annonce DTO en entité Annonce
     */
    public Annonce entityFromDTO(AnnonceDTO dto){
        Annonce annonce = new Annonce();

        annonce.setNumeroAnnonce(dto.getNumeroAnnonce());
        annonce.setTitre(dto.getTitre());
        annonce.setDescription(dto.getDescription());
        annonce.setAdresse(dto.getAdresse());
        annonce.setCodePostal(dto.getCodePostale());
        annonce.setVille(dto.getVille());

        // Long + lat + les autres
        // Il faut convertir le DTO
        //annonce.setParticulier(ParticulierService.entityFromDTO(dto.getParticulierDTO()));

        return annonce;
    }

    /*
     *  Permet de convertir une entité Annonce en AnnonceDTO
     */
    public AnnonceDTO DTOFromEntity(Annonce annonce){

        AnnonceDTO annonceDTO = new AnnonceDTO();

        annonceDTO.setAdresse(annonce.getAdresse());
        annonceDTO.setVille(annonce.getVille());
        annonceDTO.setCodePostale(annonce.getCodePostal());
        annonceDTO.setDateCloture(annonce.getDateCloture());
        annonceDTO.setDateCreation(annonce.getDateCreation());
        annonceDTO.setDescription(annonce.getDescription());
        annonceDTO.setId(annonce.getIdAnnonce());
        annonceDTO.setNumeroAnnonce(annonce.getNumeroAnnonce());
        //annonceDTO.setParticulierDTO(annonce.getParticulier());

         return annonceDTO;
    }

}
