package DataService;

//任务分配
public interface DistriuteDataService {
	
	//分配任务
	//这个方法的参数为完全，表示不会写
	public orderOP distributeTask();
	
	//输入快递员的账户
	//数据库返回其需要分配的订单
	public List<orderOP> lookTask(String account);
	
	//增加收件信息
	//数据库保存其订单信息
	public void inputOrder(orderOP orderop);
	
}
