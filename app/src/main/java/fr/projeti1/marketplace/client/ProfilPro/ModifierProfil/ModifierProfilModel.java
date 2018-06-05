package fr.projeti1.marketplace.client.ProfilPro.ModifierProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;

public class ModifierProfilModel extends ActivityModel{
    private ProfilProDTO modifyProfilProDTO;

    public ModifierProfilModel(){
        super();
    }

    public ProfilProDTO getModifyProfilProDTO() {
        return modifyProfilProDTO;
    }

    public void setModifyProfilProDTO(ProfilProDTO modifyProfilProDTO) {
        this.modifyProfilProDTO = modifyProfilProDTO;
    }
}
