package main.businesslogic.distributebl.distributeTest;

import main.businesslogic.distributebl.ReceiveMessage;
import main.vo.RecipientVO;

public class MockReceiveMessage extends ReceiveMessage{
	
	//���ռ���Ϣд�����ݿ���
	public boolean writeReceviceMessage(RecipientVO recipentVO){
		return true;
	}
}
