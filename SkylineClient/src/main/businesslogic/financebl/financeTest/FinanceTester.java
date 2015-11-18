package main.businesslogic.financebl.financeTest;

import java.util.ArrayList;

import org.junit.Test;

import main.vo.AccountVO;
import main.vo.CostVO;
import main.vo.EarnVO;
import static org.junit.Assert.*;
import main.businesslogic.financebl.FinanceController;

public class FinanceTester extends FinanceController{

	String name = "50163046831";
	AccountVO accountVO = new AccountVO(this.name, 20122.2);
	
	@Test
	public boolean showStatisticsList(String date1, String date2,
			ArrayList<EarnVO> earnList,ArrayList<CostVO> costList) {
		MockEarnList earn = new MockEarnList();
		MockCostList cost = new MockCostList();
		earn.readEarnList(date1, date2, earnList);
		cost.readCostList(date1, date2, costList);
		assertEquals("증합", costList.get(0).getID());
		assertEquals("15168168",earnList.get(0).getCode());
		return false;
	}

	@Test
	public boolean showEarnListDependsOnDay(String date,ArrayList<EarnVO> earnList) {
		MockEarnList earn = new MockEarnList();
		earn.readEarnList(date, earnList);
		assertEquals("15168168",earnList.get(0).getCode());
		return false;
	}

	@Test
	public boolean showEarnListDependsOnInstitution(String code, String date1,
			String data2, ArrayList<EarnVO> earnList) {
		MockEarnList earn = new MockEarnList();
		earn.readEarnList(code, date1, data2, earnList);
		assertEquals("15168168",earnList.get(0).getCode());
		return false;
	}

	@Test
	public boolean showBalance(String name, AccountVO account) {
		account = accountVO;
		MockBalance balance = new MockBalance();
		balance.readBalance(name, account);
		assertEquals(this.name,account.getAccountName());
		return false;
	}

	@Test
	public boolean showCostList(ArrayList<CostVO> costList) {
		MockCostList cost = new MockCostList();
		cost.readCostList(costList);
		assertEquals("증합", costList.get(0).getID());
		return false;
	}

	@Test
	public boolean showCostList(String date, ArrayList<CostVO> costList) {
		MockCostList cost = new MockCostList();
		cost.readCostList(date, costList);
		assertEquals("증합", costList.get(0).getID());
		return false;
	}

	@Test
	public boolean writeEarnList(ArrayList<EarnVO> earnList) {
		MockEarnList earn = new MockEarnList();
		assertEquals(true,earn.writeEarn(earnList));
		return false;
	}

	@Test
	public boolean writeCostList(ArrayList<CostVO> costList) {
		MockCostList cost = new MockCostList();
		assertEquals(true,cost.writeCostList(costList));
		return false;
	}
}
