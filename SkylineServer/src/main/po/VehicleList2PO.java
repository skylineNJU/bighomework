package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class VehicleList2PO extends Message{
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
		while(reader.hasNext()){
			VehicleInfoPO po=new VehicleInfoPO(
					reader.getString("���ƺ�"),
					reader.getString("�������"),
					reader.getString("��������"),
					reader.getString("���̺�"),
					reader.getString("����ʱ��"),
					reader.getString("����ʱ��")
					);
			vehicleList.add(po);
		}
	}
}


