package io.github.melqqeuy.rectangles;

import io.github.melqqeuy.engine.CanvasPaintListener;
import io.github.melqqeuy.engine.GameCanvas;
import io.github.melqqeuy.engine.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RectanglesWindow extends JFrame implements CanvasPaintListener {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int START_BALLS_COUNT = 1;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RectanglesWindow();
            }
        });
    }

    private GameObject[] gameObjects = new GameObject[START_BALLS_COUNT];
    private int gameObjectsCount;
    private RectanglesWindow() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        initGame();
        setVisible(true);
    }

//    private void createBalls(){
//        for (int i = 0; i< gameObjects.length; i++){
//            gameObjects[i] = new Ball();
//        }
//    }

    private void addGameObject(GameObject gameObject) {
        if(gameObjectsCount == gameObjects.length) {
            GameObject[] newSprites = new GameObject[gameObjects.length * 2];
            System.arraycopy(gameObjects, 0, newSprites, 0, gameObjects.length);
            gameObjects = newSprites;
        }
        gameObjects[gameObjectsCount++] = gameObject;
    }

    private GameObject removeGameObject() {
        if(gameObjectsCount > 0) {
            GameObject lastGameObject = gameObjects[--gameObjectsCount];
            gameObjects[gameObjectsCount] = null;
            return lastGameObject;
        }else {
            return null;
        }
    }

    private void initGame() {
    }

    @Override
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        draw(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas,float deltaTime){
        for (int i = 0; i< gameObjectsCount; i++){
            gameObjects[i].update(gameCanvas,deltaTime);
        }
    }

    private void draw(GameCanvas gameCanvas, Graphics g){
        for (int i = 0; i< gameObjectsCount; i++){
            gameObjects[i].render(gameCanvas,g);
        }

    }

}
