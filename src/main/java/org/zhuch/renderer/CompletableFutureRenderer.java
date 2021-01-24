package org.zhuch.renderer;

import lombok.SneakyThrows;
import org.zhuch.api.Fractal;
import org.zhuch.api.PointColorConsumer;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class CompletableFutureRenderer extends AbsRenderer {

    public CompletableFutureRenderer() {
    }

    public CompletableFutureRenderer(Fractal fractal, PointColorConsumer pointColorConsumer) {
        super(fractal, pointColorConsumer);
    }

    @Override
    @SneakyThrows
    public void render() {
        CompletableFuture.allOf(
            IntStream.range(0, height + 1)
                .mapToObj(y -> CompletableFuture.runAsync(() -> {
                    for (int x = 0; x < width; x++) {
                        pointColorConsumer.consumeColorPoint(x, y, fractal.calc(normalizeX(x), normalizeY(y)));
                    }
                }))
                .toArray(CompletableFuture[]::new)
        ).get();
    }
}
