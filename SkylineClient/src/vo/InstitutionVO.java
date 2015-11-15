package vo;

import businesslogic.infobl.Institution;

public class InstitutionVO {
	private String Category;
	private String name;
	private String position;
	private String code;
	public InstitutionVO(String ca,String na,String po,String co){
		Category=ca;
		name=na;
		position=po;
		code=co;
	}
	
	public boolean writeInstitutionVO(Institution ins){
		this.Category=ins.getCategory();
		this.name=ins.getName();
		this.code=ins.getCode();
		this.position=ins.getPosition();
		return true;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
