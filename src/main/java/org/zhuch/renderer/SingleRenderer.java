package org.zhuch.renderer;

import org.zhuch.api.Fractal;
import org.zhuch.api.PointColorConsumer;

public class SingleRenderer extends AbsRenderer {

    public SingleRenderer() {
    }

    public SingleRenderer(Fractal fractal, PointColorConsumer pointColorConsumer) {
        super(fractal, pointColorConsumer);
    }

    @Override
    public void render() {
        for (int y = 0; y <= height; y++) {
            for (int x = 0; x <= width; x++) {
                pointColorConsumer.consumeColorPoint(x, y, fractal.calc(normalizeX(x), normalizeY(y)));
            }
        }
    }
}
