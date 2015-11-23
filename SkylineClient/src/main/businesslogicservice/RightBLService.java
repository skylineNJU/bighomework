package main.businesslogicservice;

import main.vo.AccountVO;
import main.vo.BankAccountVO;
import main.vo.RightVO;

public interface RightBLService {
	//用户输入账户名称，密码来登录,系统根据返回的权限来跳转页面
	public boolean login(String AccountName,String code,AccountVO account);
	
	//账户管理人员创建新的账户，系统显示账户信息
	public boolean createNewAccount(BankAccountVO accountInfo);
	
	//公司职工修改账户密码，需输入旧的密码和新的密码
	public boolean modifyCode(String oldCode,String newCode);
	
	//财务人员可以帮助公司员工初始化密码，需输入职工账号
	public boolean initCode(String ID);
}
