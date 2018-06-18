package fr.projeti1.marketplace.client.Avis.ModifierAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.AvisDTO;

public class ModifierAvisModel extends ActivityModel{
    private AvisDTO modifyAvisDTO;

    public ModifierAvisModel(){super();}

    public AvisDTO getModifyAvisDTO() {
        return modifyAvisDTO;
    }

    public void setModifyAvisDTO(AvisDTO modifyAvisDTO) {
        this.modifyAvisDTO = modifyAvisDTO;
    }
}
