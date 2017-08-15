package com.yorukage.kingsandqueens.controllers;

import com.yorukage.kingsandqueens.managers.SceneManager;
import com.yorukage.kingsandqueens.scenes.Scene;
import com.yorukage.kingsandqueens.scenes.TestScene;

/**
 * Created by Yorukage on 15/08/2017.
 */

public class SceneController {
    private Class<? extends Scene>[] scenes;
    public SceneController(SceneManager sceneManager) {
        scenes = new Class[0];

        //COLOQUE AQUI TODAS AS CLASSES DAS CENAS UTILIZADAS EM ORDEM NUMÉRICA
        addSceneClass(TestScene.class);
    }

    public Class<? extends Scene>[] getScenes() {
        return scenes;
    }

    private void addSceneClass(Class<? extends Scene> sceneClass) {
        Class<? extends Scene>[] temp = scenes.clone();
        scenes = new Class[temp.length + 1];

        for (int i = 0; i < temp.length; i++) {
            scenes[i] = temp[i];
        }

        scenes[temp.length] = sceneClass;
    }
}
