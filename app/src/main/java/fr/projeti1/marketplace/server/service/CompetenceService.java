package fr.projeti1.marketplace.server.service;

import android.app.IntentService;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import fr.projeti1.marketplace.interfaceS.DTO.CompetenceDTO;
import fr.projeti1.marketplace.server.DAO.CompetenceDAO;
import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.entity.Competence;

public class CompetenceService extends IntentService {
    private CompetenceDAO competenceDAO;

    public CompetenceService() {
        super("competence");
    }

    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Récupération des DAO
        competenceDAO = AppDataBase.getAppDatabase(getApplicationContext()).getCompetenceDAO();

        //Appel de la fonction en fonction de l'extra
        String nomFonction = intent.getStringExtra("nomFonction");
        CompetenceDTO competenceDTO;
        switch (nomFonction){
            case "creerCompetence":
                competenceDTO = (CompetenceDTO) intent.getSerializableExtra("competenceDTO");
                creerCompetence(competenceDTO);
            case "creerListCompetence":
                ArrayList<CompetenceDTO> competenceDTOs = intent.getParcelableArrayListExtra("competenceDTOs");
                creerListCompetence(competenceDTOs);
            case "supprimerCompetence":
                competenceDTO = (CompetenceDTO) intent.getSerializableExtra("competenceDTO");
                supprimerCompetence(competenceDTO);
            case "findAllCompetences":
                findAllCompetences();
        }

    }

    /*
     * Créer une competence
     */
    private void creerCompetence(CompetenceDTO competenceDTO){
        // Insertion en base
        Competence competence = entityFromDTO(competenceDTO);
        competenceDAO.insertCompentence(competence);
    }

    /*
     * Créer une liste competence
     */
    private void creerListCompetence(List<CompetenceDTO> competenceDTOs){
        // Insertion en base
        for(CompetenceDTO dto : competenceDTOs){
            Competence competence = entityFromDTO(dto);
            competenceDAO.insertCompentence(competence);
        }

    }

    /*
     * Supprime une competence
     */
    private void supprimerCompetence(CompetenceDTO competenceDTO){
        // Insertion en base
        Competence competence = entityFromDTO(competenceDTO);
        competenceDAO.supprimerCompentence(competence);
    }

    /*
     * Retourne une liste de competence
     */
    private void findAllCompetences(){
        ArrayList<CompetenceDTO> competenceDTOs = new ArrayList<CompetenceDTO>();
        for(Competence competence : competenceDAO.getCompentences()){
            CompetenceDTO competenceDTO = DTOFromEntity(competence);
            competenceDTOs.add(competenceDTO);
        }

        Intent reponseIntent = new Intent();
        reponseIntent.putParcelableArrayListExtra("competencesList", competenceDTOs);
        sendBroadcast(reponseIntent);
    }

    /*
     *  Permet de convertir une CompetenceDTO en entité Competence
     */
    public static CompetenceDTO DTOFromEntity(Competence competence){
        CompetenceDTO competenceDTO = new CompetenceDTO();
        competenceDTO.setIdComp(competence.getIdComp());
        competenceDTO.setDescription(competence.getDescription());
        competenceDTO.setLibelle(competence.getLibelle());

        return competenceDTO;
    }

    /*
     *  Permet de convertir une entité Competence en competenceDTO
     */
    public static Competence entityFromDTO(CompetenceDTO competenceDTO){
        Competence competence = new Competence();
        competence.setIdComp(competenceDTO.getIdComp());
        competence.setDescription(competenceDTO.getDescription());
        competence.setLibelle(competenceDTO.getLibelle());

        return competence;
    }
}
