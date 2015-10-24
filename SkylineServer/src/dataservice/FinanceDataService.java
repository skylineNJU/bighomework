package dataservice;


import po.BankAccountPO;
import po.CollectionPO;
import po.CostPO;

import java.util.List;



//财务管理
public interface FinanceDataService {
	
	//读取成本收益表
	//成本项目为枚举类型
	//根据其类型查找在数据库里的成本具体信息
	public List<CostPO> readCost(String Date);
	
	//将成本的信息存储进数据库
	public boolean writeCost(CostPO costPO);
	
	//删除成本信息
	public void delCost(CostPO costPO);
	
	//修改成本信息
	public CostPO modifiyCost(CostPO costPO);
	
	//读取收入信息
	//收入项目应该为枚举类型
	//根据其类型在数据库里查找收入的具体信息
	public List<CollectionPO> readCollection();
	
	public List<CollectionPO> readCollection(String lobbyCode);
	
	public List<CollectionPO> readCollection(String date1,String date2);
	
	//将收入信息存储进数据库
	public void writeCollection(CollectionPO collectionPO);
	
	//删除收款信息
	//public void delCollection(CollectionPO collectionPO);
	
	//修改收款信息
	
	public CollectionPO modifiyCollection(CollectionPO collectionPO);
	
	//从数据库里读取银行账户信息
	//根据银行账户的账户查找
	public BankAccountPO readBankAccount(String bankAccount);
	
	//写信息
	public boolean writeBankAccount(BankAccountPO bankAccountPO);
	
	public boolean delBankAccount(BankAccountPO bankAccountPO);
	
}
