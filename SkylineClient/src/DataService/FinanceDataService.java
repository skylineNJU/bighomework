package dataservice;

import java.util.List;

import po.BankAccountPO;
import po.CollectionPO;
import po.CostPO;

//财务管理
public interface FinanceDataService {
	
	//读取成本收益表
	//成本项目为枚举类型
	//根据其类型查找在数据库里的成本具体信息
	public boolean readCost(String Date,List<CostPO> costPOList);
	
	//将成本的信息存储进数据库
	public boolean writeCost(CostPO costPO);
	
	//删除成本信息
	public boolean delCost(CostPO costPO);
	
	//修改成本信息
	public boolean modifiyCost(CostPO costPO);
	
	//读取收入信息
	//收入项目应该为枚举类型
	//根据其类型在数据库里查找收入的具体信息
	public boolean readCollection(List<CollectionPO> collectionPOList);
	
	public boolean readCollection(String lobbyCode,List<CollectionPO> collectionPOList);
	
	public boolean readCollection(String date1,String date2,List<CollectionPO> collectionPOList);
	
	//将收入信息存储进数据库
	public boolean writeCollection(CollectionPO collectionPO);
	
	//删除收款信息
	//public void delCollection(CollectionPO collectionPO);
	
	//修改收款信息
	
	public boolean modifiyCollection(CollectionPO collectionPO);
	
	//从数据库里读取银行账户信息
	//根据银行账户的账户查找
	public boolean readBankAccount(String bankAccount,BankAccountPO bankaccountPO);
	
	//写信息
	public boolean writeBankAccount(BankAccountPO bankAccountPO);
	
	public boolean delBankAccount(BankAccountPO bankAccountPO);
	
}
