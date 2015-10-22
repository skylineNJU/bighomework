package logicservice;

import java.util.ArrayList;

import vo.DistributeVO;
import vo.RecipientVO;

public interface DistributeBLService {
	//显示派件单列表
	public ArrayList<DistributeVO> showDistributeList();
	
	//收件单中填写收件编码，收件人姓名，收件日期，系统显示填写的信息
	public RecipientVO writeReceiveMessage(String code,String name,String date);
}
