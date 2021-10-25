package com.example.kursinis1.shapes;

public class Bird extends Shape {
    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void move(int yMotion) {
        this.y += yMotion;
    }
}
