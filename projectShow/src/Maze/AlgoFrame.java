package Maze;

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


    private MazeData data;
    public void render(MazeData data){
        this.data = data;
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

            int w = canvasWidth/data.getM();
            int h = canvasHeight/data.getN();
            for (int i = 0 ; i < data.getN();i++){
                for (int j = 0; j<data.getM();j++){
                    if (data.getMaze(i,j)== MazeData.WALL)
                        AlgoVisHelper.setColor(g2d,AlgoVisHelper.LightBlue);
                    if (data.getMaze(i,j)== MazeData.PACE)
                        AlgoVisHelper.setColor(g2d,AlgoVisHelper.Yellow);
                    if (data.getMaze(i,j)== MazeData.RODA)
                        AlgoVisHelper.setColor(g2d,AlgoVisHelper.White);
                    AlgoVisHelper.fillRectangle(g2d,j*h,i*w,w,h);
                }
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


