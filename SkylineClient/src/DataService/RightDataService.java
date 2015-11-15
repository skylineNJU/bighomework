package dataservice;

import po.AccountPO;
import State.RightType;

//权限管理数据接口
public interface RightDataService {

	//密码初始化
	//输入账户，将数据库中的账户密码设置为初始值
	public boolean initKeyWord(String account);
	
	//删除账户
	//输入账户，将数据库中的账户删除
	public boolean delAccount(String account);
	
	//增加权限
	//权限应该设置为枚举类型
	//rightType为需要增加的权限
	public boolean changeRight(AccountPO accountPO);
	
	//从数据库中读取该账户的权限
	public boolean readRight(String account,RightType rightType);
}
