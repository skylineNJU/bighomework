package businesslogic.rightbl.mocktest;

import static org.junit.Assert.*;

import org.junit.Test;

import vo.AccountVO;
import businesslogic.rightbl.Account;

public class RightControllerTest {
@Test
public void inquireAccount(){
	AccountVO vo=new AccountVO("141250029", 0);
	MockAccount mock=new MockAccount(vo);
	assertEquals("141250029",mock.getID());
	assertEquals(true,mock.inquire(mock.getID()));
}

@Test
public void deleteAccount(){
	AccountVO vo=new AccountVO("141250029",0);
	MockAccount mock=new MockAccount(vo);
	assertEquals("141250029",mock.getID());
	assertEquals(true,mock.delete(mock.getID()));
}
@Test
public void createNewAccount(){
	AccountVO vo=new AccountVO("141250029", null, null);
	MockAccount mock=new MockAccount(vo);
	assertEquals("141250029",mock.getID());
	assertEquals(true,mock.saveInfo());
}
@Test
public void modifyNewAccount(){
	AccountVO vo=new AccountVO("141250029", "333555", null);
	MockAccount mock=new MockAccount(vo);
	assertEquals("333555",mock.getCode());
	assertEquals(true,mock.modify());
}
	
}
