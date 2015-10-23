package dataservice;

//货物接收
public interface ReceiveDataService {
	
	//存储新的订单信息
	//将订单信息存储进数据库
	public void writeOrder(orderOP orderop);
	
	//查看订单信息
	//orderBar为订单条形码
	public opderOP readOrder(String orderBar);
	
	//删除订单信息
	//orderBar表示订单条形码
	public void delOrder(String orderBar);
	
	//修改订单信息
	//orderBar表示订单条形码
	public opderOP modifiyOrder(String orderBar);
	
	//存储新的中转接收单单信息
	//将订单信息存储进数据库
	public void writeCenterOrder(orderOP orderop);
	
	//查看中转接收单单信息
	//orderBar为订单条形码
	public opderOP readCenterOrder(String orderBar);
	
	//删除中转接收单单信息
	//orderBar表示订单条形码
	public void delCenterOrder(String orderBar);
	
	//修改中转接收单单信息
	//orderBar表示订单条形码
	public opderOP modifiyCenterOrder(String orderBar);
	
	//存储新的接收单单信息
	//将订单信息存储进数据库
	public void writeReceiveOrder(orderOP orderop);
	
	//查看接收单单信息
	//orderBar为订单条形码
	public opderOP readReceiveOrder(String orderBar);
	
	//删除接收单单信息
	//orderBar表示订单条形码
	public void delReceiveOrder(String orderBar);
	
	//修改接收单单信息
	//orderBar表示订单条形码
	public opderOP modifiyReceiveOrder(String orderBar);
	
	//存储新的派送单信息
	//将订单信息存储进数据库
	public void writeReceiveOrder(orderOP orderop);
	
	//查看派送单单信息
	//orderBar为订单条形码
	public opderOP readReceiveOrder(String orderBar);
	
	//删除派送单单信息
	//orderBar表示订单条形码
	public void delReceiveOrder(String orderBar);
	
	//修改派送单单信息
	//orderBar表示订单条形码
	public opderOP modifiyReceiveOrder(String orderBar);
	
}
