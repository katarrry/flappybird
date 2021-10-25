package com.example.kursinis1;

import com.example.kursinis1.drawings.TextDrawing;
import com.example.kursinis1.main.Main;

import javax.swing.*;
import java.awt.*;

public class  Render extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Screen.repaint(g);
    }

}
