package po;
import java.io.Serializable;

public class DistributePO extends Message implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
 * 鍒拌揪鏃ユ湡銆佹墭杩愯鍗曟潯褰㈢爜鍙枫�佹淳閫佸憳
 */
	String arriveDate;//到达日期
	String bar;//派件单号
	String courrierName;//派送员姓名
	
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
