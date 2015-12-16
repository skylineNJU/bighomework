package main.socketservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlReader {
	private String JDriver="sun.jdbc.odbc.JdbcOdbcDriver";
	private String connectDB="jdbc:odbc:Mysql";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private String tableName;
	public SqlReader(String tableName){
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
	
	public void update(String attribute,String content,String label,String labelContent){
		String query="update "+this.tableName+" set "+attribute+"='"+content+"' where "+label+"='"+labelContent+"'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//attribute属性，属性的内容等于content时，就获取这一行
	public boolean findNext(String attribute,String content){
		System.out.println(attribute+" "+content);
		try {
			while(rs.next()){
				if(rs.getString(attribute).equals(content))
					return true;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		return false;
	}
	
	public boolean hasNext(){
		try {
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getString(String attribute){
		String contents=null;
		try {
			contents=rs.getString(attribute);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}
	
	public int getInt(String attribute){
		int contents=0;
		try {
			contents=rs.getInt(attribute);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}
	
	public double getDouble(String attribute){
		double contents=0;
		try {
			contents=rs.getDouble(attribute);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}
	
	
}
