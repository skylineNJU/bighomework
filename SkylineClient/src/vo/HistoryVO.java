package vo;

public class HistoryVO {
	private String code;
	private OrderVO order;
	private LobbyReceptionVO lobby1;
	private LobbyReceptionVO lobby2;
	private TransitReceptionVO interm1;
	private TransitReceptionVO interm2;
	public HistoryVO(String co){
		this.code=co;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public OrderVO getOrder() {
		return order;
	}
	public void setOrder(OrderVO order) {
		this.order = order;
	}
	public LobbyReceptionVO getLobby1() {
		return lobby1;
	}
	public void setLobby1(LobbyReceptionVO lobby1) {
		this.lobby1 = lobby1;
	}
	public LobbyReceptionVO getLobby2() {
		return lobby2;
	}
	public void setLobby2(LobbyReceptionVO lobby2) {
		this.lobby2 = lobby2;
	}
	public TransitReceptionVO getInterm1() {
		return interm1;
	}
	public void setInterm1(TransitReceptionVO interm1) {
		this.interm1 = interm1;
	}
	public TransitReceptionVO getInterm2() {
		return interm2;
	}
	public void setInterm2(TransitReceptionVO interm2) {
		this.interm2 = interm2;
	}
	
	
}
