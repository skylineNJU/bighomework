package main.businesslogic.loadbl;

import java.util.ArrayList;

import main.data.load.LoadDataController;
import main.dataservice.LoadDataService;
import main.po.PlaneLoadingListPO;
import main.po.PlaneLoadingPO;
import main.vo.PlaneLoadingVO;

public class PlaneLoadListBL {
	private PlaneLoadingListPO po;
	private String codeList;
	
	public PlaneLoadListBL(String codeList){
		this.codeList=codeList;
	}
	
	public ArrayList<PlaneLoadingVO> inquire(){
		System.out.println("inquire plane");
		ArrayList<PlaneLoadingVO> voList=new ArrayList<PlaneLoadingVO>();
		po=new PlaneLoadingListPO(codeList);
		LoadDataService service=new LoadDataController();
		po=service.inquirePlaneLoadList(po);
		ArrayList<PlaneLoadingPO> poList=po.getList();
		
		for(PlaneLoadingPO p:poList){
			PlaneLoadingVO vo=new PlaneLoadingVO(
					p.getCode(),
					p.getLoadingDate(),
					p.getFlightNum(),
					p.getPlaneNum(),
					p.getDeparture(),
					p.getDestination(),
					p.getMonitor(),
					p.getStore(),
					p.getShipment(),
					p.getFreight());
			voList.add(vo);
		}
		return voList;
	}
}
