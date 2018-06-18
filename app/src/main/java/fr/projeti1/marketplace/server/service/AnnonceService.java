package fr.projeti1.marketplace.server.service;

import android.arch.persistence.room.RoomDatabase;

import java.util.List;

import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.server.DAO.AnnonceDAO;
import fr.projeti1.marketplace.server.entity.Annonce;

//Singleton
public class AnnonceService {

    /*private AnnonceDAO dao;

    public List<AnnonceDTO> rechercherAnnonces(){
        List<Annonce> annonces = dao.getAnnonces();

        for (Annonce annonce : annonces){
            annonce.getAdresse();
            AnnonceDTO dto = entityVersDTO(annonce);
        }

        return annonceDTOs;
    }


    getOnebyId(Long id){
        dao
    }

    modifierAnnonce(){

    }

    private AnnonceDTO entityVersDTO(Annonce entity){
        AnnonceDTO annonceDTO = new AnnonceDTO();
        annonceDTO.setDescription(entity.getDescription());

        // Tous les
    }

    private Annonce DTOVersEntity(AnnonceDTO entity){

    }*/
}
