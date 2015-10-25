package bl_stub;

import java.util.ArrayList;

import businesslogicservice.DistributeBLService;
import vo.DistributeVO;
import vo.RecipientVO;

public class DistributeService_Stub implements DistributeBLService{
	ArrayList<DistributeVO> dis=new ArrayList<DistributeVO>();
	RecipientVO recipient;
	@Override
	public ArrayList<DistributeVO> showDistributeList() {
		// TODO Auto-generated method stub
		dis.clear();
		DistributeVO distribute=new DistributeVO("1101201234","张三","南京大学仙林校区",
				"13018101290","141250029");
		dis.add(distribute);
		return dis;
	}

	@Override
	public RecipientVO writeReceiveMessage(String code, String ID, String date,String name) {
		// TODO Auto-generated method stub
		recipient=new RecipientVO(ID,date,code);
		recipient.setName(name);
		return recipient;
	}
	
}
