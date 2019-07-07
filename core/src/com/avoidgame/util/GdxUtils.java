package com.avoidgame.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GdxUtils {

    public static void clearScreen() {
        // clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    private GdxUtils(){}


}
