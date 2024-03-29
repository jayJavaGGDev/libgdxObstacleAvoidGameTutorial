package com.avoidgame.screen;

import com.avoidgame.config.GameConfig;
import com.avoidgame.entity.Player;
import com.avoidgame.util.GdxUtils;
import com.avoidgame.util.ViewportUtils;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer renderer;
    private Player player;


    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        /*create player*/
        player = new Player();

        // calculate positions
        float startPlayerX = GameConfig.WORLD_WIDTH /2f;
        float startPlayerY = 1;

        //position player
        player.setPosition(startPlayerX, startPlayerY);
    }

    @Override
    public void render(float delta) {
        GdxUtils.clearScreen();
        renderDebug();
    }

    private void renderDebug() {

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);

        drawDebug();

        renderer.end();
        ViewportUtils.drawGrid(viewport, renderer);
    }

    private void drawDebug() {
        player.drawDebug(renderer);
    }

    @Override
    public void dispose() {
        renderer.dispose();

    }

    @Override
    public void hide() {

        dispose(); // may be good to dispose on hide... maybe not depending on situation

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        ViewportUtils.debugPixelPerUnit(viewport);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
