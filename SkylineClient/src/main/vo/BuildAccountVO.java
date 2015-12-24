package main.vo;

import java.util.LinkedList;

public class BuildAccountVO {
	private LinkedList<String> name=new LinkedList<String>();
	private LinkedList<String> date=new LinkedList<String>();
	private int id=0;
	
	public void addAccount(String name,String date,int id){
		this.name.add(name);
		this.date.add(date);
		this.id=id;
	}

	public LinkedList<String> getName() {
		return name;
	}

	public void setName(LinkedList<String> name) {
		this.name = name;
	}

	public LinkedList<String> getDate() {
		return date;
	}

	public void setDate(LinkedList<String> date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
