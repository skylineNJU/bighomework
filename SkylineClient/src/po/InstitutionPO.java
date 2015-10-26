package po;

import java.io.Serializable;

public class InstitutionPO extends Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String kinds;
	private String situation;
	private String ID;
	private String name;
	
	public InstitutionPO(String ki,String si,String id,String na){
		this.kinds=ki;
		this.situation=si;
		this.ID=id;
		this.name=na;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
