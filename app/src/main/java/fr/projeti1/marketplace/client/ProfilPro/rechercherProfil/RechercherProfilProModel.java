package fr.projeti1.marketplace.client.ProfilPro.rechercherProfil;

import android.content.pm.ActivityInfo;

import java.util.List;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;

public class RechercherProfilProModel extends ActivityModel {

    private List<ProfilProDTO> profilProDTOs;

    public List<ProfilProDTO> getProfilProDTOs() {
        return profilProDTOs;
    }

    public void setProfilProDTOs(List<ProfilProDTO> profilProDTOs) {
        this.profilProDTOs = profilProDTOs;
    }
}
