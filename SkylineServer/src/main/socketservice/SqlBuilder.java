package main.socketservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			rs=stmt.executeQuery("select * from "+tableName);
			this.tableName=tableName;
		}catch(Exception ex){
			System.err.println(ex);
		}
	}
}
