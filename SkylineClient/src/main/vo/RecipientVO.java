package main.vo;

public class RecipientVO extends ReceiptVO{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String sendeePhone;
	private String code;
	private String date;
	private String courierCode;
	public RecipientVO(String name, String sendeePhone, String code,
			String date, String courierCode) {
		super(code);
		this.name = name;
		this.sendeePhone = sendeePhone;
		this.code = code;
		this.date = date;
		this.courierCode = courierCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSendeePhone() {
		return sendeePhone;
	}
	public void setSendeePhone(String sendeePhone) {
		this.sendeePhone = sendeePhone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCourierCode() {
		return courierCode;
	}
	public void setCourierCode(String courierCode) {
		this.courierCode = courierCode;
	}
	
}