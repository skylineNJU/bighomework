package test.bl_stub;

import java.util.ArrayList;

import main.businesslogicservice.DistributeBLService;
import main.vo.DistributeVO;
import main.vo.RecipientVO;

public class DistributeService_Stub implements DistributeBLService{
	ArrayList<DistributeVO> dis=new ArrayList<DistributeVO>();
	RecipientVO recipient;
	@Override
	public boolean showDistributeList(ArrayList<DistributeVO> distributeList) {
		// TODO Auto-generated method stub
		distributeList.clear();
		DistributeVO distribute=new DistributeVO("1101201234","张三","南京大学仙林校区",
				"13018101290","141250029", null);
		distributeList.add(distribute);
		return true;
	}

	@Override
	public boolean writeReceiveMessage(RecipientVO recipient) {
		// TODO Auto-generated method stub
		recipient.write("1651", "2015/06/25", "2153156", "刘钦", "256165");
		return true;
	}

}
