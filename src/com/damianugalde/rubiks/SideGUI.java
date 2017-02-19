package com.damianugalde.rubiks;

import javax.swing.*;
import java.awt.*;

public class SideGUI extends JPanel {

    private Side side;

    public static final int LINE = 5;
    public static final int SQUARE = 60;

    public static final int SIZE = (LINE * 4) +  (SQUARE * 3);

    public SideGUI(Side side){
        this.side = side;
        this.setSize(SIZE, SIZE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        this.drawLines(g2d);
        this.drawSquares(g2d);
    }

    private void drawLines(Graphics2D g2d){
        g2d.setColor(Color.BLACK);
        for(int i = 0; i < 4; i++) {
            g2d.fillRect((SQUARE + LINE) * i, 0, LINE, SIZE);
            g2d.fillRect(0, (SQUARE + LINE) * i, SIZE, LINE);
        }
    }

    private void drawSquares(Graphics2D g2d){
        Color[][] colors = this.side.getColors();
        for(int row = 0; row < colors.length; row++){
            for(int col = 0; col < colors[row].length; col++){
                g2d.setColor(colors[row][col]);
                g2d.fillRect((LINE * (row + 1)) + (SQUARE * row), (LINE * (col + 1)) + SQUARE * col, SQUARE, SQUARE);
            }
        }
    }
}