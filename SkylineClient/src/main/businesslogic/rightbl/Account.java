package main.businesslogic.rightbl;
import java.util.ArrayList;

import main.data.info.InfoDataController;
import main.data.load.LoadDataController;
import main.data.right.RightDataController;
import main.dataservice.InfoDataService;
import main.dataservice.LoadDataService;
import main.dataservice.RightDataService;
import main.po.AccountListPO;
import main.po.AccountPO;
import main.po.DriverInfoPO;
import main.po.DriverList;
import main.po.Rights;
import main.po.TrainLoadingPO;
import main.vo.AccountVO;
import main.vo.DriverVO;
public class Account {

	private String ID;//员工账号名
	private String code;//密码
	private Rights right;//权限
	private String belong;
	private AccountPO po;
	private RightDataService service;
	private AccountVO vo;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(AccountVO vo) {
		// TODO Auto-generated constructor stub
		this.ID=vo.getAccountName();
		this.code=vo.getCode();
		this.belong=vo.getBelong();
		this.vo=vo;
		this.right=vo.getRight();
		service=new RightDataController();
	}
	
	public AccountVO login(AccountVO vo){
		po=new AccountPO(ID,code,right,belong);
		po=service.login(po);
		System.out.println(po.getRight());
		vo.setRight(po.getRight());
		vo.setBelong(po.getBelong());
		return vo;
	}
	
	
	public Account(String oldCode, String newCode) {
		// TODO Auto-generated constructor stub
		this.code=newCode;
	}
	public Account(String iD2) {
		// TODO Auto-generated constructor stub
		this.ID=iD2;
	}
	public boolean saveInfo(){
		po=new AccountPO(ID,code,right,belong);
		po.setCode(code);
		RightDataService service=new RightDataController();
		service.writeAccount(po);
		return true;
	}
	public ArrayList<AccountVO> inquire(){
		RightDataService service=new RightDataController();
		po=new AccountPO();
		AccountListPO accountlist=new AccountListPO();
		accountlist.add(po);
		accountlist=service.inquireAccountList(accountlist);
		ArrayList<AccountVO> volist=new ArrayList<AccountVO>();
		for(AccountPO p:accountlist.getList()){
			volist.add(new AccountVO(p.getRight(),
					                                 p.getID(),
					                                 p.getCode(),
					                                 p.getBelong()
					));
		}
		return volist;
	}
	public boolean modify(){
		po=new AccountPO(this.ID,
				this.code,
				this.right,
				this.belong);
		RightDataService service=new RightDataController();
		service.modifyAcount(po);
		return true;
	}
	public ArrayList<AccountVO> inquire(String Code){
		RightDataService service=new RightDataController();
		po=new AccountPO(ID, Code, right, belong);
		AccountListPO accountlist=new AccountListPO();
		accountlist.add(po);
		accountlist=service.inquireAccountList(accountlist);
		ArrayList<AccountVO> volist=new ArrayList<AccountVO>();
		for(AccountPO p:accountlist.getList()){
			System.out.println(p.getID());
			volist.add(new AccountVO(p.getRight(),
									p.getID(),
									p.getCode(),
									p.getBelong()
									));
		}
		return volist;
	}
	
	public boolean delete(){
		DriverInfoPO po=new DriverInfoPO(code, code, code, code, code, code, code, code);
		InfoDataService service=new InfoDataController();
		service.deleteDriver(po);
		return true;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Rights getRight() {
		return right;
	}

	public void setRight(Rights right) {
		this.right = right;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public AccountPO getPo() {
		return po;
	}

	public void setPo(AccountPO po) {
		this.po = po;
	}

	public RightDataService getService() {
		return service;
	}

	public void setService(RightDataService service) {
		this.service = service;
	}

	public AccountVO getVo() {
		return vo;
	}

	public void setVo(AccountVO vo) {
		this.vo = vo;
	}

	public static boolean delete(String accountName) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
