package po;
import java.io.Serializable;

public class DistributePO implements Serializable{
/*
 * 到达日期、托运订单条形码号、派送员
 */
	String arriveDate;
	String bar;
	String courrierName;
	
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
