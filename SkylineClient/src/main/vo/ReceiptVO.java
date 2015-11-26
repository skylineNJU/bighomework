package main.vo;

public class ReceiptVO {
	private boolean isApprovaled=false;
	protected String ID;
	protected String date;
	protected String code;
	protected ReceiptType type;
	
	//无参数构造函数
	public ReceiptVO(){}
	public ReceiptVO(String id,String date,String code){
		this.ID=id;
		this.date=date;
		this.code=code;
	}
	public void write(ReceiptVO receiptVO){
		this.ID = receiptVO.getID();
		this.date = receiptVO.getDate();
		this.code = receiptVO.getCode();
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
