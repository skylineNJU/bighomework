package businesslogic.financebl.financeTest;

import java.util.ArrayList;

import vo.EarnVO;

public class EarnListTester {
	
	EarnVO earnVO = new EarnVO("253156", "2015/03/15", "15168168");
	
	public boolean readEarnList(String code, String date1,
			String data2, ArrayList<EarnVO> earnList){
		earnList.set(0, earnVO);
		return true;
	}
	
	public boolean readEarnList(String date,
			ArrayList<EarnVO> earnList){
		earnList.set(0, earnVO);
		return true;
	}
	
	public boolean readEarnList(String date1, String date2,
			ArrayList<EarnVO> earnList){
		earnList.set(0, earnVO);
		return true;
	}
	
	//写到数据库里面
	public boolean writeEarn(ArrayList<EarnVO> earnList){
		System.out.println("write Succeed!");
		return true;
	}
}
