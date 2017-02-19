package com.damianugalde.rubiks;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CaptureFrame extends JFrame {
    private JPanel contentPane;
    private VideoCap videoCap;

    public CaptureFrame(InputHandler handler) {

        this.videoCap = new VideoCap();

        EventQueue.invokeLater(() -> {
            addKeyListener(handler);
            init();
        });
    }

    private void init() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        setBounds(0, 0, 655, 525);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                killFrame();
            }
        });
        new VideoCapThread().start();
    }


    public BufferedImage getFrame() {
        return videoCap.getOneFrame();
    }

    public void paint(Graphics g) {
        g = contentPane.getGraphics();
        g.drawImage(videoCap.getOneFrame(), 0, 0, this);

        this.paintGrid(g);

    }


    public void killFrame() {
        this.setVisible(false);
        dispose();
        videoCap.cap.release();
    }

    private void paintGrid(Graphics g) {
        g.fillRect(95, 15, 10, 460);
        g.fillRect(245, 15, 10, 460);
        g.fillRect(395, 15, 10, 460);
        g.fillRect(545, 15, 10, 460);

        g.fillRect(95, 15, 460, 10);
        g.fillRect(95, 165, 460, 10);
        g.fillRect(95, 315, 460, 10);
        g.fillRect(95, 465, 460, 10);
    }

    class VideoCapThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}