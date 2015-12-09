package test.data_stub;

import  main.dataservice.ReceiveDataService;
import main.po.CenterReceiveListPO;
import  main.po.CenterReceivePO;
import main.po.CourrierPO;
import  main.po.DistributePO;
import main.po.LobbyReceiveListPO;
import  main.po.LobbyReceivePO;
import main.po.OrderListPO;
import  main.po.OrderPO;

import  main.po.OrderPO.PackageCost;
import  main.po.OrderPO.Size;
import  main.po.Type;

public class ReceiveDataService_Stub implements ReceiveDataService {


	@Override
	//�洢�µĶ�����Ϣ
		//��������Ϣ�洢�����ݿ�
	public boolean writeOrder(OrderPO orderpo){
		orderpo = new OrderPO("201515","asdas","sads","sadsad","sadsd","sdasd", "sadsad" , "sadsd",PackageCost.paperBox, null ,20,20.1,20.2,"dsadasd",Size.small,"sadsad",20);
		if(orderpo.getCode()!=null){
			return true;
		}
		else{
			return true;
		}
	}
		

	@Override
	public OrderListPO readOrder(OrderListPO orderPO) {
		// TODO Auto-generated method stub
		orderPO = new OrderListPO("1234566");
		return orderPO;
	}

	//ɾ��������Ϣ
	//orderBar��ʾ����������
	public boolean delOrder(String orderBar){
		if(orderBar!=null){
			System.out.println("delete Succeed!/n");
			return true;
		}
		else {
			return false;
		}
	}

	//�޸Ķ�����Ϣ
		//orderBar��ʾ����������
		public boolean modifiyOrder(OrderPO orderPO){
			 orderPO = new OrderPO("����","������������","��","64227112","13242199875","����","�Ͼ��к�԰" ,
					"��",PackageCost.paperBox,Type.normal,1,14.5,30,"�·�",Size.small,"0100210001",8);
			if(orderPO.getCode()!=null){
			 System.out.println("Succeed!/n");
			 return true;
			}
			else{
				return false;
			}
		}

	@Override
	public boolean writeCenterOrder(CenterReceivePO centerReceivePO) {
		// TODO Auto-generated method stub
		centerReceivePO = new CenterReceivePO(2015, 10, 30, "0100", "123243242");
		if(centerReceivePO.getBar()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public CenterReceiveListPO readCenterOrder(CenterReceiveListPO centerReceivePO) {
		// TODO Auto-generated method stub
		centerReceivePO= new CenterReceiveListPO("12131234234");
		return centerReceivePO;
	}

	@Override
	public boolean delCenterOrder(String orderBar) {
		// TODO Auto-generated method stub
		if(orderBar!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean modifiyCenterOrder(CenterReceivePO centerReceivePO) {
		// TODO Auto-generated method stub
		centerReceivePO = new CenterReceivePO(2015, 10, 30, "0100", "122");
		if(centerReceivePO.getCode()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean writeLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		lobbyReceivePO = new LobbyReceivePO("2014","3","28",null,"123123123");
		if(lobbyReceivePO.getCode()!=null){
			return true;
		}
		else{
			return false;
		}
}

	@Override
	public LobbyReceiveListPO readLobbyReceiveOrder(LobbyReceiveListPO poList) {
		// TODO Auto-generated method stub
		poList = new LobbyReceiveListPO("12132143");
		return poList;
	}

	@Override
	public boolean delLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
		// TODO Auto-generated method stub
		lobbyReceivePO = new LobbyReceivePO("2014","3","28",null,"21323424");
		if(lobbyReceivePO .getCode()!=null){
			return true;
			
		}else{
			return false;
		}
	}

		@Override
		public boolean modifiyLobbyReceiveOrder(LobbyReceivePO lobbyReceivePO) {
			// TODO Auto-generated method stub
			lobbyReceivePO = new LobbyReceivePO("2014","3","28",null,"21323424");
			if(lobbyReceivePO .getCode()!=null){
				return true;
				
			}else{
				return false;
			}
		}

		@Override
		public boolean writeDistributeOrder(DistributePO distributePO) {
			// TODO Auto-generated method stub
			distributePO  = new DistributePO("121323", "23131","Sun", "shanghai","18263738990","Winter");
			if(distributePO .getCode()!=null){
				return true;
				
			}else{
				return false;
			}
		}

		@Override
		public boolean readDistributeOrder(String orderBar,DistributePO distributePO) {
			// TODO Auto-generated method stub
			distributePO  = new DistributePO(orderBar, "23131","Sun", "shanghai","18263738990","Winter");
			if(distributePO .getCode()!=null){
				return true;
				
			}else{
				return false;
			}
		}

		@Override
		public boolean delDistributeOrder(String orderBar) {
			// TODO Auto-generated method stub
			if(orderBar!=null){
				return true;
			}
			else{
				return false;
			}
		}

		@Override
		public boolean modifiyDistributeOrder(DistributePO distributePO) {
			// TODO Auto-generated method stub
			distributePO  = new DistributePO("21323", "23131","Sun", "shanghai","18263738990","Winter");
			if(distributePO .getCode()!=null){
				return true;
				
			}else{
				return false;
			}
		}

		@Override
		public CourrierPO getCourrierInfo(CourrierPO po) {
			// TODO Auto-generated method stub
			po = new CourrierPO("2131231");
			return po;
		}

		@Override
		public void saveDistribute(DistributePO po) {
			// TODO Auto-generated method stub
			po = new DistributePO("12323", "23131","Sun", "shanghai","18263738990","Winter");
			System.out.println("-----------save Distribute success-------");
		}
}
