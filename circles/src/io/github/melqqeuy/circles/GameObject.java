package io.github.melqqeuy.circles;

import java.awt.*;

public interface  GameObject {

    void update(GameCanvas gameCanvas, float deltaTime);
    void render(GameCanvas gameCanvas, Graphics g);
}
