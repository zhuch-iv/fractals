package org.zhuch.api;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface PointColorConsumer {
    void consumeColorPoint(int x, int y, Color color);
}
