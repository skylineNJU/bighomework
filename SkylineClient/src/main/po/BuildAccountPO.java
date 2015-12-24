package main.po;

import java.util.LinkedList;


public class BuildAccountPO extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<String> name=new LinkedList<String>();
	private LinkedList<String> date=new LinkedList<String>();
	private int id=0;
	
	public void addAccount(String name,String date,int id){
		this.name.add(name);
		this.date.add(date);
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
