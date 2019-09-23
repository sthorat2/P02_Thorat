package com.android.circle;

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
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
    }

    /*public static void increaseWidth(){
        paint = new Paint();
        int inc = random.nextInt(8);
        paint.setStrokeWidth(inc);
        paint.setStyle(Paint.Style.STROKE);

    }*/

    public static void fill(){
        paint = new Paint();

        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        int color = Color.rgb(red,green,blue);
        paint.setColor(color);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);

    }
    public static void unfill(){
        paint = new Paint();
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        int color = Color.rgb(red,green,blue);
        paint.setColor(color);

    }

    public void setCircle(float x, float y, float radius, Path.Direction dir){
        path.reset();
        path.addCircle(x, y, radius, dir);
    }

    public Path getPath(){
        return path;
    }

    public Paint getPaint(){
        return paint;
    }

}
