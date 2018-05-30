package fr.projeti1.marketplace.MVPPattern;

public class ActivityModel implements ActivityContract.Model{
    @Override
    public String getData() {
        return "Hello World";
    }
}
