package businesslogic.rightbl;
import po.AccountPO;
import po.Rights;
import vo.AccountVO;
public class Account {

	private String ID;//Ա���˺���
	private String code;//����
	private Rights right;//Ȩ��
	private AccountPO po;
	
	public Account(AccountVO ac){
		this.ID=ac.getAccountName();
		this.code=ac.getCode();
		this.right=ac.getRight();	
	}
	public boolean saveInfo(){
		return true;
	}
	
	public boolean modify(){
		return true;
	}
//	private boolean inquire(String driverCode){
//		
//		return true;
//		
//	}
//	
//	public static boolean delete(String driverCode){
//		return true;
//	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Rights getRight() {
		return right;
	}
	public void setRight(Rights right) {
		this.right = right;
	}
	
}
