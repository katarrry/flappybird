package com.example.kursinis1.shapes;

import com.example.kursinis1.Screen;

import java.util.Random;

public class ShapeFactory {
    private int generatedValue;
    private Screen screen = Screen.getInstance();

    public Shape getShape(String shapeName) {
        int columnWidth = screen.getWidth() / 4;
        int birdWidth = screen.getWidth() / 16;
        int birdHeight = screen.getWidth() / 16;
        int space = screen.getWidth() / 3;

        if (shapeName == null) {
            return null;
        }
        if (shapeName.equalsIgnoreCase("BIRD")) {
            return new Bird(screen.getWidth() / 2, screen.getHeight() / 2, birdWidth, birdHeight);
        } else if (shapeName.equalsIgnoreCase("BOTTOM_COLUMN")) {
            int height = columnHeightCalculator(shapeName);
            return new Column(screen.getWidth(), screen.getWidth() - height, columnWidth, height);
        } else if (shapeName.equalsIgnoreCase("TOP_COLUMN")) {
            return new Column(screen.getWidth(), 0, columnWidth, screen.getWidth() - columnHeightCalculator(shapeName) - space);
        }
        return null;

    }

    private int columnHeightCalculator(String shapeName) {
        if (shapeName.equalsIgnoreCase("BOTTOM_COLUMN")) {
            Random rand = new Random();
            generatedValue = rand.nextInt(screen.getHeight() / 2 - 50);
        }
        return screen.getHeight() / 5 + generatedValue;
    }

}
