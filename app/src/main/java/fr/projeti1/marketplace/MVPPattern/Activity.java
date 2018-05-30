package fr.projeti1.marketplace.MVPPattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import fr.projeti1.marketplace.MVPPattern.ActivityContract.Presenter;
import fr.projeti1.marketplace.MVPPattern.ActivityContract.View;

import fr.projeti1.marketplace.R;

public class Activity extends AppCompatActivity implements View {

    private TextView mTextView;
    private Button mButton;
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        mPresenter = new ActivityPresenter(this);
    }

    @Override
    public void initView() {
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                mPresenter.onClick(view);
            }
        });
    }

    @Override
    public void setViewData(String data) {
        mTextView.setText(data);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
