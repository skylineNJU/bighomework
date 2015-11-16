package vo;

public class RecipientVO extends ReceiptVO{
	private String name;
	private String sendeePhone;
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
	
	/**
	 * ÖØÐ´
	 * @param id
	 * @param date
	 * @param code
	 * @param sendee
	 * @param sendeePhone
	 */
	public void write(String id, String date, String code,
			String sendee, String sendeePhone) {
		super.write(id,date,code);
		this.name = sendee;
		this.sendeePhone = sendeePhone;
	}
}
