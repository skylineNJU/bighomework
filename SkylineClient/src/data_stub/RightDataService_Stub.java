package data_stub;

import dataservice.RightDataService;
import po.AccountPO;
import State.RightType;

public class RightDataService_Stub implements RightDataService {
	

	//密码初始化
	//输入账户，将数据库中的账户密码设置为初始值
	public boolean initKeyWord(String account){
		System.out.println("init Succeed!/n");
		return true;
	}
	
	//删除账户
	//输入账户，将数据库中的账户删除
	public boolean delAccount(String account){
		System.out.println("delete Succeed!/n");
		return true;
	}
	
	//增加权限
	//权限应该设置为枚举类型
	//rightType为需要增加的权限
	public boolean changeRight(AccountPO accountPO){
		System.out.println("change Succeed!/n");
		return true;
	}
	
	//从数据库中读取该账户的权限
	public RightType readRight(String accpunt){
		System.out.println("Succeed!/n");
		return RightType.LOOKTASK;
	}

}
