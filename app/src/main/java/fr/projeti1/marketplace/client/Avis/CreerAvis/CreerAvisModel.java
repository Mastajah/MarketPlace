package fr.projeti1.marketplace.client.Avis.CreerAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.AvisDTO;

public class CreerAvisModel {
     private AvisDTO createAvisDTO;

    public CreerAvisModel(){
        super();
    }

    public AvisDTO getCreateAvisDTO() {
        return createAvisDTO;
    }

    public void setCreateAvisDTO(AvisDTO createAvisDTO) {
        this.createAvisDTO = createAvisDTO;
    }
}
