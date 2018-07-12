package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;

public class ModifierAnnonceModel extends ActivityModel {
    private AnnonceDTO annonceDTO;
    private ParticulierDTO particulierDTO;

    public AnnonceDTO getAnnonceDTO() {
        return annonceDTO;
    }

    public void setAnnonceDTO(AnnonceDTO annonceDTO) {
        this.annonceDTO = annonceDTO;
    }

    public ParticulierDTO getParticulierDTO() {
        return particulierDTO;
    }

    public void setParticulierDTO(ParticulierDTO particulierDTO) {
        this.particulierDTO = particulierDTO;
    }
}
