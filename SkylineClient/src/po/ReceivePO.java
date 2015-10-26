package po;
import java.io.Serializable;
//接收单
public class ReceivePO extends Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
 * 中转中心接收单号，收件人姓名，收件日期
 */
	
	String bar;
	String receivorName;
	String receiveDate;
	
	public ReceivePO(String a,String b,String c){
		bar = a;
		receivorName = b;
		receiveDate = c;
	}

	public String getBar() {
		return bar;
	}

	public String getReceivorName() {
		return receivorName;
	}

	public String getReceiveDate() {
		return receiveDate;
	}
	
	
}
