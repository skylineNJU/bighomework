package main.po;

import java.util.ArrayList;

import main.socketservice.SqlReader;

public class DistributePOList extends Message{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<DistributePO> distributeList = new ArrayList<DistributePO>();
	
	public void getDataFromBase(){
		SqlReader reader=new SqlReader("Distribute");
		String key = distributeList.get(0).getCourrierName();
		distributeList.clear();
		while(reader.findNext("快递员账号",key)){
			DistributePO distributePO = new DistributePO(reader.getString("派送单号"),
					reader.getString("订单号"),
					reader.getString("收件人姓名"),
					reader.getString("收件人地址"),
					reader.getString("收件人手机号"),
					key
					);
			distributeList.add(distributePO);
		}
	}
}
