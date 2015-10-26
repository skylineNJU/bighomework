package po;

import java.util.List;

//记录每个人写过的单据的编码
public class StaffReceiptPO extends Message{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String account;
	List<String> code;
	
	public StaffReceiptPO(String account, List<String> code) {
		this.account = account;
		this.code = code;
	}

	public String getAccount() {
		return account;
	}

	public List<String> getCode() {
		return code;
	}

	public void setCode(List<String> code) {
		this.code = code;
	}
	
}
