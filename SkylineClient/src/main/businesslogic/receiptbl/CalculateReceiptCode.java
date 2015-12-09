package main.businesslogic.receiptbl;

import java.util.Calendar;

public class CalculateReceiptCode {
	private String[] codelist=null;
	private String userName;
	public CalculateReceiptCode(String code,String userName){
		if(code!=null)
		setCodelist(code.split(" "));
		else
			System.out.println("some thing goes wrong");
		this.userName=userName;
	}
	
	public String getCalculatedCode(){
		Calendar now = Calendar.getInstance();  
		int year=now.get(Calendar.YEAR);
		year=year%100;
		if(codelist.length==1){
			return userName+codelist[0]+year+"000000";
		}
		
		String str=codelist[codelist.length-1].substring(userName.length()+1);
		System.out.println(str+"-------+++++++++------------");
		int num=Integer.parseInt(str);
		if(num/1000000==year){
			num=num+1;
		}else{
			num=year*1000000;
		}
		System.out.println(num);
		return userName+codelist[0]+num;		
	}
	
	public String[] getCodelist() {
		return codelist;
	}
	public void setCodelist(String[] codelist) {
		this.codelist = codelist;
	}
}
