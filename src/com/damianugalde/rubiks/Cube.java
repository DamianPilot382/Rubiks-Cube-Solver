package com.damianugalde.rubiks;

        import java.awt.*;
        import static com.damianugalde.rubiks.Side.reverse;


public class Cube {

    private Side[] sides;

    private Side yellow;
    private Side white;
    private Side orange;
    private Side red;
    private Side green;
    private Side blue;

    public Cube() {
        this.sides = new Side[6];

        sides[0] = new Side(Color.YELLOW); //top
        sides[1] = new Side(Color.WHITE); //bottom
        sides[2] = new Side(Color.ORANGE); //front
        sides[3] = new Side(Color.RED); //back
        sides[4] = new Side(Color.GREEN); //left
        sides[5] = new Side(Color.BLUE); //right

        this.yellow = sides[0];
        this.white = sides[1];
        this.orange = sides[2];
        this.red = sides[3];
        this.green = sides[4];
        this.blue = sides[5];
    }

    public Side[] getSides() {
        return this.sides;
    }

    public void setCube(Color[][][] colors){
        for(int s = 0; s < this.sides.length; s++){
            this.sides[s].setSide(colors[s]);
        }
    }

    public void right() {
        orange.setRight(white.setRight(reverse(red.setLeft(reverse(yellow.setRight(orange.removeRight()))))));
        blue.rotateClockwise();
    }

    public void rightInverted() {
        orange.setRight(yellow.setRight(reverse(red.setLeft(reverse(white.setRight(orange.removeRight()))))));
        blue.rotateCounterClockwise();
    }

    public void left() {
        orange.setLeft(yellow.setLeft(reverse(red.setRight(reverse(white.setLeft(orange.removeLeft()))))));
        green.rotateClockwise();
    }

    public void leftInverted() {
        orange.setLeft(white.setLeft(reverse(red.setRight(reverse(yellow.setLeft(orange.removeLeft()))))));
        green.rotateCounterClockwise();
    }

    public void up() {
        orange.setTop(blue.setTop(red.setTop(green.setTop(orange.removeTop()))));
        yellow.rotateCounterClockwise();
    }

    public void upInverted() {
        orange.setTop(green.setTop(red.setTop(blue.setTop(orange.removeTop()))));
        yellow.rotateClockwise();
    }

    public void down() {
        orange.setBottom(blue.setBottom(red.setBottom(green.setBottom(orange.removeBottom()))));
        white.rotateCounterClockwise();
    }

    public void downInverted() {
        orange.setBottom(green.setBottom(red.setBottom(blue.setBottom(orange.removeBottom()))));
        white.rotateClockwise();
    }

    public void front() {
        orange.rotateCounterClockwise();
    }

    public void frontInverted() {
        orange.rotateClockwise();
    }

    public void back() {
        red.rotateCounterClockwise();
    }

    public void backInverted() {
        red.rotateClockwise();
    }
}