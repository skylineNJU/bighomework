package vo;

public class VehicleVO {
	private String name;
	private String code;
	private String age;
	public VehicleVO(String na,String co,String ag){
		name=na;
		code=co;
		age=ag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
