package com.example.reueljohn.surfaceviewexample;

/**
 * Created by reueljohn on 18/12/2017.
 */

public class FlashLightCone {

    private int mX, mY, mRadius;

    public FlashLightCone(int viewWidth, int viewHeight){
        mX = viewWidth/2;
        mY = viewHeight/2;

        mRadius = ((viewWidth <= viewHeight) ? mX / 3 : mY /3 );
    }

    public void update(int newX, int newY){
        mX = newX;
        mY = newY;
    }

    public int getmX() {
        return mX;
    }

    public int getmY() {
        return mY;
    }

    public int getmRadius() {
        return mRadius;
    }
}
