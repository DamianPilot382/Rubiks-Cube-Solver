package com.damianugalde.rubiks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CubeReader {

    private Color[][][] cube;
    private int nextColor;
    private Cube c;
    private CaptureFrame frame;

    public CubeReader(Cube c){
        this.cube = new Color[6][3][3];
        this.nextColor = 0;
        this.c = c;
    }

    public void setColor(Color color){
        int i = this.getIndex(color);

    }

    public static int getIndex(Color color){
        if(color.equals(Color.YELLOW)) return 0;
        else if(color.equals(Color.WHITE)) return 1;
        else if(color.equals(Color.ORANGE)) return 2;
        else if(color.equals(Color.RED)) return 3;
        else if(color.equals(Color.GREEN)) return 4;
        else if(color.equals(Color.BLUE)) return 5;
        return 404;
    }

    public static Color getColor(int index){
        switch(index){
            case 0: return Color.YELLOW;
            case 1: return Color.WHITE;
            case 2: return Color.ORANGE;
            case 3: return Color.RED;
            case 4: return Color.GREEN;
            case 5: return Color.BLUE;
        }
        return Color.BLACK;
    }

    public static String getColorName(Color color){
        if(color.equals(Color.YELLOW)) return "Yellow";
        else if(color.equals(Color.WHITE)) return "White";
        else if(color.equals(Color.ORANGE)) return "Orange";
        else if(color.equals(Color.RED)) return "Red";
        else if(color.equals(Color.GREEN)) return "Green";
        else if(color.equals(Color.BLUE)) return "Blue";
        return "404";
    }

    public static String getColorName(int index){
        return getColorName(CubeReader.getColor(index));
    }

    public static Color averageColor(BufferedImage bi, int x0, int y0, int w, int h) {
        x0 += 35;
        y0 += 35;

        w = 70;
        h = 70;

        int x1 = x0 + w;
        int y1 = y0 + h;
        long sumr = 0, sumg = 0, sumb = 0;
        for (int x = x0; x < x1; x++) {
            for (int y = y0; y < y1; y++) {
                Color pixel = new Color(bi.getRGB(x, y));
                sumr += pixel.getRed();
                sumg += pixel.getGreen();
                sumb += pixel.getBlue();
            }
        }

        int num = w * h;
        return new Color(((float) sumr / num) / 255f, ((float) sumg / num) / 255f, ((float) sumb / num) / 255f);
    }

    public Color[][] next(BufferedImage img){

        Color[][] arr = new Color[3][3];
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                arr[row][col] = this.averageColor(img, 95 + (col * 150), 15 + (row * 150), 140, 140);
            }
        }
        this.setColor(arr);
        this.nextColor++;
        if(nextColor >= 6){
            this.assignColors();
            frame.killFrame();
            return new Color[3][3];
        }
        return arr;
    }

    public void setColor(Color[][] arr){
        for(int row = 0; row < cube[row].length; row++){
            for(int col = 0; col < cube[col].length; col++)
            {
                this.cube[nextColor][row][col] = this.getColor(arr[row][col]);
                System.out.print(this.getColorName(this.getColor(arr[row][col])) + " " + arr[row][col]);
            }
            System.out.println();
        }
    }

    public double colorDistance(Color c1, Color c2)
    {
        double rmean = ( c1.getRed() + c2.getRed() )/2;
        int r = c1.getRed() - c2.getRed();
        int g = c1.getGreen() - c2.getGreen();
        int b = c1.getBlue() - c2.getBlue();
        double weightR = 2 + rmean/256;
        double weightG = 4.0;
        double weightB = 2 + (255-rmean)/256;
        return Math.sqrt(weightR*r*r + weightG*g*g + weightB*b*b);
    }

    public Color getColor(Color color){
        double[] distance = new double[6];
        distance[0] = this.colorDistance(color, new Color(180, 210, 80));
        distance[1] = this.colorDistance(color, new Color(190, 200, 200));
        distance[2] = this.colorDistance(color, new Color(200, 150, 90));
        distance[3] = this.colorDistance(color, new Color(230, 50, 100));
        distance[4] = this.colorDistance(color, new Color(80, 200, 100));
        distance[5] = this.colorDistance(color, new Color(70, 160, 220));

        Color retColor = Color.BLACK;
        double min = Double.MAX_VALUE;
        for(int i = 0; i < distance.length; i++){
            if(distance[i] < min){
                min = distance[i];
                retColor = getColor(i);
            }
        }
        return retColor;
    }

    public void assignColors(){
        c.setCube(this.cube);
    }

    public void setFrame(CaptureFrame frame){
        this.frame = frame;
    }
}