package main.businesslogicservice;

import java.util.ArrayList;

import main.vo.LobbyLoading;
import main.vo.PlaneLoadingVO;
import main.vo.TrainLoadingVO;
import main.vo.TransVO;
import main.vo.VehicleLoadingVO;

public interface LoadBLService {
	/*营业厅业务员
	 * 记录装车日期、本营业厅汽运编号、出发地、到达地、监装员、押运员、本次装箱所有托运单号。运费
	 * 系统显示车辆装车单
	 */
	
	public boolean loadVehicle(LobbyLoading vehicleLoadingInfo);
	
	/*
	 * 中转中心管理员
	 * 记录装运日期、本中转中心运输编号、运输载具号、出发地、到达地、货柜(车厢，汽运为null)号、监装员、本次装箱所有托运单号、运费
	 * 系统显示装运单（运输方式以type决定）
	 */
	
	public boolean loadCar(VehicleLoadingVO vo);
	
	public boolean loadTrain(TrainLoadingVO vo);
	
	public boolean loadPlane(PlaneLoadingVO vo);
	
	public ArrayList<LobbyLoading> inquireLoadVehicle(String codeList);
	
	public ArrayList<PlaneLoadingVO> inquireLoadPlane(String codeList);
	
}
