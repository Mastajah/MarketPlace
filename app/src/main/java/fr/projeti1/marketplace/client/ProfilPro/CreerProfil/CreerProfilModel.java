package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;

public class CreerProfilModel extends ActivityModel {
    private ProfilProDTO createProfilProDTO;

    public CreerProfilModel(){
        super();
    }

    public ProfilProDTO getCreateProfilProDTO() {
        return createProfilProDTO;
    }

    public void setCreateProfilProDTO(ProfilProDTO createProfilProDTO) {
        this.createProfilProDTO = createProfilProDTO;
    }
}
