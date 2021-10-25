package com.example.kursinis1.states;

import com.example.kursinis1.Screen;
import com.example.kursinis1.shapes.Shape;
import com.example.kursinis1.shapes.ShapeFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartState extends State implements MouseListener, ActionListener {

    private Context context;
    private static int yMotion;
    private final Timer timer = new Timer(20, this);

    @Override
    public void doAction(Context context) {
        this.context = context;
        Screen.getJframe().addMouseListener(this);
        timer.start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        yMotion = getyMotion();
        if (yMotion > 0) yMotion = 0;
        yMotion -= 20;
        setyMotion(yMotion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        yMotion = getyMotion();
        int score = getScore();
        ShapeFactory shapeFactory = getShapeFactory();
        Shape bird = getBird();
        Shape bottomColumn = getBottomColumn();
        Shape topColumn = getTopColumn();

        topColumn.move(Screen.getInstance().getWidth() / 80);
        bottomColumn.move(Screen.getInstance().getWidth() / 80);

        yMotion += Screen.getInstance().getHeight() / 400;
        setyMotion(yMotion);
        bird.move(yMotion);
        setBird(bird);

        if (!isColumnInScreen(topColumn)) {
            bottomColumn = shapeFactory.getShape("bottom_column");
            setBottomColumn(bottomColumn);
            topColumn = shapeFactory.getShape("top_column");
            setTopColumn(topColumn);
        }

        if (isColumnPassed(bird, topColumn)) {
            setScore(++score);
        }

        if (isGameOver(bird, topColumn, bottomColumn)) {
            Screen.getJframe().removeMouseListener(this);
            context.setState(new StopState());
            context.doAction();
            timer.stop();
        }
        Screen.getRender().repaint();
    }

    private boolean isOverlapping(Shape bird, Shape column) {
        if (bird.getY() > column.getY() + column.getHeight()
                || bird.getY() + bird.getHeight() < column.getY()) {
            return false;
        }
        if (bird.getX() > column.getX() + column.getWidth()
                || bird.getX() + bird.getWidth() < column.getX()) {
            return false;
        }
        return true;
    }

    public boolean isBirdInScreen(Shape bird) {
        if (bird.getY() > Screen.getInstance().getHeight() || bird.getY() < 0) {
            return false;
        }
        return true;
    }

    public boolean isGameOver(Shape bird, Shape topColumn, Shape bottomColumn) {
        if (isOverlapping(bird, bottomColumn) || isOverlapping(bird, topColumn) || !isBirdInScreen(bird)) return true;
        return false;
    }

    public boolean isColumnInScreen(Shape column) {
        if (column.getX() + column.getWidth() < 0 && column.getY() == 0) return false;
        return true;
    }

    public boolean isColumnPassed(Shape bird, Shape column) {
        if (column.getY() == 0 && bird.getX() + bird.getWidth() > column.getX() + column.getWidth() - 5 && bird.getX() + bird.getWidth()
                < column.getX() + column.getWidth() + 5) return true;
        return false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
