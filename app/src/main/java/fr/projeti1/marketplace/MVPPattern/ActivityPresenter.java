package fr.projeti1.marketplace.MVPPattern;

public class ActivityPresenter implements ActivityContract.Presenter{

    protected Activity mView;
    protected ActivityModel mModel;

    public ActivityPresenter(Activity view){
        mView = view;
        initPresenter();
    }

    private void initPresenter(){
        mModel = new ActivityModel();
        mView.initView();
    }

    @Override
    public void onClick(android.view.View view){
        mView.bind();
    }

    public ActivityModel getModel() {
        return mModel;
    }
}
