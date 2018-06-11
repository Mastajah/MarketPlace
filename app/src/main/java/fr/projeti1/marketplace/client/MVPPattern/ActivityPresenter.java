package fr.projeti1.marketplace.client.MVPPattern;

/**
 * Presenter
 *
 * @param <M>
 *      le modele que le presenter retourne
 * @param <V>
 *      l'interface {@link fr.projeti1.marketplace.client.MVPPattern.ActivityContract.Display} associée au présenter
 */
public abstract class ActivityPresenter<M extends ActivityModel, V extends ActivityContract.Display<? extends ActivityContract.PresenterCallBack<M>>> implements ActivityContract.PresenterCallBack<M>{

    /**
     * Le modèle sur lequel le présenteur agit.
     */
    protected M model;

    /**
     * La vue représentant les données du modèle et redirigeant les actions de l'utilisateur.
     */
    protected V view;

    public ActivityPresenter(V view){
        this.view = view;
        initPresenter();
    }

    private void initPresenter(){
        view.initView();
    }

    public M getModel() {
        return model;
    }
}
