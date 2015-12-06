package main.po;

import java.io.Serializable;

import main.vo.ReceiptVO;
import main.vo.TransitReceptionVO;

//中转中心接收单
public class CenterReceivePO extends Receipt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiveYear;//接收年份
	private int receiveMonth;//接收月份
	private int receiveDay;//接收天
	private String centerNumber;//中转中心编号
	private String bar;//快递的单号
	
	public CenterReceivePO(int receiveYear,int receiveMonth,int receiveDay,String centerNumber,String bar){
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
	
	public int getReceiveYear() {
		return receiveYear;
	}

	public int getReceiveMonth() {
		return receiveMonth;
	}

	public int getReceiveDay() {
		return receiveDay;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public String getBar() {
		return bar;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
