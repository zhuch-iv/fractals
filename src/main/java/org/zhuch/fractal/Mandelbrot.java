package org.zhuch.fractal;

import javafx.scene.paint.Color;
import org.apache.commons.math3.complex.Complex;

public class Mandelbrot {

    public static Color mandelbrot(double x, double y) {
        return Color.grayRgb(checkConvergence(new Complex(x, y), Complex.ZERO, 255));
    }

    private static int checkConvergence(Complex c, Complex z, int steps) {
        for (int i = 0; i < steps; i++) {
            z = z.multiply(z).add(c);
            if (z.abs() > 2) {
                return steps - i;
            }
        }
        return 0;
    }
}
