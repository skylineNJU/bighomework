package po;
import java.io.Serializable;

public class ReceivePO implements Serializable{
/*
 * 收件编号（订单条形码）,输入收件人姓名以及收件日期
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
