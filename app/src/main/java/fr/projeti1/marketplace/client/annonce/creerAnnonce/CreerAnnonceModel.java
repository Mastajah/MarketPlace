package fr.projeti1.marketplace.client.annonce.creerAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class CreerAnnonceModel extends ActivityModel{

    private AnnonceDTO annonceDTO;

    public AnnonceDTO getAnnonceDTO() {
        return annonceDTO;
    }

    public void setAnnonceDTO(AnnonceDTO annonceDTO) {
        this.annonceDTO = annonceDTO;
    }
}
