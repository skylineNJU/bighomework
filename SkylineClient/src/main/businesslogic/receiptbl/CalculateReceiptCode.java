package main.businesslogic.receiptbl;

public class CalculateReceiptCode {
	private String[] codelist=null;
	private String userName;
	public CalculateReceiptCode(String code,String userName){
		if(code!=null)
		setCodelist(code.split(" "));
		this.userName=userName;
	}
	
	public String getCalculatedCode(){
		if(codelist==null)
			return userName+"0000";
		return userName+Integer.parseInt(codelist[codelist.length-1].substring(userName.length()))+1;		
	}
	
	public String[] getCodelist() {
		return codelist;
	}
	public void setCodelist(String[] codelist) {
		this.codelist = codelist;
	}
}
