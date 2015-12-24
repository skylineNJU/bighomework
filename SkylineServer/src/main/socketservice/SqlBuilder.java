package main.socketservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlBuilder {
	private String JDriver="sun.jdbc.odbc.JdbcOdbcDriver";
	private String connectDB="jdbc:odbc:Mysql";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String tableName;
	
	public SqlBuilder(String tableName){
		try{
			Class.forName(JDriver);
			con=DriverManager.getConnection(connectDB);
			stmt=con.createStatement();
			this.tableName=tableName;
		}catch(Exception ex){
			System.err.println(ex);
		}
	}
	
	public boolean createTable(String[] listName){
		String query="create table "+tableName+"(";
		for(int x=0;x<listName.length-1;x++){
			query=query+listName[x]+",";
		}
		query=query+listName[listName.length-1];
		query=query+")";
		try {
			stmt.executeUpdate(query);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
