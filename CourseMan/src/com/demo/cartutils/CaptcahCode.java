package com.demo.cartutils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;


/**
 *验证码工具类
 */
public class CaptcahCode {


    public static String drawImage(HttpServletResponse response) {
     StringBuilder  builder=new StringBuilder();
     //1:五个随机字符拼接
        for (int i = 0; i < 4; i++) {
            builder.append(randomChar());
        }
        String code=builder.toString();
        //2:定义图片
        int width=80;
        int height=25;
        //简历BufferefImage对象 ，制定图片的长、宽、色彩
        BufferedImage bi=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g=bi.createGraphics();
        Font font=new Font("微软雅黑",Font.PLAIN,20);
        Color color=new Color(0,0,0);
        g.setFont(font);
        g.setColor(color);
        g.setBackground(new Color(226,226,240));
        //开始绘制对象
        g.clearRect(0,0,width,height);
        Random random=new Random();
        for (int i = 0; i <10 ; i++) {
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(60);
            int y1=random.nextInt(60);
            g.setColor(getRandomColor(150,256));
            g.drawLine(x,y,x1,y1);
        }
        //绘制矩形，获取矩形对象
        g.setColor(getRandomColor(50,230));

        FontRenderContext context=g.getFontRenderContext();
        Rectangle2D bounds=font.getStringBounds(code,context);
        //计算文字的坐标和间距
        double x=(width-bounds.getWidth())/2;
        double y=(height-bounds.getHeight())/2;
        double ascent=bounds.getY();
        double basey=y-ascent;
        g.drawString(code,(int)x,(int)basey);
        //结束绘制
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", response.getOutputStream());
            //刷新响应流
            response.flushBuffer();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  code;
    }
    //范围随机颜色
    public  static  Color getRandomColor(int fc ,int bc){
        Random random=new Random();
        //rgb三原色 0-255
        if(fc>255)fc=255;
        if (bc>255)bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }

    private static char randomChar() {
        String string="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789";
        Random random=new Random();
        return string.charAt(random.nextInt(string.length()));
    }

}
