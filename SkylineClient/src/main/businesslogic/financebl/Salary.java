package main.businesslogic.financebl;

import main.data.finance.FinanceDataController;
import main.dataservice.FinanceDataService;
import main.po.SalaryPO;
import main.vo.SalaryVO;

public class Salary {
	
	public SalaryVO getSalary(){
		FinanceDataService finance = new FinanceDataController();
		SalaryPO salaryPO = finance.readSalary();
		SalaryVO salaryVO = new SalaryVO();
		salaryVO.setAdminSalary(salaryPO.getAdminSalary());
		salaryVO.setAdminCommission(salaryPO.getAdminCommission());
		salaryVO.setCourierSalary(salaryPO.getCourierSalary());
		salaryVO.setCourierCommission(salaryPO.getCourierCommission());
		salaryVO.setDriverSalary(salaryPO.getDriverSalary());
		salaryVO.setDriverCommission(salaryPO.getDriverCommission());
		salaryVO.setFinanceSalary(salaryPO.getFinanceSalary());
		salaryVO.setFinanceCommission(salaryPO.getFinanceCommission());
		salaryVO.setIntermediateSalary(salaryPO.getIntermediateSalary());
		salaryVO.setIntermediateCommission(salaryPO.getIntermediateCommission());
		salaryVO.setLobbySalary(salaryPO.getLobbySalary());
		salaryVO.setLobbyCommission(salaryPO.getLobbyCommission());
		salaryVO.setManagerSalary(salaryPO.getManagerSalary());
		salaryVO.setManagerCommission(salaryPO.getManagerCommission());
		salaryVO.setWarehouseSalary(salaryPO.getWarehouseSalary());
		salaryVO.setWareHouseCommission(salaryPO.getWareHouseCommission());
		return salaryVO;
	}
	
	public boolean writeSalary(SalaryVO salaryVO){
		FinanceDataService finance = new FinanceDataController();
		SalaryPO salaryPO = new SalaryPO();
		salaryPO.setAdminSalary(salaryVO.getAdminSalary());
		salaryPO.setAdminCommission(salaryVO.getAdminCommission());
		salaryPO.setCourierSalary(salaryVO.getCourierSalary());
		salaryPO.setCourierCommission(salaryVO.getCourierCommission());
		salaryPO.setDriverSalary(salaryVO.getDriverSalary());
		salaryPO.setDriverCommission(salaryVO.getDriverCommission());
		salaryPO.setFinanceSalary(salaryVO.getFinanceSalary());
		salaryPO.setFinanceCommission(salaryVO.getFinanceCommission());
		salaryPO.setIntermediateSalary(salaryVO.getIntermediateSalary());
		salaryPO.setIntermediateCommission(salaryVO.getIntermediateCommission());
		salaryPO.setLobbySalary(salaryVO.getLobbySalary());
		salaryPO.setLobbyCommission(salaryVO.getLobbyCommission());
		salaryPO.setManagerSalary(salaryVO.getManagerSalary());
		salaryPO.setManagerCommission(salaryVO.getManagerCommission());
		salaryPO.setWarehouseSalary(salaryVO.getWarehouseSalary());
		salaryPO.setWareHouseCommission(salaryVO.getWareHouseCommission());
		return finance.writeSalary(salaryPO);
	}
	
	public boolean delSalary(SalaryVO salaryVO){
		FinanceDataService finance = new FinanceDataController();
		SalaryPO salaryPO = new SalaryPO();
		salaryPO.setAdminSalary(salaryVO.getAdminSalary());
		salaryPO.setAdminCommission(salaryVO.getAdminCommission());
		salaryPO.setCourierSalary(salaryVO.getCourierSalary());
		salaryPO.setCourierCommission(salaryVO.getCourierCommission());
		salaryPO.setDriverSalary(salaryVO.getDriverSalary());
		salaryPO.setDriverCommission(salaryVO.getDriverCommission());
		salaryPO.setFinanceSalary(salaryVO.getFinanceSalary());
		salaryPO.setFinanceCommission(salaryVO.getFinanceCommission());
		salaryPO.setIntermediateSalary(salaryVO.getIntermediateSalary());
		salaryPO.setIntermediateCommission(salaryVO.getIntermediateCommission());
		salaryPO.setLobbySalary(salaryVO.getLobbySalary());
		salaryPO.setLobbyCommission(salaryVO.getLobbyCommission());
		salaryPO.setManagerSalary(salaryVO.getManagerSalary());
		salaryPO.setManagerCommission(salaryVO.getManagerCommission());
		salaryPO.setWarehouseSalary(salaryVO.getWarehouseSalary());
		salaryPO.setWareHouseCommission(salaryVO.getWareHouseCommission());
		return finance.delSalary(salaryPO);
	}
}
