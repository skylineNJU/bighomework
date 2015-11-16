package businesslogic.receivebl.mocktest;

import vo.LobbyReceptionVO;
import vo.OrderVO;
import vo.TransitReceptionVO;


public class MockReceive{
 OrderVO order=new OrderVO("孔明","蜀国", "蜀国", "13121415", "王朗", "曹魏", "曹魏", "14168785", 1, 1, 1, "刘备", null, null, null, "141250029", "2015-09-09", "141250029");
 TransitReceptionVO transitReception=new TransitReceptionVO(null, null, null, 2015, 9, 12, "10101010", "0804030809");
 LobbyReceptionVO lobbyReception=new LobbyReceptionVO(null, null, null, "2015", "09", "13", 0, null, null);
}
