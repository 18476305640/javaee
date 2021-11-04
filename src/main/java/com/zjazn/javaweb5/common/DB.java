package com.zjazn.javaweb5.common;

import java.sql.*;

public class DB {
    public static void main(String[] args) throws Exception{
        try {
            String url = "jdbc:mysql://192.168.87.101:3306/test?useUnicode=true&amp;characterEncoding=utf8&useSSL=true";
            String user = "root";
            String password = "3333";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            //Statement statement = conn.createStatement();
            //conn.setAutoCommit(false);//开启事务
            //conn.rollback(); //catch 异常，回滚操作
            String sql = "insert  into user(username, password, fulname,logon_time) values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"zhuangjie");
            preparedStatement.setString(2,"3333");
            preparedStatement.setString(3,"zhuangjie");
            preparedStatement.setDate(4,new Date(new java.util.Date().getTime()));

            int i = preparedStatement.executeUpdate();
            if (i>0) {
                System.out.println("插入成功！");
            }else {
                System.out.println("插入失败！");

            }
            preparedStatement.close();
            conn.close();
        }finally {

        }



    }
}
