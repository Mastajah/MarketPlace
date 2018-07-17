package fr.projeti1.marketplace.server.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.server.DAO.AnnonceDAO;
import fr.projeti1.marketplace.server.DAO.CompetenceDAO;
import fr.projeti1.marketplace.server.DAO.ParticulierDAO;
import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.entity.Competence;

public class AnnonceService extends IntentService {

    private AnnonceDAO annonceDAO;
    private CompetenceDAO competenceDAO;
    private ParticulierDAO particulierDAO;

    public AnnonceService() {
        super("annonce");
    }

    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Récupération des DAO
        annonceDAO = AppDataBase.getAppDatabase(getApplicationContext()).getAnnonceDAO();
        competenceDAO = AppDataBase.getAppDatabase(getApplicationContext()).getCompetenceDAO();
        particulierDAO = AppDataBase.getAppDatabase(getApplicationContext()).getParticulierDAO();

        //Appel de la fonction en fonction de l'extra
        String nomFonction = intent.getStringExtra("nomFonction");

        switch (nomFonction){
            case "creerAnnonce":
                AnnonceDTO annonceDTO = (AnnonceDTO) intent.getParcelableExtra("annonceDTO");
                creerAnnonce(annonceDTO);
            case "findAllAnnonces":
                findAllAnnonces();
        }

    }

    /*
     * Créer une annonce
     */
    public void creerAnnonce(AnnonceDTO annonceDTO){
        // Insertion en base

        annonceDAO = AppDataBase.getAppDatabase(getApplicationContext()).getAnnonceDAO();
        Annonce annonce = entityFromDTO(annonceDTO);
        insertAnnonceWithCompetences(annonce);

        // Retour de l'id au presenter grace à l'intent
        Intent reponseIntent = new Intent();
        reponseIntent.putExtra("idAnnonce",annonce.getIdAnnonce());
        sendBroadcast(reponseIntent);
    }

    /*
     * Modifie une annonce en base
     */
    public void modifierAnnonce(){

    }

    /*
     * Récupère toutes les annonces
     */
    public void findAllAnnonces(){
        annonceDAO = AppDataBase.getAppDatabase(getApplicationContext()).getAnnonceDAO();
        ArrayList<AnnonceDTO> annonceDTOList = new ArrayList<AnnonceDTO>();

        for (Annonce annonce : annonceDAO.getAnnonces()){
            annonceDTOList.add(DTOFromEntity(annonce));
        }

        // Retour de l'id au presenter grace à l'intent
        Intent reponseIntent = new Intent();
        reponseIntent.putParcelableArrayListExtra("annonceList", annonceDTOList);
        sendBroadcast(reponseIntent);
    }

    /*
     * Ajoute en base une annonce en associant les compétences de l'annonce
     */
    private void insertAnnonceWithCompetences(Annonce annonce){
        List<Competence> competences = annonce.getCompetence();
        for(Competence competence : competences){
            competence.setIdAnnonce(annonce.getIdAnnonce());
        }
        competenceDAO.insertAll(competences);
        annonceDAO.insertAnnonce(annonce);
    }

    /*
     * Récupère les annonces avec les compétences associées
     */
    private Annonce getAnnonceWithCompetencesById(Long id){
        Annonce annonce = annonceDAO.findById(id);
        List<Competence> competences = competenceDAO.getCompetencesByAnnonce(id);
        annonce.setCompetence(competences);
        return annonce;
    }

    /*
     *  Permet de convertir une Annonce DTO en entité Annonce
     */
    public static Annonce entityFromDTO(AnnonceDTO dto){
        Annonce annonce = new Annonce();

        annonce.setIdAnnonce(dto.getId());
        annonce.setNumeroAnnonce(dto.getNumeroAnnonce());
        annonce.setTitre(dto.getTitre());
        annonce.setDescription(dto.getDescription());
        annonce.setAdresse(dto.getAdresse());
        annonce.setCodePostal(dto.getCodePostale());
        annonce.setVille(dto.getVille());
        annonce.setLongitude(dto.getLongitude());
        annonce.setLatitude(dto.getLatitude());
        annonce.setDateCreation(dto.getDateCreation());
        annonce.setDateCloture(dto.getDateCloture());
        annonce.setStatut(dto.getStatut());
        // annonce.setidParticulier(dto.getParticulierDTO().getId());
        // annonce.setCompetence(CompetenceService.entityFromDTO(dto.getCompetenceDTOs());

        return annonce;
    }

    /*
     *  Permet de convertir une entité Annonce en AnnonceDTO
     */
    public static AnnonceDTO DTOFromEntity(Annonce annonce){

        AnnonceDTO annonceDTO = new AnnonceDTO();

        annonceDTO.setId(annonce.getIdAnnonce());
        annonceDTO.setNumeroAnnonce(annonce.getNumeroAnnonce());
        annonceDTO.setTitre(annonce.getTitre());
        annonceDTO.setDescription(annonce.getDescription());
        annonceDTO.setAdresse(annonce.getAdresse());
        annonceDTO.setVille(annonce.getVille());
        annonceDTO.setCodePostale(annonce.getCodePostal());
        annonceDTO.setLongitude(annonce.getLongitude());
        annonceDTO.setLatitude(annonce.getLatitude());
        annonceDTO.setDateCloture(annonce.getDateCloture());
        annonceDTO.setDateCreation(annonce.getDateCreation());
        annonceDTO.setStatut(annonce.getStatut());
        // annonceDTO.setParticulierDTO(ParticulierService.DTOFromEntity(particulierDAO.findById(annonce.getIdParticulier())));
        // annonceDTO.setCompetenceDTOs(CompetenceService.DTOFromEntity(annonce.getCompetence()));

         return annonceDTO;
    }

}
