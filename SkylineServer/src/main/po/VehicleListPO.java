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
		while(reader.findNext("车辆代号",key)){
			VehicleInfoPO po=new VehicleInfoPO(
					reader.getString("车牌号"),
					reader.getString("引擎代号"),
					key,
					reader.getString("底盘号"),
					reader.getString("购买时间"),
					reader.getString("服役时间")
					);
			vehicleList.add(po);
		}
	}
}
