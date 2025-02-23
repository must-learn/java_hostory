package Sort.SelectedSorted;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);

        setResizable(false);
        pack();    // 在setResizable(false)后进行pack()，防止在Windows下系统修改frame的尺寸
                   // 具体参见：http://coding.imooc.com/learn/questiondetail/26420.html

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    private SortData data;
    private int sorted;
    private int curMin;
    private int curComp;
    public void render(SortData data,int sorted,int curComp,int curMin){
        this.data = data;
        this.sorted = sorted;
        this.curComp = curComp;
        this.curMin = curMin;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            int[] a = data.getData();
            int w = canvasWidth/a.length;
            for (int i= 0;i<a.length;i++) {
                AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
                if (i < sorted)
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
                else{
                    if (i == curMin)
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.DeepOrange);
                    if (i == curComp)
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.Black);
            }
                AlgoVisHelper.fillRectangle(g2d,i*w,canvasHeight-a[i],w-1,a[i]);
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


