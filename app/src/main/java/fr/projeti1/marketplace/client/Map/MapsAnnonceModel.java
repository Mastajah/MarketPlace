package fr.projeti1.marketplace.client.Map;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class MapsAnnonceModel{

    private TreeSet<String> errorMessages = new TreeSet<String>();
    private TreeSet<String> infoMessages = new TreeSet<String>();
    private ArrayList<AnnonceDTO> annonceDTOs;

    public ArrayList<AnnonceDTO> getAnnonceDTOs() {
        return annonceDTOs;
    }

    public void setAnnonceDTOs(ArrayList<AnnonceDTO> annonceDTOs) {
        this.annonceDTOs = annonceDTOs;
    }

    public TreeSet<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(TreeSet<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public TreeSet<String> getInfoMessages() {
        return infoMessages;
    }

    public void setInfoMessages(TreeSet<String> infoMessages) {
        this.infoMessages = infoMessages;
    }

}
