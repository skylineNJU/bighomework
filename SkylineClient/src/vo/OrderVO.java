package vo;

public class OrderVO extends ReceiptVO{
	String name1; String position1; String unit1;
	String phoneNumber1; String name2; String position2; String unit2;
	String phoneNumber2; int number; double weight; double Volume;
	String name3;String id; String data; String code; 
	public enum PackageCost{
		paperBox ,woodBox ,plasticPackage;
	}
	
	public enum Type{
		 fast,normal,cheap;
	}	  
	
	public enum Size{
		large,medium,small;	
	}//³ß´ç
	
	
	PackageCost packageCost;
	Type type;
	Size size;
	
	public OrderVO(String n1, String p1, String u1,
			String ph1, String n2, String p2, String u2,
			String ph2, int num, double W, double V,
			String n3, PackageCost pC,Type t,Size s,String id, String da, String co){
		
		super(id, da, co);
		 name1=n1;
		 position1=p1; 
		 unit1=u1;
		 phoneNumber1=ph1;
		 name2=n2;
		 position2=p2; 
		 unit2=u2;
		 phoneNumber2=ph2;
		 number=num;
		 weight=W; 
		 Volume=V;
		 name3=n3;
		 packageCost=pC;
		 type=t;
		 size=s;
	}
	
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getPosition1() {
		return position1;
	}
	public void setPosition1(String position1) {
		this.position1 = position1;
	}
	public String getUnit1() {
		return unit1;
	}
	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getPosition2() {
		return position2;
	}
	public void setPosition2(String position2) {
		this.position2 = position2;
	}
	public String getUnit2() {
		return unit2;
	}
	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getVolume() {
		return Volume;
	}
	public void setVolume(double volume) {
		Volume = volume;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public PackageCost getPackageCost() {
		return packageCost;
	}
	public void setPackageCost(PackageCost packageCost) {
		this.packageCost = packageCost;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public String getId() {
		return id;
	}
	public String getData() {
		return data;
	}
	
	
}
