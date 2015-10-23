package po;

import java.io.Serializable;
import java.util.LinkedList;

public class ClearingPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<CollectionPO> collection=new LinkedList<CollectionPO>();
	private String date;
	public ClearingPO(String da){
		date=da;
	}
	public void add(CollectionPO co){
		collection.add(co);
	}
	
	public LinkedList<CollectionPO> get(){
		return collection;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
