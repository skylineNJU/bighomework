package vo;

public class RecipientVO extends ReceiptVO{
	private String name;
	public RecipientVO(String id, String da, String co) {
		super(id, da, co);
		// TODO Auto-generated constructor stub
	}
	public boolean setName(String na){
		name=na;
		return true;
	}
	
	public String getName(){
		return name;
	}
}
