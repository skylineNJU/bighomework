package test.data_stub;

import java.util.ArrayList;
import java.util.List;

import main.dataservice.FinanceDataService;
import main.po.BankAccountPO;
import main.po.CollectionPO;
import main.po.CostPO;

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
	public boolean readCost(String Date,List<CostPO> costList) {
		// TODO Auto-generated method stub
		readCost = new CostPO("工资",2007,"10",Date,60000,"6172271990182736654","01","无");
		costlist.clear();
		costlist.add(readCost);
		return true;
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
	public boolean delCost(CostPO costPO) {
		// TODO Auto-generated method stub
		System.out.println("-----------------Delect Success!-----------------");
		return true;
	}

	@Override
	//修改成本信息
	public boolean modifiyCost(CostPO costPO) {
		// TODO Auto-generated method stub
		costPO = new CostPO("工资",2007,"10","24",60000,"6172271990182736654","B公司","无");
		return true;
	}

	@Override
	//读取收入信息
	//收入项目应该为枚举类型
	//根据其类型在数据库里查找收入的具体信息
	public boolean readCollection(List<CollectionPO> Collectionlist) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2006,"12","09","01","6154434569087098711",91000,"无");
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return true;
	}

	@Override
	public boolean readCollection(String lobbyCode,List<CollectionPO> Collectionlist) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2007,"12","09",lobbyCode,"6154434569087098711",91000,"无");	
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return true;
	}

	@Override
	public boolean readCollection(String date1, String date2,List<CollectionPO> Collectionlist) {
		// TODO Auto-generated method stub
	    collectionPO = new CollectionPO(2008,"12","09","01","6154434569087098711",91000,"无");
		Collectionlist.clear();
		Collectionlist.add(collectionPO);
		return true;
	}

	@Override
	//将收入信息存储进数据库
	public boolean writeCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		System.out.println("---------------Write in database Success!---------------");
		return true;
	}

	@Override
	//修改收款信息
	public boolean modifiyCollection(CollectionPO collectionPO) {
		// TODO Auto-generated method stub
		collectionPO = new CollectionPO(2006,"12","09","01","6154434569087098711",10000,"无");
		return true;
	}

	@Override
	//从数据库里读取银行账户信息
	//根据银行账户的账户查找
	public boolean readBankAccount(String bankAccount,BankAccountPO account) {
		// TODO Auto-generated method stub
	    bankAccountPO=new BankAccountPO(bankAccount,10000000);
		return true;
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
