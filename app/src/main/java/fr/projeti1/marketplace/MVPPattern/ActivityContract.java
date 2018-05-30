package fr.projeti1.marketplace.MVPPattern;

public interface ActivityContract {

    interface View{

        void initView();

        void setViewData(String data);
    }

    interface Model {

        String getData();
    }

    interface Presenter{

        void onClick(android.view.View view);
    }
}
