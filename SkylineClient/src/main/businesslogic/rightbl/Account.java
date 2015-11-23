package main.businesslogic.rightbl;
import main.po.AccountPO;
import main.po.Rights;
import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.RightVO;
public class Account {

	private String ID;//员工账号名
	private String code;//密码
	private RightVO right;//权限
	private String belong;
	private AccountPO po;
	
	
	public Account(AccountVO vo) {
		// TODO Auto-generated constructor stub
		this.ID=vo.getAccountName();
		this.code=vo.getCode();
		this.belong=vo.getBelong();
	}
	
	public Account(String oldCode, String newCode) {
		// TODO Auto-generated constructor stub
		this.code=newCode;
	}
	public Account(String iD2) {
		// TODO Auto-generated constructor stub
		this.ID=iD2;
	}
	public boolean saveInfo(){
		return true;
	}
	
	public boolean modify(){
		return true;
	}
	public boolean inquire(String ID){
		
		return true;
		
	}
	
	public static boolean delete(String ID){
		return true;
	}
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
