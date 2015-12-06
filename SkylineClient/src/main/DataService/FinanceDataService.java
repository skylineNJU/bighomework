package main.dataservice;

import java.util.ArrayList;

import main.po.BankAccountPO;
import main.po.BankList;
import main.po.CollectionPO;
import main.po.CollectionPOList;
import main.po.CostPO;
import main.po.CostPOList;
import main.po.DistancePO;
import main.po.FeePO;
import main.po.LobbyEarnPO;
import main.po.SalaryPO;
//财务管理
public interface FinanceDataService {
	
	public boolean delFee(FeePO feePO);
	
	public boolean delCollection(CollectionPO collectionPO);
	
	public boolean delDistance(DistancePO distancePO);
	
	public boolean deleteCost(CostPO costPO);
	
	public boolean modifyBalance(BankAccountPO bankPO);
	
	public SalaryPO readSalary();
	
	public boolean delSalary(SalaryPO salaryPO);
	
	public FeePO readFee();
	
	public LobbyEarnPO readLobbyEarn(String date,String unit);
	
	public CostPOList readCost(String date);

	//将成本的信息存储进数据库
	public boolean writeCost(CostPO costPO);
	
	//修改成本信息
	public boolean modifiyCost(CostPO costPO);
	
	public CollectionPOList readCollection(String date);
	
	//将收入信息存储进数据库
	public boolean writeCollection(CollectionPO collectionPO);
	
	//修改收款信息
	
	public boolean modifiyCollection(CollectionPO collectionPO);
	
	//从数据库里读取银行账户信息
	//根据银行账户的账户查找
	public BankList readBankAccount();
	
	//写信息
	public boolean writeBankAccount(BankAccountPO bankAccountPO);
	
	public boolean writeSalary(SalaryPO salaryPO);
	
	public DistancePO readDistance();
	
	public boolean writeFee(FeePO feePO);
	
	public boolean writeDistance(DistancePO distancePO);
}
