package com.example.kursinis1.drawings;

import com.example.kursinis1.drawings.Drawing;

import java.awt.*;

public class TextDrawing extends Drawing {
    private final String text;
    private final Font font;
    private final int x;
    private final int y;

    public TextDrawing(Color color, String text, Font font, int x, int y) {
        super(color);
        this.text = text;
        this.font = font;
        this.x = x;
        this.y = y;
    }


    public void drawText(Graphics graphics) {
        graphics.setFont(font);
        graphics.drawString(text, x, y);
    }
}
