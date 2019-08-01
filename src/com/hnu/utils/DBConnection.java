package com.hnu.utils;

import java.sql.*;

public class DBConnection
{
    private final String DBDRIVER = "com.mysql.jdbc.Driver";
    private final String DBURL = "jdbc:mysql://localhost:3306/mailsystem?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "4030";
    private Connection conn=null;
    
    public DBConnection()
    {
        try
        {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e)
        {
            // TODO Auto-generated catch block
            System.out.println("加载驱动失败");
        }

    }
    
    public Connection getConnection()
    {
        return this.conn;
    }
    
    public void close()
    {
        if(this.conn!=null)
        {
            try
            {
                this.conn.close();
            } catch (SQLException e)
            {
                // TODO Auto-generated catch block
                System.out.println("数据库连接关闭失败");
            }
        }
    }
}