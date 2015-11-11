package vo;

public class ReceiptVO {
	private boolean isApprovaled=false;
	private String ID;
	private String date;
	private String code;
	private ReceiptType type;
	
	public ReceiptVO(String id,String da,String co){
		ID=id;
		date=da;
		code=co;
	}
	public boolean isApprovaled() {
		return isApprovaled;
	}

	public void setApprovaled(boolean isApprovaled) {
		this.isApprovaled = isApprovaled;
	}

	public String getID() {
		return ID;
	}

	public String getDate() {
		return date;
	}

	public String getCode() {
		return code;
	}
	public ReceiptType getType() {
		return type;
	}
	public void setType(ReceiptType type) {
		this.type = type;
	}

	
	
}
