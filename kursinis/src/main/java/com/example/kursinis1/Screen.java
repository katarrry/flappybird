package com.example.kursinis1;

import com.example.kursinis1.drawings.ShapeDrawing;
import com.example.kursinis1.drawings.TextDrawing;
import com.example.kursinis1.shapes.Shape;
import com.example.kursinis1.states.Context;
import com.example.kursinis1.states.State;
import com.example.kursinis1.states.StopState;

import javax.swing.*;
import java.awt.*;

public class Screen {

    private static JFrame jframe;
    private static Render render;
    private final int width;
    private final int height;

    private static final Screen screen = new Screen(800, 800);

    private Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Screen getInstance() {
        return screen;
    }

    public void screen() {

        jframe = new JFrame("Flappy bird");
        render = new Render();
        jframe.add(render);
        jframe.setSize(getInstance().getWidth(), getInstance().getHeight());
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Context stateContext = new Context();
        stateContext.setState(new StopState());
        stateContext.doAction();
    }


    public static void repaint(Graphics g) {
        ShapeDrawing background = new ShapeDrawing(Color.cyan.darker(), 0, 0, Screen.getInstance().getWidth(), Screen.getInstance().getHeight());
        background.setColor(g);
        background.drawShape(g);

        Shape bird = State.getBird();
        ShapeDrawing birdDrawing = new ShapeDrawing(Color.red, bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
        birdDrawing.setColor(g);
        birdDrawing.drawShape(g);

        Shape topColumn = State.getTopColumn();
        ShapeDrawing topColumnDrawing = new ShapeDrawing(Color.green.darker().darker(), topColumn.getX(), topColumn.getY(), topColumn.getWidth(), topColumn.getHeight());
        topColumnDrawing.setColor(g);
        topColumnDrawing.drawShape(g);

        Shape bottomColumn = State.getBottomColumn();
        ShapeDrawing bottomColumnDrawing = new ShapeDrawing(bottomColumn.getX(), bottomColumn.getY(), bottomColumn.getWidth(), bottomColumn.getHeight());
        bottomColumnDrawing.drawShape(g);

        int score = State.getScore();
        Font font = new Font("Serif", Font.BOLD, Screen.getInstance().getHeight() / 7);
        TextDrawing scoreDrawing = new TextDrawing(Color.white, String.valueOf(score), font, Screen.getInstance().getWidth() / 2, Screen.getInstance().getHeight() / 7);
        scoreDrawing.setColor(g);
        scoreDrawing.drawText(g);

    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static JFrame getJframe() {
        return jframe;
    }

    public static Render getRender() {
        return render;
    }
}