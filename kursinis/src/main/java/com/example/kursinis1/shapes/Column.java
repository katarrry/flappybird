package com.example.kursinis1.shapes;

public class Column extends Shape {

    public Column(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void move(int speed) {
        this.x -= speed;
    }

}
