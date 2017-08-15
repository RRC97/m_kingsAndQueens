package com.yorukage.kingsandqueens.scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.yorukage.kingsandqueens.elements.Element;
import com.yorukage.kingsandqueens.interfaces.Touchable;
import com.yorukage.kingsandqueens.managers.SceneManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yorukage on 15/08/2017.
 */

public abstract class Scene {
    private List<Element> elements;
    private Map<String, Integer> names;
    private SceneManager manager;
    public Scene() {
        elements = new ArrayList<>();
        names = new HashMap<>();
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void addElement(String name, Element element) {
        elements.add(element);
        int index = elements.indexOf(element);

        names.put(name, index);
    }

    public Element getElement(int index) {
        return elements.get(index);
    }
    public Element getElement(String name) {
        return elements.get(names.get(name));
    }

    public Element removeElement(int index) {
        return elements.remove(index);
    }
    public Element removeElement(String name) {
        return elements.remove((int) names.get(name));
    }

    public void setManager(SceneManager manager) {
        this.manager = manager;
    }

    public SceneManager getManager() {
        return manager;
    }

    private Element[] getElements() {

        Object[] elements = this.elements.toArray();
        Element[] result = new Element[elements.length];

        for(int i = 0; i < elements.length; i++) {
            result[i] = (Element) elements[i];
        }

        return result;
    }

    public void draw(Canvas canvas) {
        Element[] arrayElements = getElements();

        onDraw(canvas);

        for(Element element : arrayElements) {
            element.draw(canvas);
        }


    }

    public void update() {
        Element[] arrayElements = getElements();

        onUpdate();

        for(Element element : arrayElements) {
            element.update();
        }
    }
    public void touch(MotionEvent event) {
        Element[] arrayElements = getElements();

        for(Element element : arrayElements) {
            if (Touchable.class.isInstance(element)) {
                Touchable touchable = (Touchable) element;

                touchable.touch(event);
            }
        }
    }

    public abstract void init();
    public abstract void onDraw(Canvas canvas);
    public abstract void onUpdate();
}
