package main.presentation.receiptui;

public class HtmlMultiLineControl {
	 private String strDest;
	    //����
	    private final String strHtmlBegin = 
	           "<html>"
	              + "<bgcolor color=#000080>"
	                  +"<font color=#0000cd >"
	                  +"<b>";
	    //����
	    private final String strHtmlEnd = 
	                  "</b>"
	                 +"</font>"
	             +"</bgcolor>"
	          +"</html>";
	    
	    public String CovertDestionString(String strDest){
	        
	        this.strDest = strHtmlBegin + strDest + strHtmlEnd;
	        return this.strDest;
	    }
}
