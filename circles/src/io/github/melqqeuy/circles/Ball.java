package io.github.melqqeuy.circles;

import java.awt.*;
public class Ball extends Sprite {
    private float vx = 150f + (float) (Math.random()*200f);
    private float vy = 150f + (float) (Math.random()*200f);
    private Color color= new Color((int) (Math.random() * 256f),(int) (Math.random() * 256f),(int) (Math.random() * 256f),(int) (Math.random() * 256f));

    Ball(){;
        halfHeight=20f+(float) (Math.random()*50f);
        halfWidth=halfHeight;
    }

    public Ball(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }


    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        x+=vx*deltaTime;
        y+=vy*deltaTime;
        if(getLeft()<gameCanvas.getLeft()){
            setLeft(gameCanvas.getLeft());
            vx=-vx;
        }
        if(getRight()> gameCanvas.getRight()){
            setRight((gameCanvas.getRight()));
            vx=-vx;
        }
        if (getBottom()>gameCanvas.getBottom()){
            setBottom(gameCanvas.getBottom());
            vy=-vy;
        }
        if (getTop()<gameCanvas.getTop()){
            setTop(gameCanvas.getTop());
            vy=-vy;
        }

    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(),(int)getTop(),(int)getWidth(),(int)getHeight());

    }
}
