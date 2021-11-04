package com.zjazn.javaweb5.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.IOException;
import java.util.Random;

/**
 * 生成验证码：
 *      BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
 *      Graphics2D g = (Graphics2D)image.getGraphics();
 */
public class _5_生成验证码 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //在内存中创建一个图片
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取笔
        Graphics2D g = (Graphics2D)image.getGraphics();
        //写
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        g.setColor(Color.RED);
        g.setFont(new Font(null, Font.BOLD, height-6));
        g.drawString( getRandomString(),height/3,height-4);
        //告诉浏览器以图片的形式打开
        response.setContentType("image/jpg");
        //不让浏览器缓存
        response.setDateHeader("expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //自动刷新
        response.setHeader("refresh","3");
        //接入response输出流中
        ImageIO.write(image,"jpg", response.getOutputStream());




    }

    public String getRandomString() {
        String source = "0123456789zhuangjie";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
