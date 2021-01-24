package org.zhuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.zhuch.renderer.CompletableFutureRenderer;
import org.zhuch.fractal.Mandelbrot;

import java.time.LocalDateTime;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello world Application");
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        Canvas canvas = new Canvas(500, 500);
        var ctx = canvas.getGraphicsContext2D();

        var renderer = new CompletableFutureRenderer(
            Mandelbrot::mandelbrot,
            (x, y, color) -> {
                ctx.setFill(color);
                ctx.fillRect(x, y, 1, 1);
            }
        );
        renderer.setBounds(500, 500);
        renderer.setUpperLeft(-1.0,1.0);
        renderer.setLowerRight(1.0,-1.0);
        System.out.println(LocalDateTime.now().toString());
        renderer.render();
        System.out.println(LocalDateTime.now().toString());

        VBox vbox = new VBox(canvas);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
