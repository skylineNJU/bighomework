package main.po;
import java.io.Serializable;

public class DistributePO extends Receipt implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * 閸掓媽鎻弮銉︽埂閵嗕焦澧潻鎰吂閸楁洘娼ぐ銏㈢垳閸欐灚锟戒焦娣抽柅浣告喅
 */
	String arriveDate;//鍒拌揪鏃ユ湡
	String bar;//娲句欢鍗曞彿
	String courrierName;//娲鹃�佸憳濮撳悕
	
	public DistributePO(String a,String b,String c){
		 arriveDate=a;
	     bar=b;
	     courrierName=c;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public String getBar() {
		return bar;
	}

	public String getCourrierName() {
		return courrierName;
	}
	
	
}
