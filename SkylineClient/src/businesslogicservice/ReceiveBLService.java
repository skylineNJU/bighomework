package businesslogicservice;

import vo.LobbyReceptionVO;
import vo.OrderVO;
import vo.OrderVO.Size;
import vo.TransitReceptionVO;
import vo.OrderVO.PackageCost;
import vo.OrderVO.Type;

public interface ReceiveBLService {
	/*���Ա����
	 �ļ���������סַ����λ���绰���ֻ���
	 �ռ���������סַ����λ���绰���ֻ���
	 ���˻�����Ϣ��ԭ������ʵ��������������ڼ�Ʒ��(û�еĻ���null)���ߴ磩��
	 ���ÿ�ݣ���׼��ݣ��ؿ�ר�ݣ�
	 ��װ�ѣ�ֽ�䣨5Ԫ����ľ�䣨10Ԫ������ݴ���1Ԫ)
	 ϵͳ��ʾ�ύ�󶩵�
	 */
	public OrderVO createNewOrder(String name1,String position1,String unit1,String phoneNumber1,
			                      String name2,String position2,String unit2,String phoneNumber2,
			                      int number,double weight,double Volume,String name3,
			                      PackageCost pC,Type t,Size size,String id,String data,String code);
	
	/*��ת����ҵ��Ա����
	 * ��ת���ı�ţ�025���б���+0Ӫҵ��+00��¥��ת���ģ�
	 * ���������ڡ���ת����š������ء����ﵽ��״̬���𻵡���������ʧ��
	 * ϵͳ��ʾ��������ת���ﵥ
	 */
	
	public TransitReceptionVO createNewTransitReception(String CenterCode,String date,String ReceiptCode,
			String from,int condition);
	
	/*Ӫҵ��ҵ��Ա����
	 * �������ڣ������ţ������أ����ﵽ��״̬���𻵣���������ʧ��
	 * ϵͳ��ʾ������Ӫҵ�����ﵥ
	 */
	
	public LobbyReceptionVO createNewLobbyReception(String date,String code,String from,int condition);
}
