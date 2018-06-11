package fr.projeti1.marketplace.client.MVPPattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.ActivityContract.Display;

public abstract class Activity<P extends ActivityContract.PresenterCallBack<? extends ActivityModel>> extends AppCompatActivity implements Display<P> {

    protected P presenter;

    @Override
    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
    }

    @Override
    public void initView() {

    }

    @Override
    public void bind() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
