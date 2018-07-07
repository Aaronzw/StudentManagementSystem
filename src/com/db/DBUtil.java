package com.db;

import java.sql.*;
public class DBUtil {
	
		private static final String URL="jdbc:sqlserver://localhost:1433; DatabaseName=CourseManagement";
		private static final String USER="sa";
		private static final String PASSWORD="12345678";
		private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		private static Connection conn=null;
		static {
			try {
				//1.加载驱动程序
				
					Class.forName(driver);
					//2.获得数据库的连接
					conn=DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){
			return conn;
		}
} 
	
