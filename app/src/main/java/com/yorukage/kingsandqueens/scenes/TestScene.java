package com.yorukage.kingsandqueens.scenes;

import android.graphics.Canvas;
import android.graphics.Color;

import com.yorukage.kingsandqueens.elements.Rectangle;
import com.yorukage.kingsandqueens.managers.SceneManager;

/**
 * Created by Yorukage on 15/08/2017.
 */

public class TestScene extends Scene {

    private Rectangle background;

    @Override
    public void init() {
        SceneManager manager = getManager();

        int width = manager.getWidth();
        int height = manager.getHeight();

        background = new Rectangle(this, 0, 0, width, height, Color.GRAY);

        Rectangle rect = new Rectangle(this, 100, 100, 100, 100);
        addElement(rect);
    }

    @Override
    public void onDraw(Canvas canvas) {
        background.draw(canvas);
    }

    @Override
    public void onUpdate() {

    }
}
