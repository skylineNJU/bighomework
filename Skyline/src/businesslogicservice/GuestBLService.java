package businesslogicservice;

import vo.HistoryVO;

public interface GuestBLService {
	//用户输入订单号，系统显示历史轨迹和货物状态
	public HistoryVO showHistory(String code);
}
