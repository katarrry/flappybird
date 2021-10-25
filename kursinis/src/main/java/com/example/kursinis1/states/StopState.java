package com.example.kursinis1.states;

import com.example.kursinis1.Screen;
import com.example.kursinis1.shapes.ShapeFactory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StopState extends State implements MouseListener {

    private Context context;

    @Override
    public void doAction(Context context) {
        Screen.getRender().repaint();
        this.context = context;
        Screen.getJframe().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setScore(0);
        setyMotion(0);
        ShapeFactory shapeFactory = getShapeFactory();
        setBird(shapeFactory.getShape("Bird"));
        setBottomColumn(shapeFactory.getShape("bottom_column"));
        setTopColumn(shapeFactory.getShape("top_column"));
        context.setState(new StartState());
        context.doAction();
        Screen.getJframe().removeMouseListener(this);
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
