package businesslogic.rightbl;
import po.AccountPO;
import po.Rights;
import vo.AccountVO;
import vo.RightVO;
public class Account {

	private String ID;//员工账号名
	private String code;//密码
	private RightVO right;//权限
	private AccountPO po;
	private String initCode="000000";
	public Account(AccountVO ac){
		this.ID=ac.getAccountName();
		this.code=ac.getCode();
		this.right=ac.getRight();	
	}
	public Account(String string, String string2, RightVO rightInfo) {
		// TODO Auto-generated constructor stub
		this.ID=string;
		this.code=string2;
		this.right=rightInfo;
	}
	public Account(String oldCode, String newCode) {
		// TODO Auto-generated constructor stub
		this.code=newCode;
	}
	public Account(String iD2) {
		// TODO Auto-generated constructor stub
		this.ID=iD2;
		this.code=initCode;
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
	public RightVO getRight() {
		return right;
	}
	public void setRight(RightVO right) {
		this.right = right;
	}
	
	
}
