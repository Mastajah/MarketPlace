package fr.projeti1.marketplace.client.MVPPattern;

public class ActivityModel implements ActivityContract.Model{
    @Override
    public String getData() {
        return "Hello World";
    }
}
