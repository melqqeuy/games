package io.github.melqqeuy.circles;
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }

    private Sprite[] sprites = new Sprite[10];
    private GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        createBalls();
        setVisible(true);
    }

    private void createBalls(){
        for (int i=0; i< sprites.length; i++){
            sprites[i]=new Ball();
        }
    }

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        update(gameCanvas, deltaTime);
        draw(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas,float deltaTime){
        for (int i=0; i< sprites.length; i++){
            sprites[i].update(gameCanvas,deltaTime);
        }
    }

    private void draw(GameCanvas gameCanvas, Graphics g){
        for (int i=0; i< sprites.length; i++){
            sprites[i].render(gameCanvas,g);
        }
        gameCanvas.setBackground(new Color(0,0,0));
    }

}
