package com.yorukage.kingsandqueens.elements;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.yorukage.kingsandqueens.interfaces.Touchable;
import com.yorukage.kingsandqueens.scenes.Scene;

/**
 * Created by Yorukage on 15/08/2017.
 */

public class Rectangle extends Element {
    private int x;
    private int y;
    private int width;
    private int height;
    private int color;
    public Rectangle(Scene scene, int x, int y, int width, int height) {
        super(scene);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        color = Color.WHITE;
    }

    public Rectangle(Scene scene, int x, int y, int width, int height, int color) {
        super(scene);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        paint.setColor(color);
        canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
    }

    @Override
    public void update() {
        super.update();
    }
}
