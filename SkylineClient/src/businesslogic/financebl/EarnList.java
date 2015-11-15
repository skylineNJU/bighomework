package businesslogic.financebl;

import java.util.ArrayList;

import vo.EarnVO;

public class EarnList {
	
	//从数据库里读取收益列表
	public boolean readEarnList(String code, String date1,
			String data2, ArrayList<EarnVO> earnList){
		//TODO
		return true;
	}
	
	public boolean readEarnList(String date,
			ArrayList<EarnVO> earnList){
		//TODO
		return true;
	}
	
	public boolean readEarnList(String date1, String date2,
			ArrayList<EarnVO> earnList){
		//TODO
		return true;
	}
	
	//写到数据库里面
	public boolean writeEarn(ArrayList<EarnVO> earnList){
		//TODO
		return true;
	}
}
