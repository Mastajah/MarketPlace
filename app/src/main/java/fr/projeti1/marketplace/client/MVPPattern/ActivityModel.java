package fr.projeti1.marketplace.client.MVPPattern;

import java.util.TreeSet;

public class ActivityModel{

    private TreeSet<String> errorMessages = new TreeSet<String>();

    private TreeSet<String> infoMessages = new TreeSet<String>();

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
