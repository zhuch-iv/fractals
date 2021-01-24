package org.zhuch.bench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.infra.Blackhole;
import org.zhuch.fractal.Mandelbrot;
import org.zhuch.renderer.CompletableFutureRenderer;
import org.zhuch.renderer.SingleRenderer;

public class Bench {

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void singleRenderer(Blackhole blackhole) {
        var renderer = new SingleRenderer(
            Mandelbrot::mandelbrot,
            (x, y, color) -> {
                blackhole.consume(x);
                blackhole.consume(y);
                blackhole.consume(color);
            }
        );
        renderer.setBounds(500, 500);
        renderer.setUpperLeft(-1.0,1.0);
        renderer.setLowerRight(1.0,-1.0);
        renderer.render();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void concurrentRenderer(Blackhole blackhole) {
        var renderer = new CompletableFutureRenderer(
            Mandelbrot::mandelbrot,
            (x, y, color) -> {
                blackhole.consume(x);
                blackhole.consume(y);
                blackhole.consume(color);
            }
        );
        renderer.setBounds(500, 500);
        renderer.setUpperLeft(-1.0,1.0);
        renderer.setLowerRight(1.0,-1.0);
        renderer.render();
    }

}
