package io.github.melqqeuy.circles;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int START_BALLS_COUNT = 1;



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }

    private GameObject[] gameObjects = new GameObject[START_BALLS_COUNT];
    private int gameObjectsCount;
    private GameWindow() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int btn = e.getButton();
                if (btn == MouseEvent.BUTTON1)
                    addGameObject(new Ball(e.getX(), e.getY()));
                else if (gameObjectsCount > 1) removeGameObject();
            }
        });
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
        addGameObject(new Background());
        for (int i = 0; i < START_BALLS_COUNT; i++) {
            addGameObject(new Ball());
        }
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
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
