package fr.projeti1.marketplace.client.MVPPattern;

public interface ActivityContract {

    interface View<P extends PresenterCallBack<? extends ActivityModel>>{

        void setPresenter(P presenterCallback);

        void initView();

        void bind();

        void flush();
    }

    interface PresenterCallBack<M extends ActivityModel> {

        M getModel();
    }
}
