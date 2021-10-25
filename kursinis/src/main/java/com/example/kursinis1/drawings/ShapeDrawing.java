package com.example.kursinis1.drawings;

import com.example.kursinis1.drawings.Drawing;

import java.awt.*;

public class ShapeDrawing extends Drawing {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public ShapeDrawing(Color color, int x, int y, int width, int height) {
        super(color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public ShapeDrawing(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void drawShape (Graphics graphics) {
        graphics.fillRect(x, y, width, height);
    }
}
