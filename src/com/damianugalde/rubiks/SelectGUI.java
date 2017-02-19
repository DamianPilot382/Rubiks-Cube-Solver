package com.damianugalde.rubiks;

import javax.swing.*;
import java.awt.*;

public class SelectGUI extends JPanel {


    public static final int SQUARE = 60;

    public static final int WIDTH = (SQUARE * 3) + 35;
    public static final int LENGTH = (SQUARE * 2) + 20;

    public SelectGUI(){
        this.setSize(WIDTH, LENGTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        this.drawSquares(g2d);
    }

    private void drawSquares(Graphics2D g2d){
        int color = 0;
        for(int row = 0; row < 2; row++){
            for(int col = 0; col < 3; col++){
                g2d.setColor(CubeReader.getColor(color));
                g2d.fillRect(col * 15 + (SQUARE * col), row * 15 + (SQUARE * row), SQUARE, SQUARE);
                color++;
            }
        }
    }
}