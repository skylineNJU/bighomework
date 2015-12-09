package test.bl_stub;

import java.util.ArrayList;

import main.businesslogicservice.DistributeBLService;
import main.vo.DistributeVO;
import main.vo.RecipientVO;

public class DistributeService_Stub implements DistributeBLService{
	ArrayList<DistributeVO> dis=new ArrayList<DistributeVO>();
	RecipientVO recipient;
	String courierCode="1111111";
	

	@Override
	public boolean writeReceiveMessage(RecipientVO recipient) {
		// TODO Auto-generated method stub
		recipient=new RecipientVO("Mary", "13888888", "141516", "20150101", "8888");
		return true;
	}

	@Override
	public ArrayList<DistributeVO> showDistributeList(String courierCode) {
		// TODO Auto-generated method stub
		dis.clear();
		DistributeVO distribute=new DistributeVO("1101201234","张三","南京大学仙林校区",
				"13018101290","141250029", null);
		dis.add(distribute);
		return dis;
	}

	@Override
	public boolean writeDistributeList(ArrayList<DistributeVO> voList) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
