package com.example.kursinis1.drawings;

import java.awt.*;

public class Drawing {
    private Color color;

    public Drawing(Color color) {
        this.color = color;
    }

    public Drawing() {
    }

    public void setColor(Graphics graphics) {
        graphics.setColor(color);
    }
}
