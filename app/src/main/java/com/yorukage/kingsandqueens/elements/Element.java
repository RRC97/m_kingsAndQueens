package com.yorukage.kingsandqueens.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.yorukage.kingsandqueens.scenes.Scene;

/**
 * Created by Yorukage on 15/08/2017.
 */

public class Element {

    protected Paint paint;

    public Element(Scene scene) {
        paint = new Paint();
    }

    public void draw(Canvas canvas) {

    }

    public void update() {

    }
}
