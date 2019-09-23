package com.android.circle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SeekBar radiusBar;
    CustomView customView;
    Button fillButton;
    Button emptyButton;
    Button increaseWidthButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  increaseWidthButton = (Button) findViewById(R.id.increaseWidthButton);
        increaseWidthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    CustomShape.increaseWidth();

            }

        });*/
        fillButton = (Button) findViewById(R.id.fillButton);
        fillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomShape.fill();

            }

        });

        emptyButton = (Button) findViewById(R.id.emptyButton);
        emptyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomShape.unfill();

            }

        });



        radiusBar = (SeekBar) findViewById(R.id.radiusbar);
        customView = (CustomView) findViewById(R.id.customview);
        float defaultRatio = (float) (radiusBar.getProgress()) / (float) (radiusBar.getMax());
        customView.setShapeRadiusRatio(defaultRatio);
        radiusBar.setOnSeekBarChangeListener(radiusBarOnSeekBarChangeListener);

    };

    OnSeekBarChangeListener radiusBarOnSeekBarChangeListener = new OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            float defaultRatio = (float) (radiusBar.getProgress()) / (float) (radiusBar.getMax());
            customView.setShapeRadiusRatio(defaultRatio);
            customView.invalidate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };


}
