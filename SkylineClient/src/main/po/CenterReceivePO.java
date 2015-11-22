package main.po;

import main.vo.ReceiptVO;
import main.vo.TransitReceptionVO;

//��ת���Ľ��յ�
public class CenterReceivePO extends Receipt{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiveYear;//�������
	private int receiveMonth;//�����·�
	private int receiveDay;//������
	private String centerNumber;//��ת���ı��
	private String bar;//��ݵĵ���
	
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

}
