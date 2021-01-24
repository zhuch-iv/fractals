package org.zhuch.api;

public interface FractalRenderer {

    void setBounds(int weight, int height);

    void setUpperLeft(double x, double y);

    void setLowerRight(double x, double y);

    void setPointConsumer(PointColorConsumer consumer);

    void setFractal(Fractal fractal);

    void render();
}
