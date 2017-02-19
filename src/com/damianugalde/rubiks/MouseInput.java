package com.damianugalde.rubiks;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.awt.Color.*;

public class MouseInput implements MouseListener {
    private GUI gui;

    public MouseInput(GUI gui){
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        this.checkTriggers(x, y);
        this.checkCubes(x, y);

        System.out.println(x + ", " + y);

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

    private void checkCubes(int x, int y){
        if(x >= 300 && x <= 360){
            if(y >= 550 && y <= 610){
                gui.override(1, 0, 0);
            }else if(y >= 615 && y <= 675){
                gui.override(1, 0, 1);
            }else if(y >= 690 && y <= 1050){
                gui.override(1, 0, 2);
            }
        }
    }

    private void checkTriggers(int x, int y){
        if(x >= 825 && x <= 885 && y >= 40 && y <= 100){
            gui.setTrigger(YELLOW);
        }else if(x >= 900 && x <= 960 && y >= 40 && y <= 100){
            gui.setTrigger(WHITE);
        }else if(x >= 975 && x <= 1035 && y >= 40 && y <= 100){
            gui.setTrigger(ORANGE);
        }else if(x >= 825 && x <= 885 && y >= 120 && y <= 180){
            gui.setTrigger(RED);
        }else if(x >= 900 && x <= 960 && y >= 120 && y <= 180){
            gui.setTrigger(GREEN);
        }else if(x >= 975 && x <= 1035 && y >= 120 && y <= 180){
            gui.setTrigger(BLUE);
        }
    }
}
