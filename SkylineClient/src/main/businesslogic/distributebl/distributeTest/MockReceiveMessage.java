package main.businesslogic.distributebl.distributeTest;

import main.businesslogic.distributebl.ReceiveMessage;
import main.vo.RecipientVO;

public class MockReceiveMessage extends ReceiveMessage{
	
	//将收件信息写入数据库里
	public boolean writeReceviceMessage(RecipientVO recipentVO){
		return true;
	}
}
