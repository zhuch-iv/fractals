package org.zhuch.renderer;

import org.zhuch.api.Fractal;
import org.zhuch.api.FractalRenderer;
import org.zhuch.api.PointColorConsumer;

abstract class AbsRenderer implements FractalRenderer {
    int width;
    int height;
    double ulX;
    double ulY;
    double lrX;
    double lrY;
    Fractal fractal;
    PointColorConsumer pointColorConsumer;

    public AbsRenderer() {}

    public AbsRenderer(Fractal fractal, PointColorConsumer pointColorConsumer) {
        this.fractal = fractal;
        this.pointColorConsumer = pointColorConsumer;
    }

    @Override
    public void setBounds(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void setUpperLeft(double x, double y) {
        this.ulX = x;
        this.ulY = y;
    }

    @Override
    public void setLowerRight(double x, double y) {
        this.lrX = x;
        this.lrY = y;
    }

    @Override
    public void setPointConsumer(PointColorConsumer consumer) {
        this.pointColorConsumer = consumer;
    }

    @Override
    public void setFractal(Fractal fractal) {
        this.fractal = fractal;
    }

    double normalizeX(double x) {
        return ulX + x * ((lrX - ulX) / (double) width);
    }

    double normalizeY(double y) {
        return ulY - y * ((ulY - lrY) / (double) height);
    }
}
