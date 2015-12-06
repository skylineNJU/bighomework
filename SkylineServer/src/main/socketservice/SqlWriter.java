package main.socketservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlWriter {
	String driver="sun.jdbc.odbc.JdbcOdbcDriver";
	String connectDB="jdbc:odbc:Mysql";
	public SqlWriter(){
		try{
			Class.forName(driver);
		}catch(java.lang.ClassNotFoundException e){
			System.err.println(e);
		}
	}
	
	public void writeIntoSql(String listName,String content){
		try{
			
			Connection con=DriverManager.getConnection(connectDB);
			Statement stmt=con.createStatement();
			String query="INSERT INTO "+listName+" VALUES("+content+")";
			System.out.println(query);
			stmt.executeUpdate(query);
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}
