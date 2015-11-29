package main.businesslogic.receiptbl;

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
		if(codelist.length==1)
			return userName+codelist[0]+"0000";
		int num=Integer.parseInt(codelist[codelist.length-1].substring(userName.length()+1))+1;
		System.out.println(num);
		return userName+String.format("%04d",num);		
	}
	
	public String[] getCodelist() {
		return codelist;
	}
	public void setCodelist(String[] codelist) {
		this.codelist = codelist;
	}
}
