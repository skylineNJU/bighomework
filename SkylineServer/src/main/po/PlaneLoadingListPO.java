package main.po;

import java.util.ArrayList;

public class PlaneLoadingListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PlaneLoadingPO> list=new ArrayList<PlaneLoadingPO>();

	public ArrayList<PlaneLoadingPO> getList(){
		return list;
	}
	
	public void getDataFromBase(){
		for(PlaneLoadingPO po:list){
			po.getDataFromBase();
		}
	}
}
