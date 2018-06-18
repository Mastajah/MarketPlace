package fr.projeti1.marketplace.client.Avis.ConsulterAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.AvisDTO;

public class ConsulterAvisModel extends ActivityModel {
    private AvisDTO consultAvisDTO;

    public ConsulterAvisModel() {
        super();
    }

    public AvisDTO getConsultAvisDTO() {
        return consultAvisDTO;
    }

    public void setConsultAvisDTO(AvisDTO consultAvisDTO) {
        this.consultAvisDTO = consultAvisDTO;
    }
}
