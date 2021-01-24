package org.zhuch.api;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface Fractal {
    Color calc(double x, double y);
}
