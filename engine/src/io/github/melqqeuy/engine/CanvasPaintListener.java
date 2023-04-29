package io.github.melqqeuy.engine;

import java.awt.*;

public interface CanvasPaintListener {

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime);
}
