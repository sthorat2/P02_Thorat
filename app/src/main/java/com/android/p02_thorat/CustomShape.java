package com.android.p02_thorat;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.Random;

public class CustomShape {

    private static Paint paint;
    private Path path;

    public static final Random random = new Random();

    public CustomShape() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
    }

    public static void  changeColor(){
        paint = new Paint();

        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        int color = Color.rgb(red,green,blue);
        paint.setColor(color);

    }

    public static void fill(){
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

    }
    public static void unfill(){
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

    }

    public void setCircle(float x, float y, float radius, Path.Direction dir){
        path.reset();
        path.addCircle(x, y, radius, dir);
    }

    public void setPolygon(float x, float y, float radius, int numOfPoint){

        double section = 2.0 * Math.PI/numOfPoint;

        path.reset();
        path.moveTo(
                (float)(x + radius * Math.cos(0)),
                (float)(y + radius * Math.sin(0)));

        for(int i=1; i<numOfPoint; i++){
            path.lineTo(
                    (float)(x + radius * Math.cos(section * i)),
                    (float)(y + radius * Math.sin(section * i)));
        }

        path.close();

    }

    public Path getPath(){

        return path;
    }

    public Paint getPaint(){

        return paint;
    }

}
