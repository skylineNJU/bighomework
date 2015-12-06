package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.DistributeVO;
import main.vo.RecipientVO;

public interface DistributeBLService {
	//显示派件单列表
	public ArrayList<DistributeVO> showDistributeList(String courierCode);
	
	public boolean writeDistributeList(ArrayList<DistributeVO> voList);
	
	//收件单中填写收件编码，收件人姓名，收件日期，系统显示填写的信息
	public boolean writeReceiveMessage(RecipientVO recipient);
}
