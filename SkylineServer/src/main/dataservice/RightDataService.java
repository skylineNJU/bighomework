package main.dataservice;

import java.util.List;

import main.po.AccountPO;
import main.po.PlaneLoadingPO;
import main.po.TrainLoadingPO;
import main.State.RightType;

//权限管理数据接口
public interface RightDataService {

	//密码初始化
	//输入账户，将数据库中的账户密码设置为初始值
	public boolean initKeyWord(String account);
	//新建账户
	public void writeAccount(List<AccountPO> loadList,String accountCode);
	//删除账户
	//输入账户，将数据库中的账户删除
	public void delAccount(List<AccountPO> accountList);
	public void delAccount();
	
	//增加权限
	//权限应该设置为枚举类型
	//rightType为需要增加的权限
	public boolean changeRight(AccountPO accpuntPO);
	
	//从数据库中读取该账户的权限
	public RightType readRight(String account);
	
	//从数据库读取账户信息  LoadList是装运信息
		public List<AccountPO> readAccount();
		
	
		
}
