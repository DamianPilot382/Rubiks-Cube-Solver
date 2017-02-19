package com.damianugalde.rubiks;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private Cube cube;
    private CubeReader reader;
    private SelectGUI selectGUI;
    private Color trigger;

    private SideGUI[] sides;
    private CaptureFrame captureFrame;

    private Font font;
    private JButton solve;
    private JTextField solution;

    public GUI(Cube cube, CubeReader reader, SelectGUI selectGUI){
        this.cube = cube;
        this.reader = reader;
        this.selectGUI = selectGUI;
        this.trigger = Color.BLACK;
        this.font = new Font("Arial", Font.BOLD, 28);
        this.solve = new JButton("Solve");
        this.solution = new JTextField();

        this.setTitle("Rubik's Cube Solver");
        this.setSize(1050, 850);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        this.initSides();
        this.setLabels();

        this.selectGUI.setLocation(825, 10);
        this.add(this.selectGUI);

        this.solve.setLocation(20, 20);
        this.solve.setSize(125, 50);
        this.solve.setFont(this.font);
        this.add(this.solve);

        this.solution.setSize(this.getWidth(), 50);
        this.solution.setLocation(0, 760);
        this.solution.setEnabled(false);
        this.add(this.solution);

    }

    public void display(){
        this.setVisible(true);
    }

    public void initSides(){
        this.sides = new SideGUI[6];
        Side[] temp = this.cube.getSides();
        for(int i = 0; i < temp.length; i++){
            sides[i] = new SideGUI(temp[i]);
        }

        for(SideGUI side : this.sides){
            this.add(side);
        }
        sides[0].setLocation(300, 50);
        sides[1].setLocation(300, 550);
        sides[2].setLocation(300, 300);
        sides[3].setLocation(800, 300);
        sides[4].setLocation(50, 300);
        sides[5].setLocation(550, 300);

    }

    private void setLabels(){
        JLabel top = new JLabel("Top");
        top.setFont(font);
        top.setLocation(370, 10);
        top.setSize(100, 35);
        this.add(top);

        JLabel bottom = new JLabel("Bottom");
        bottom.setFont(font);
        bottom.setLocation(350, 520);
        bottom.setSize(100, 20);
        this.add(bottom);

        JLabel front = new JLabel("Front");
        front.setFont(font);
        front.setLocation(363, 270);
        front.setSize(100, 20);
        this.add(front);

        JLabel back = new JLabel("Back");
        back.setFont(font);
        back.setLocation(865, 270);
        back.setSize(100, 20);
        this.add(back);

        JLabel left = new JLabel("Left");
        left.setFont(font);
        left.setLocation(122, 270);
        left.setSize(100, 20);
        this.add(left);

        JLabel right = new JLabel("Right");
        right.setFont(font);
        right.setLocation(615, 262);
        right.setSize(100, 32);
        this.add(right);
    }

    public void getColors(){
        reader.setFrame(Main.captureFrame);
    }

    public void givePic(){
        reader.next(Main.captureFrame.getFrame());
    }

    public void override(int side, int row, int col){
        if(col == 1 && row == 1) return;

        this.cube.getSides()[side].setColor(row, col, this.trigger);
    }

    public void setTrigger(Color color){
        this.trigger = color;
    }

}