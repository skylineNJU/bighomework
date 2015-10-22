package logicservice;

import vo.TransType;
import vo.TransVO;
import vo.VehicleLoadingVO;

public interface LoadBLService {
	/*营业厅业务员
	 * 记录装车日期、本营业厅汽运编号、出发地、到达地、监装员、押运员、本次装箱所有托运单号。运费
	 * 系统显示车辆装车单
	 */
	
	public VehicleLoadingVO loadVehicle(String  date,String vehiclecode,String from,String to,
			String monitor,String escort,String[] ordercode,double fee);
	
	/*
	 * 中转中心管理员
	 * 记录装运日期、本中转中心运输编号、运输载具号、出发地、到达地、货柜(车厢，汽运为null)号、监装员、本次装箱所有托运单号、运费
	 * 系统显示装运单（运输方式以type决定）
	 */
	
	public TransVO intermidateLoading(TransType type,String Transcode,String Vehiclecode,
			String from,String to,String compartment,String monitor,String[] ordercode);
	
}
