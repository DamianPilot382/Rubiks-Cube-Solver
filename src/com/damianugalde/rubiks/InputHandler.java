package com.damianugalde.rubiks;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class InputHandler extends KeyAdapter {

    private Cube cube;
    private GUI gui;

    public InputHandler(Cube cube, GUI gui){
        this.cube = cube;
        this.gui = gui;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        switch(key){
            case VK_P:
                System.out.println("RIGHT");
                cube.right();
                break;
            case VK_O:
                System.out.println("MIDDLE COL");
                //cube.middleCol();
                break;
            case VK_I:
                System.out.println("LEFT");
                cube.left();
                break;
            case VK_SEMICOLON:
                System.out.println("RIGHT INVERTED");
                cube.rightInverted();
                break;
            case VK_L:
                System.out.println("MIDDLE COL INVERTED");
                //cube.middleColInverted();
                break;
            case VK_K:
                System.out.println("LEFT INVERTED");
                cube.leftInverted();
                break;
            case VK_Y:
                System.out.println("TOP");
                cube.up();
                break;
            case VK_U:
                System.out.println("TOP INVERTED");
                cube.upInverted();
                break;
            case VK_H:
                System.out.println("MIDDLE ROW");
                //cube.middleRow();
                break;
            case VK_J:
                System.out.println("MIDDLE ROW INVERTED");
                //cube.middleRowInverted();
                break;
            case VK_N:
                System.out.println("DOWN");
                cube.down();
                break;
            case VK_M:
                System.out.println("DOWN INVERTED");
                cube.downInverted();
                break;
            case VK_R:
                System.out.println("BACK");
                cube.back();
                break;
            case VK_T:
                System.out.println("BACK INVERTED");
                cube.backInverted();
                break;
            case VK_F:
                System.out.println("FRONT");
                cube.front();
                break;
            case VK_G:
                System.out.println("FRONT INVERTED");
                cube.frontInverted();
                break;
            case VK_ENTER:
                System.out.println("ENTER");
                gui.getColors();
                break;
            case VK_SLASH:
                System.out.println("Get Color");
                gui.givePic();
                break;
        }
    }
}