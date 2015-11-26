package main.vo;

public class RecipientVO extends ReceiptVO{
	private String name;
	private String sendeePhone;
	public RecipientVO(String id, String da, String co) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public boolean setName(String na){
		name=na;
		return true;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * ÖØÐ´
	 */
	public boolean write(String id, String date, String code,
			String sendee, String sendeePhone) {
		super.write(id,date,code);
		this.name = sendee;
		this.sendeePhone = sendeePhone;
		return true;
	}
}
