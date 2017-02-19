package com.damianugalde.rubiks;

import java.awt.*;

public class Side {

    private Color[][] colors;

    public Side(Color color) {
        this.colors = new Color[3][3];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                this.colors[i][j] = color;
            }
        }

    }

    public void setSide(Color[][] colors){
        for(int row = 0; row < colors.length; row++){
            for(int col = 0; col < colors.length; col++){
                this.colors[row][col] = colors[row][col];
            }
        }
    }

    public Color[][] getColors() {
        return this.colors;
    }

    public Color[] removeTop() {
        return this.removeRow(0);
    }

    public Color[] removeMiddleRow() {
        return this.removeRow(1);
    }

    public Color[] removeBottom() {
        return this.removeRow(2);
    }

    public Color[] removeLeft() {
        return this.removeCol(0);
    }

    public Color[] removeMiddleCol() {
        return this.removeCol(1);
    }

    public Color[] removeRight() {
        return this.removeCol(2);
    }

    private Color[] removeRow(int index) {
        Color[] temp = new Color[3];
        for (int i = 0; i < this.colors.length; i++) {
            temp[i] = this.colors[i][index];
            this.colors[i][index] = Color.BLACK;
        }

        return temp;
    }

    private Color[] removeCol(int index) {
        Color[] temp = new Color[3];
        for (int i = 0; i < this.colors.length; i++) {
            temp[i] = this.colors[index][i];
            this.colors[index][i] = Color.BLACK;
        }

        return temp;
    }

    private Color[] setRow(Color[] newColors, int index) {
        Color[] temp = new Color[3];
        for (int i = 0; i < this.colors[index].length; i++) {
            temp[i] = this.colors[i][index];
            this.colors[i][index] = newColors[i];
        }

        return temp;
    }

    private Color[] setCol(Color[] newColors, int index) {
        Color[] temp = new Color[3];
        for (int i = 0; i < this.colors.length; i++) {
            temp[i] = this.colors[index][i];
            this.colors[index][i] = newColors[i];
        }

        return temp;
    }

    public Color[] setTop(Color[] newColors) {
        return this.setRow(newColors, 0);
    }

    public Color[] setMiddleRow(Color[] newColors) {
        return this.setRow(newColors, 1);
    }

    public Color[] setBottom(Color[] newColors) {
        return this.setRow(newColors, 2);
    }

    public Color[] setLeft(Color[] newColors) {
        return this.setCol(newColors, 0);
    }

    public Color[] setMiddleCol(Color[] newColors) {
        return this.setCol(newColors, 1);
    }

    public Color[] setRight(Color[] newColors) {
        return this.setCol(newColors, 2);
    }

    public void rotateClockwise() {
        this.rotate(true);
    }

    public void rotateCounterClockwise() {
        this.rotate(false);
    }

    private void rotate(boolean clockwise){
        Color[][] temp = new Color[3][3];
        for(int i = 0; i < this.colors.length; i++){
            for(int j = 0; j < this.colors[i].length; j++){
                temp[i][j] = this.colors[i][j];
            }
        }

        if(!clockwise){
            this.colors[0][0] = temp[2][0];
            this.colors[0][1] = temp[1][0];
            this.colors[0][2] = temp[0][0];
            this.colors[1][0] = temp[2][1];
            this.colors[1][1] = temp[1][1];
            this.colors[1][2] = temp[0][1];
            this.colors[2][0] = temp[2][2];
            this.colors[2][1] = temp[1][2];
            this.colors[2][2] = temp[0][2];
        }else{
            this.colors[0][0] = temp[0][2];
            this.colors[0][1] = temp[1][2];
            this.colors[0][2] = temp[2][2];
            this.colors[1][0] = temp[0][1];
            this.colors[1][1] = temp[1][1];
            this.colors[1][2] = temp[2][1];
            this.colors[2][0] = temp[0][0];
            this.colors[2][1] = temp[1][0];
            this.colors[2][2] = temp[2][0];
        }

    }

    private void randomColors() {
        for (int i = 0; i < this.colors.length; i++) {
            for (int j = 0; j < this.colors[0].length; j++) {
                this.colors[i][j] = this.getRandColor();
            }
        }
    }

    private Color getRandColor() {
        int prob = (int) (Math.random() * 6 + 1);
        switch (prob) {
            case 1:
                return Color.YELLOW;
            case 2:
                return Color.WHITE;
            case 3:
                return Color.ORANGE;
            case 4:
                return Color.RED;
            case 5:
                return Color.GREEN;
            case 6:
                return Color.BLUE;
        }

        return Color.WHITE;
    }

    public static Color[] reverse(Color[] colors){
        Color[] temp = new Color[colors.length];
        for(int i  = temp.length - 1; i >= 0; i--){
            temp[temp.length - i - 1] = colors[i];
        }
        return temp;
    }

    public void setColor(int row, int col, Color color){
        this.colors[row][col] = color;
    }
}