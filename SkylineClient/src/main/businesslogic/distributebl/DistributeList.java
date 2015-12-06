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
	
	public boolean writeDistribute(ArrayList<DistributeVO> voList){
		ArrayList<DistributePO> poList = new ArrayList<DistributePO>();
		for(DistributeVO distributeVO:voList){
			DistributePO distributePO = new DistributePO(distributeVO.getDistributeCode(),
					distributeVO.getOrderCode(),distributeVO.getName(),
					distributeVO.getAdress(),distributeVO.getPhoneNumber(),distributeVO.getID()
					);
			poList.add(distributePO);
		}
		DistributeDataService distribute  = new DistributeDataController();
		return distribute.writeDistribute(poList);
	}
}
