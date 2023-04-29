package io.github.melqqeuy.engine;

import java.awt.*;

public interface  GameObject {

    void update(GameCanvas gameCanvas, float deltaTime);
    void render(GameCanvas gameCanvas, Graphics g);
}
