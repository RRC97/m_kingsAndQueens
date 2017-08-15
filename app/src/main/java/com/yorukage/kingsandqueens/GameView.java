package com.yorukage.kingsandqueens;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.yorukage.kingsandqueens.controllers.SceneController;
import com.yorukage.kingsandqueens.managers.SceneManager;

/**
 * Created by Yorukage on 15/08/2017.
 */

public class GameView extends View implements Runnable {

    private GameActivity activity;
    private SceneManager sceneManager;
    private Handler handler;
    public GameView(GameActivity gameActivity) {
        super(gameActivity);
        activity = gameActivity;
        SceneManager.setContext(activity);

        SceneManager manager = SceneManager.getInstance();
        SceneController controller = new SceneController(manager);

        manager.addScenes(controller.getScenes());
        manager.setScene(0);

        handler = new Handler();
        handler.postDelayed(this, 1000 / 60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        SceneManager.getInstance().draw(canvas);
    }

    public void onUpdate() {
        SceneManager.getInstance().update();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SceneManager.getInstance().touch(event);

        return true;
    }

    @Override
    public void run() {

        onUpdate();
        invalidate();

        handler.postDelayed(this, 1000 / 60);
    }
}
