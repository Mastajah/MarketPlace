package fr.projeti1.marketplace.client.annonce.listeAnnonce;

import java.util.List;

import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class RechercherAnnonceModel {

    private List<AnnonceDTO> annonceDTOs;

    public List<AnnonceDTO> getAnnonceDTOs() {
        return annonceDTOs;
    }

    public void setAnnonceDTOs(List<AnnonceDTO> annonceDTOs) {
        this.annonceDTOs = annonceDTOs;
    }
}
