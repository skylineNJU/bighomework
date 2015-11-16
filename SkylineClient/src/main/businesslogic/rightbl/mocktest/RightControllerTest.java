package main.businesslogic.rightbl.mocktest;

import static org.junit.Assert.*;

import org.junit.Test;

import main.vo.BankAccountVO;


public class RightControllerTest {
@Test
public void inquireAccount(){
	BankAccountVO vo=new BankAccountVO("141250029", 0);
	MockAccount mock=new MockAccount(vo);
	assertEquals("141250029",mock.getID());
	assertEquals(true,mock.inquire(mock.getID()));
}

@Test
public void deleteAccount(){
	BankAccountVO vo=new BankAccountVO("141250029",0);
	MockAccount mock=new MockAccount(vo);
	assertEquals("141250029",mock.getID());
	assertEquals(true,mock.delete(mock.getID()));
}
@Test
public void createNewAccount(){
	BankAccountVO vo=new BankAccountVO("141250029", null);
	MockAccount mock=new MockAccount(vo);
	assertEquals("141250029",mock.getID());
	assertEquals(true,mock.saveInfo());
}
@Test
public void modifyNewAccount(){
	BankAccountVO vo=new BankAccountVO("141250029", "333555", null);
	MockAccount mock=new MockAccount(vo);
	assertEquals("333555",mock.getCode());
	assertEquals(true,mock.modify());
}
	
}
