package com.damianugalde.rubiks;

import org.opencv.core.Core;

import java.awt.*;

public class Main {

    public static CaptureFrame captureFrame;

    public static void main(String[] args){

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Cube cube = new Cube();
        CubeReader reader = new CubeReader(cube);
        SelectGUI selectGUI = new SelectGUI();
        GUI gui = new GUI(cube, reader, selectGUI);

        InputHandler handler = new InputHandler(cube, gui);
        MouseInput mouse = new MouseInput(gui);

        gui.addKeyListener(handler);
        gui.addMouseListener(mouse);
        gui.setFocusable(true);

        captureFrame = new CaptureFrame(handler);

        gui.display();
        while(true) {
            try {
                Thread.sleep(30);
                gui.repaint();
            } catch (Exception e) {

            }
        }
    }

}