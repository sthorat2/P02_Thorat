package com.android.polygon;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar radiusBar;
    CustomView customView;

    SeekBar pointBar;
    TextView textPoint;
    final static int MIN_PT =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiusBar = (SeekBar) findViewById(R.id.radiusbar);
        customView = (CustomView) findViewById(R.id.customview);
        float defaultRatio = (float) (radiusBar.getProgress()) / (float) (radiusBar.getMax());
        customView.setShapeRadiusRatio(defaultRatio);
        radiusBar.setOnSeekBarChangeListener(radiusBarOnSeekBarChangeListener);

        textPoint =(TextView) findViewById(R.id.pointtext);
        pointBar = (SeekBar) findViewById(R.id.pointbar);
        pointBar.setOnSeekBarChangeListener(pointBarOnSeekBarChangeListener);
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


    OnSeekBarChangeListener pointBarOnSeekBarChangeListener =
            new OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    int point = progress + MIN_PT;
                    textPoint.setText("number of point in polygon: " + String.valueOf(point));
                    customView.setNumberOfPoint(point);
                    customView.invalidate();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}

            };

}

