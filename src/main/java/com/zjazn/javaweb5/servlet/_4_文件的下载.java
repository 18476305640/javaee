package com.zjazn.javaweb5.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;




public class _4_文件的下载 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 文件的下载
         *
         */
        InputStream door = null;
        ServletOutputStream out = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date_format = simpleDateFormat.format(new Date());
            System.out.println(date_format+"访问了_4_文件的下载与上传");
            //1、要获取下载文件的路径
            String path = "***\\屏幕截图 2021-11-01 171236.png";
            //2、下载的文件名是啥？
            String filename = path.substring(path.lastIndexOf("\\") + 1);
            //3、设置想办法让浏览器能够支持 （Content-Disposition） 下载我们需要的东西， 中文文件名需要进行编码
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "UTF-8"));
            //4、获取下载文件的输入流
            door = this.getClass().getClassLoader().getResourceAsStream(filename);
            //5、创建缓冲区
            int len = 0;
            byte[] buffer = new byte[1024];
            //6、获取OutputStream对象
            out = response.getOutputStream();
            //7、将FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端
            while ((len=door.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }
        }finally {
            if (door != null) {
                door.close();
            }
            if (out != null) {
                out.close();
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

