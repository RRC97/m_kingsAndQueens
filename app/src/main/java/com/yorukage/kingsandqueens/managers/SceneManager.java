package com.yorukage.kingsandqueens.managers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.yorukage.kingsandqueens.scenes.Scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yorukage on 15/08/2017.
 */

public class SceneManager {
    private Context context;
    private int width;
    private int height;
    private Scene current;
    private List<Class<? extends Scene>> scenes;
    public SceneManager(Context context) {
        this.context = context;

        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;

        scenes = new ArrayList<>();
    }

    public boolean prev() {
        int index = scenes.indexOf(current.getClass());

        if(index - 1 >= 0) {

            this.setScene(index - 1);

            return true;
        }

        return false;
    }

    public boolean next() {
        int index = scenes.indexOf(current.getClass());

        if(index + 1 < scenes.size()) {

            this.setScene(index + 1);

            return true;
        }

        return false;
    }

    public void addScene(Class<? extends Scene> scene) {
        scenes.add(scene);
    }

    public void addScenes(Class<? extends Scene>[] scenes) {
        for(Class<? extends Scene> scene : scenes) {
            addScene(scene);
        }
    }

    public void setScene(int index) {
        try {
            current = scenes.get(index).newInstance();
            current.setManager(this);
            current.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getCurrentScene() {
        return current;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(Canvas canvas) {

        if(current != null) {
            current.draw(canvas);
        }
    }

    public void update() {
        if(current != null) {
            current.update();
        }
    }

    public void touch(MotionEvent event) {
        if(current != null) {
            current.touch(event);
        }
    }

    //GLOBAL
    private static SceneManager instance;

    public static void setContext(Context context) {
        instance = new SceneManager(context);
    }
    public static SceneManager getInstance() {
        return instance;
    }
}
