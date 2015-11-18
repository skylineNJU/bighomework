package main.po;
import java.io.Serializable;
//鎺ユ敹鍗�
public class ReceivePO extends Receipt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
 * 涓浆涓績鎺ユ敹鍗曞彿锛屾敹浠朵汉濮撳悕锛屾敹浠舵棩鏈�
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
