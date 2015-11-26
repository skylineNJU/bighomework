package main.socketservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDeleter {
	private String JDriver="sun.jdbc.odbc.JdbcOdbcDriver";
	private String connectDB="jdbc:odbc:Mysql";
	private Connection con;
	private Statement stmt;
	public SqlDeleter(){
		try{
			Class.forName(JDriver);
			con=DriverManager.getConnection(connectDB);
			stmt=con.createStatement();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public void deleteData(String listname,String attribute,String content){
		String query="DELETE FROM "+listname+" WHERE "+attribute+"='"+content+"'";
		try {
			stmt.executeUpdate(query);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
