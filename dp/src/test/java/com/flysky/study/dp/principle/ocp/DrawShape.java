package com.flysky.study.dp.principle.ocp;

import java.util.ArrayList;
import java.util.List;

public class DrawShape {

    private List shapes = new ArrayList();

    private List<Shape> shapes2 = new ArrayList();

    public void addShape2(Shape shape) {
        shapes2.add(shape);
    }

    public void addShape(Object shape) {
        shapes.add(shape);
    }

    public void drawShapes() {
        shapes2.forEach(Shape::draw);
    }

    public void drawAllShapes() {
        for (Object shape : shapes) {
            if (shape instanceof Circle) {
                drawCircle((Circle) shape);
            }
            if (shape instanceof Square) {
                drawSquare((Square) shape);
            }
        }
    }

    private void drawCircle(Circle circle) {
        circle.draw();
    }
    private void drawSquare(Square square) {
        square.draw();
    }

    public List shapes() {
        return shapes;
    }
}
