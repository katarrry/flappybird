package com.example.kursinis1.states;

import com.example.kursinis1.shapes.Shape;
import com.example.kursinis1.shapes.ShapeFactory;

public abstract class State {
    private static int score = 0;
    private int yMotion = 0;
    private static ShapeFactory shapeFactory = new ShapeFactory();
    private static Shape bird = shapeFactory.getShape("Bird");
    private static Shape bottomColumn = shapeFactory.getShape("bottom_column");
    private static Shape topColumn = shapeFactory.getShape("top_column");

    public static int getScore() {
        return State.score;
    }

    public void setScore(int score) {
        State.score = score;
    }

    public int getyMotion() {
        return yMotion;
    }

    public void setyMotion(int yMotion) {
        this.yMotion = yMotion;
    }

    public ShapeFactory getShapeFactory() {
        return shapeFactory;
    }

    public static Shape getBird() {
        return bird;
    }

    public void setBird(Shape bird) {
        State.bird = bird;
    }

    public static Shape getBottomColumn() {
        return bottomColumn;
    }

    public void setBottomColumn(Shape bottomColumn) {
        State.bottomColumn = bottomColumn;
    }

    public static Shape getTopColumn() {
        return topColumn;
    }

    public void setTopColumn(Shape topColumn) {
        State.topColumn = topColumn;
    }

    public abstract void doAction(Context context);


}
