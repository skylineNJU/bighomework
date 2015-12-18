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
					reader.getString("车牌号"),
					reader.getString("引擎代号"),
					reader.getString("车辆代号"),
					reader.getString("底盘号"),
					reader.getString("购买时间"),
					reader.getString("服役时间")
					);
			vehicleList.add(po);
		}
	}
}


