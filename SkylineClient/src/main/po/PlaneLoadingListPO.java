package main.po;

import java.util.ArrayList;

public class PlaneLoadingListPO extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PlaneLoadingPO> list=new ArrayList<PlaneLoadingPO>();

	
	public PlaneLoadingListPO(String codeList){
		String[] codes=codeList.split(" ");
		for(int x=1;x<codes.length;x++){
			PlaneLoadingPO po=new PlaneLoadingPO("","","","","","","","", x);
			po.setCode(codes[x]);
			list.add(po);
		}
	}
	
	public ArrayList<PlaneLoadingPO> getList(){
		return list;
	}
}
