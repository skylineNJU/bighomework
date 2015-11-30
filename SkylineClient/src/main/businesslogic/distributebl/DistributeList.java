package main.businesslogic.distributebl;

import java.util.ArrayList;

import main.data.distribute.DistributeDataController;
import main.dataservice.DistributeDataService;
import main.po.DistributePO;
import main.po.DistributePOList;
import main.vo.DistributeVO;


//����������б�
public class DistributeList {

	//�����ݿ����ѯ�����������
	public ArrayList<DistributeVO> readDistribute(String courierCode){
		ArrayList<DistributeVO> distributeVOList = new ArrayList<DistributeVO>();
		DistributeDataService distributeController = new DistributeDataController();
		DistributePOList disPOList = distributeController.lookTask(courierCode);
		for(DistributePO distributePO:disPOList.getList()){
			distributeVOList.add(new DistributeVO(distributePO.getOrderCode(),
					distributePO.getBar(),
					distributePO.getGuestName(),
					distributePO.getGuestAddress(),
					distributePO.getGuestPhoneNumber(),
					distributePO.getCourrierName()));
		}
		return distributeVOList;
	}
}
