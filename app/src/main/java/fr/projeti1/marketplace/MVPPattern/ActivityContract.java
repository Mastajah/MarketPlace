package fr.projeti1.marketplace.MVPPattern;

public interface ActivityContract {

    interface View{

        void initView();

        void bind();

        void flush();
    }

    interface Model {

        String getData();
    }

    interface Presenter{

        void onClick(android.view.View view);
    }
}
