package main.po;

import main.vo.ReceiptVO;
import main.vo.TransitReceptionVO;

//中转中心接收单
public class CenterReceivePO extends Receipt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String receiveYear;//接收年份
	private String receiveMonth;//接收月份
	private String receiveDay;//接收天
	private String centerNumber;//中转中心编号
	private String bar;//快递的单号
	
	public CenterReceivePO(String receiveYear,String receiveMonth,String receiveDay,String centerNumber,String bar){
		this.receiveYear = receiveYear;
		this.receiveMonth = receiveMonth;
		this.receiveDay = receiveDay;
		this.centerNumber = centerNumber;
		this.bar = bar;
	}

	
	public void convert(ReceiptVO vo){
		TransitReceptionVO trans=(TransitReceptionVO)vo;
		trans.setReceiveYear(receiveYear);
		trans.setReceiveMonth(receiveMonth);
		trans.setReceiveYear(receiveYear);
		trans.setCenterNumber(centerNumber);
		trans.setBar(bar);
	}
	
	public String getReceiveYear() {
		return receiveYear;
	}

	public String getReceiveMonth() {
		return receiveMonth;
	}

	public String getReceiveDay() {
		return receiveDay;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public String getBar() {
		return bar;
	}

}
