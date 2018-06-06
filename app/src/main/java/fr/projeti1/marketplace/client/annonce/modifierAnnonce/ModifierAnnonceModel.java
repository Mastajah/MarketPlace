package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityModel;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ClientDTO;

public class ModifierAnnonceModel extends ActivityModel {
    private AnnonceDTO annonceDTO;
    private ClientDTO clientDTO;

    public AnnonceDTO getAnnonceDTO() {
        return annonceDTO;
    }

    public void setAnnonceDTO(AnnonceDTO annonceDTO) {
        this.annonceDTO = annonceDTO;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }
}
