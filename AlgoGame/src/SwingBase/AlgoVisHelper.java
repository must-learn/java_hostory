package SwingBase;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {
    private AlgoVisHelper(){ }

    public static void strokeCircle(Graphics2D g,double x,double y,double r){
        g.draw(new Ellipse2D.Double(x-r,y-r,2*r,2*r));
    }
    public static void fillCircle(Graphics2D g,double x,double y,double r){
        g.fill(new Ellipse2D.Double(x-r,y-r,2*r,2*r));
    }
    public static void setColor(Graphics2D g,Color color){
        g.setColor(color);
    }
    public static void setStrokeWidth(Graphics2D g,int width){
        g.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }
    public static void pause(int t) {
        try {
            Thread.sleep(t);
        }
        catch (InterruptedException e) {
            System.out.println("Error sleeping");
        }
    }


}
