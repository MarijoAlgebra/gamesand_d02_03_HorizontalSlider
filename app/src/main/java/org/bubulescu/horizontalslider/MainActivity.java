package org.bubulescu.horizontalslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private HorizontalSlider horizontalSlider;
    private TextView tvProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        horizontalSlider = findViewById(R.id.hsSlider);
        tvProgress = findViewById(R.id.tvProgress);
    }

    private void setupListeners() {
        horizontalSlider.setOnProgressChangeListeners(new OnProgressChangeListener() {
            @Override
            public void onProgressChange(View view, int progress) {
                tvProgress.setText(progress + "%");
            }
        });
    }
}
