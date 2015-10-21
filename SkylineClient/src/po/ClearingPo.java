package po;

import java.io.Serializable;
import java.util.LinkedList;

public class ClearingPo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<CollectionPo> collection=new LinkedList<CollectionPo>();
	private String date;
	public ClearingPo(String da){
		date=da;
	}
	public void add(CollectionPo co){
		collection.add(co);
	}
	
	public LinkedList<CollectionPo> get(){
		return collection;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
