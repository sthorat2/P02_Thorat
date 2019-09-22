package com.android.polygon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View{

    CustomShape customShape;
    float ratioRadius;
    int numberOfPoint = 3;

    public CustomView(Context context) {
        super(context);
        initCustomView();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCustomView();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCustomView();
    }
    public void initCustomView(){

        customShape = new CustomShape();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        if((width==0) || (height==0)){
            return;
        }

        float x = (float)width/2.0f;
        float y = (float)height/2.0f;
        float radius;
        if(width > height){
            radius = height * ratioRadius;
        }else{
            radius = width * ratioRadius;
        }

        customShape.setPolygon(x, y, radius, numberOfPoint);
        canvas.drawPath(customShape.getPath(), customShape.getPaint());
    }

    public void setShapeRadiusRatio(float ratio){

        ratioRadius = ratio;
    }

    public void setNumberOfPoint(int point){
        numberOfPoint = point;
    }
}
