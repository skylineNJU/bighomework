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
	
	public boolean deleteData(String listname,String attribute,String content){
		String query="DELETE FROM "+listname+" WHERE "+attribute+"= '"+content+"'";
		System.out.println("-------------------============="+query);
		try {
			stmt.executeUpdate(query);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("³ö´í");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void clearTable(String tableName){
		String query="DELETE FROM "+tableName;
		try {
			stmt.executeUpdate(query);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("³ö´í");
			e.printStackTrace();
		}
	}
}
