package main.businesslogic.receivebl.mocktest;
import static org.junit.Assert.*;

import org.junit.Test;

import main.vo.LobbyReceptionVO;
import main.vo.OrderVO;
import main.vo.TransitReceptionVO;
public class ReceiveControllerTest {
@Test
public void testCreateNewOrder(){
	OrderVO ordervo=new OrderVO("¿×Ã÷", "", "", "", "", "", null, null, 0, 0, 0, null, null, null, null, null, null, null);
    MockOrder mockOrder=new MockOrder(ordervo);
    assertEquals("¿×Ã÷",mockOrder.getReceivorName());
    assertEquals(true,mockOrder.saveInfo());
}
@Test
	public void delLobby(){
	LobbyReceptionVO vo=new LobbyReceptionVO(null, null, null, null, null, null, 0, "1316181910", null);
	MockLobby mock=new MockLobby(vo);
	assertEquals("1316181910",mock.getExpressBar());
	assertEquals(true,mock.delete(mock.getExpressBar()));
}
@Test
public void modifyLobby(){
	LobbyReceptionVO vo=new LobbyReceptionVO(null, null, null, null, null, null, 0, "1316181910", null);
	MockLobby mock=new MockLobby(vo);
	assertEquals("1316181910",mock.getExpressBar());
	assertEquals(true,mock.delete(mock.getExpressBar()));

}
@Test
 public void inquireTransit(){
	TransitReceptionVO vo=new TransitReceptionVO(null, null, null, 0, 0, 0, null, "33778899");
	MockTransit mock=new MockTransit(vo);
	assertEquals("33778899",mock.getBar());
	assertEquals(true,mock.inquireInfo(mock.getBar()));
}

}
