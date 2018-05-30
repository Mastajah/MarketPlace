package fr.projeti1.marketplace.MVPPattern;

import fr.projeti1.marketplace.MVPPattern.ActivityContract.View;
import fr.projeti1.marketplace.MVPPattern.ActivityContract.Model;

public class ActivityPresenter implements ActivityContract.Presenter{

    private View mView;
    private Model mModel;

    public ActivityPresenter(View view){
        mView = view;
        initPresenter();
    }

    private void initPresenter(){
        mModel = new ActivityModel();
        mView.initView();
    }

    @Override
    public void onClick(android.view.View view){
        String data = mModel.getData();
        mView.setViewData(data);
    }
}
