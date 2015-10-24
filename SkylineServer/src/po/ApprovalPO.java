package po;

import java.util.List;

//审批未通过单号
public class ApprovalPO {

	List<String> code;

	public ApprovalPO(List<String> code) {
		super();
		this.code = code;
	}

	public List<String> getCode() {
		return code;
	}

	public void setCode(List<String> code) {
		this.code = code;
	}
	
}
