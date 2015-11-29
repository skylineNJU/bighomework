package main.businesslogic.distributebl;

import java.util.ArrayList;

import main.po.DistributePO;
import main.vo.DistributeVO;


//分配任务的列表
public class DistributeList {

	//在数据库里查询被分配的任务
	public ArrayList<DistributeVO> readDistribute(String courierCode){
		ArrayList<DistributePO> distributePOList = new ArrayList<DistributePO>();
		ArrayList<DistributeVO> distributeVOList = new ArrayList<DistributeVO>();
		DistributeList distribute = new DistributeList();
		distributeVOList = distribute.writeDistribute(courierCode);
		for(DistributePO distributePO:distributePOList){
			DistributeVO distributeVO = new DistributeVO(distributePO.getOrder(),
					distributePO.getBar(),distributePO.getGuestName(),
					distributePO.getGuestAddress(),distributePO.getGuestPhone(),
					distributePO.getCourrierName());
			distributeVOList.add(distributeVO);
		}
		return distributeVOList;
	}
	
}
