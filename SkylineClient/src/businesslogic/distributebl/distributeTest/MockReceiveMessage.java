package businesslogic.distributebl.distributeTest;

import businesslogic.distributebl.ReceiveMessage;
import vo.RecipientVO;

public class MockReceiveMessage extends ReceiveMessage{
	
	//���ռ���Ϣд�����ݿ���
	public boolean writeReceviceMessage(RecipientVO recipentVO){
		return true;
	}
}
