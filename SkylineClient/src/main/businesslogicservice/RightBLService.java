package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.DriverVO;
import main.vo.StaffVO;

public interface RightBLService {
	//用户输入账户名称，密码来登录,系统根据返回的权限来跳转页面
	public boolean login(AccountVO account);
	
	//账户管理人员创建新的账户，系统显示账户信息
	public boolean createNewAccount(AccountVO accountInfo);
	//账户管理人员查询账户
	public boolean inquireAccount(String code,AccountVO account);
	
	//公司职工修改账户密码，需输入旧的密码和新的密码
	public boolean modifyCode(String oldCode,String newCode);
	
	//财务人员可以帮助公司员工初始化密码，需输入职工账号
	public boolean initCode(String ID);
	
	ArrayList<AccountVO> inquireAccount(String code);

	//删除一个账号信息，系统显示删除成功
	public boolean deleteAccount(String accountName);
		
		
	//修改账号信息，系统显示修改后的职工信息
	public boolean modifyAccount(AccountVO accountInfo);

	public ArrayList<AccountVO> inquireAccount();
}
