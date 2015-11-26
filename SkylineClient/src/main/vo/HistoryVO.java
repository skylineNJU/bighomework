package main.vo;
import main.businesslogic.guestbl.History;
public class HistoryVO {
	private String code;
	private OrderVO order;
	private LobbyReceptionVO lobby1;
	private LobbyReceptionVO lobby2;
	private TransitReceptionVO interm1;
	private TransitReceptionVO interm2;
	
	public HistoryVO(){}
	public HistoryVO(String code){
		this.code=code;
	}
	public String getCode() {
		return code;
	}
	public boolean writeHistory(History history){
		
		return true;
	}
	public OrderVO getOrder() {
		return order;
	}
	public LobbyReceptionVO getLobby1() {
		return lobby1;
	}
	public LobbyReceptionVO getLobby2() {
		return lobby2;
	}
	public TransitReceptionVO getInterm1() {
		return interm1;
	}
	public TransitReceptionVO getInterm2() {
		return interm2;
	}
}
