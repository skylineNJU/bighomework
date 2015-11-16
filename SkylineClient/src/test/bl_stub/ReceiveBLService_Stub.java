package bl_stub;

import vo.OrderVO.PackageCost;
import vo.OrderVO.Size;
import vo.OrderVO.Type;
import vo.LobbyReceptionVO;
import vo.OrderVO;
import vo.TransitReceptionVO;
import businesslogicservice.ReceiveBLService;

public class ReceiveBLService_Stub implements ReceiveBLService{

	@Override
	/*快递员输入
	 寄件人姓名、住址、单位、电话、手机；
	 收件人姓名、住址、单位、电话、手机；
	 托运货物信息（原件数、实际重量、体积、内件品名(没有的话填null)）；
	 经济快递，标准快递，特快专递；
	 包装费（纸箱（5元）、木箱（10元）、快递袋（1元)
	 系统显示提交后订单
	 */
	public OrderVO createNewOrder(String name1, String position1, String unit1,
			String phoneNumber1, String name2, String position2, String unit2,
			String phoneNumber2, int number, double weight, double Volume,
			String name3, PackageCost pC, Type t,Size s,String id,String data,String code) {
		// TODO Auto-generated method stub
		OrderVO orderVO= new OrderVO(name1,position1,unit1,phoneNumber1,name2,position2,unit2,phoneNumber2,number,weight,Volume,name3,pC,t,s,id,data,code);
		return orderVO;
	}
	
	@Override
	/*中转中心业务员输入
	 * 中转中心编号（025城市编码+0营业厅+00鼓楼中转中心）
	 * 、到达日期、中转单编号、出发地、货物到达状态（损坏、完整、丢失）
	 * 系统显示保存后的中转到达单
	 */
	public TransitReceptionVO createNewTransitReception(String CenterCode,
			String date, String ReceiptCode, String from, int condition) {
		// TODO Auto-generated method stub
		TransitReceptionVO transitReceptionVO=new TransitReceptionVO(CenterCode,date,ReceiptCode);
		return transitReceptionVO;
	}

	@Override
	/*营业厅业务员输入
	 * 到达日期，订单号，出发地，货物到达状态（损坏，完整，丢失）
	 * 系统显示保存后的营业厅到达单
	 */
	public LobbyReceptionVO createNewLobbyReception(String date, String code,
			String from, int condition) {
		// TODO Auto-generated method stub
		LobbyReceptionVO lobbyReceptionVO =new LobbyReceptionVO(from,date,code);
		return lobbyReceptionVO;
	}

}
