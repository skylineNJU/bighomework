package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class VehicleListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<VehicleInfoPO> vehicleList=new ArrayList<VehicleInfoPO>();
	public void add(VehicleInfoPO po){
		vehicleList.add(po);
	}
	
	public ArrayList<VehicleInfoPO> getList(){
		return this.vehicleList;
	}
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("VehicleInfo");
		String key=vehicleList.get(0).gerCarNum();
		vehicleList.clear();
		while(reader.findNext("��������",key)){
			VehicleInfoPO po=new VehicleInfoPO(
					reader.getString("���ƺ�"),
					reader.getString("�������"),
					key,
					reader.getString("���̺�"),
					reader.getString("����ʱ��"),
					reader.getString("����ʱ��")
					);
			vehicleList.add(po);
		}
	}
}
