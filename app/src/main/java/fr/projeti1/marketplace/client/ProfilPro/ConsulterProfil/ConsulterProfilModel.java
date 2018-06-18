package fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;

public class ConsulterProfilModel extends ActivityModel {

    private ProfilProDTO consultProfilProDTO;

    public ConsulterProfilModel(){
        super();
    }

    public ProfilProDTO getConsultProfilProDTO() {
        return consultProfilProDTO;
    }

    public void setConsultProfilProDTO(ProfilProDTO consultProfilProDTO) {
        this.consultProfilProDTO = consultProfilProDTO;
    }
}
