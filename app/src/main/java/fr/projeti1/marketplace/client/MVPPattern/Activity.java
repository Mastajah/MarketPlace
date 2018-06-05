package fr.projeti1.marketplace.client.MVPPattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.ActivityContract.View;

public abstract class Activity<P extends ActivityContract.PresenterCallBack<? extends ActivityModel>> extends AppCompatActivity implements View<P>{

    protected P presenter;
    private TextView mTextView;
    private Button mButton;

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
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                presenter.onClick(view);
            }
        });
    }

    @Override
    public void bind() {
        mTextView.setText("Test");
    }

    @Override
    public void flush() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
