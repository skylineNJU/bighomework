package data_stub;

import java.util.ArrayList;
import java.util.List;

import dataservice.FinanceDataService;
import po.BankAccountPO;
import po.CollectionPO;
import po.CostPO;

public class FinanceDataService_Stub implements FinanceDataService{
	List<CostPO> costlist =new ArrayList<CostPO>();
	CostPO readCost;
	List<CollectionPO> Collectionlist = new ArrayList<CollectionPO>();
	CollectionPO collectionPO;
	BankAccountPO bankAccountPO;
	
	@Override
	//读取成本收益表
	//成本项目为枚举类型
	//根据其类型查找在数据库里的成本具体信息
	public List<CostPO> readCost(String Date) {
		// TODO Auto-generated method stub
		readCost = new CostPO("工资",2007,"10",Date,60000,"6172271990182736654","01","无");
		costlist.clear();
		costlist.add(readCost);
		return null;
	}

	@Override
	//将成本的信息存储进数据库
	public boolean writeCost(CostPO costPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Save in database Success!-----------------");
		return true;
	}

	@Override
	//删除成本信息
	public void delCost(CostPO costPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Delect Success!-----------------");
	}

	@Override
	//修改成本信息
	public CostPO modifiyCost(CostPO costPO) {
		// TODO Auto-generated method stub
		costPO = new CostPO("工资",2007,"10","24",60000,"6172271990182736654","B公司","无");
		return costPO;
	}

	@Override
	//读取收入信息
	//收入项目应该为枚举类型
	//根据其类型在数据库里查找收入的具体信息
	public List<CollectionPO> readCollection() {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2006,"12","09","01","6154434569087098711",91000,"无");
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return Collectionlist;
	}

	@Override
	public List<CollectionPO> readCollection(String lobbyCode) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2007,"12","09",lobbyCode,"6154434569087098711",91000,"无");	
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return Collectionlist;
	}

	@Override
	public List<CollectionPO> readCollection(String date1, String date2) {
		// TODO Auto-generated method stub
	    collectionPO = new CollectionPO(2008,"12","09","01","6154434569087098711",91000,"无");
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return Collectionlist;
	}

	@Override
	//将收入信息存储进数据库
	public void writeCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		System.out.println("---------------Write in database Success!---------------");
	}

	@Override
	//修改收款信息
	public CollectionPO modifiyCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2006,"12","09","01","6154434569087098711",10000,"无");
		return collectionPO;
	}

	@Override
	//从数据库里读取银行账户信息
	//根据银行账户的账户查找
	public BankAccountPO readBankAccount(String bankAccount) {
		// TODO Auto-generated method stub
	    bankAccountPO=new BankAccountPO(bankAccount,10000000);
		return bankAccountPO;
	}

	@Override
	//写信息
	public boolean writeBankAccount(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Write Success!-----------------");
		return false;
	}

	@Override
	public boolean delBankAccount(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Delect Scuccess!-----------------");
		return false;
	}

}
