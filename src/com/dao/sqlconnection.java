package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlconnection {

	// JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/addressbook?useSSL=false";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "123456";
    
    
    public static Connection getcon(){
    Connection conn = null;
    try{
        // ע�� JDBC ����
        Class.forName("com.mysql.jdbc.Driver");
    
        // ������
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
    }catch(SQLException se){
        // ���� JDBC ����
        se.printStackTrace();
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
	}
	return conn;
    }

}


