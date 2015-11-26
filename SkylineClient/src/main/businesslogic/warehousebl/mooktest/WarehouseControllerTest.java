package main.businesslogic.warehousebl.mooktest;

import static org.junit.Assert.*;

import org.junit.Test;

import main.vo.InventoryVO;
import main.vo.WarehouseInVO;
import main.vo.WarehouseOutVO;

public class WarehouseControllerTest {
	@Test
	public void testWarehouseIn(){
		WarehouseInVO whi = new WarehouseInVO("", "", "", "1232143244", "","", "A", 0, 0, 0,"");
		MockWarehouseIn WarehouseIN1 =new MockWarehouseIn(whi);
		assertEquals("1232143244", WarehouseIN1.getBar());
		assertEquals(true,WarehouseIN1.saveInfo());
	}
	@Test
	public void testWarehouseOut(){
		WarehouseOutVO who = new WarehouseOutVO(null, null, null, "上海", null, null, null, null, null, null);
		MockWarehouseOut WarehouseOUT =new MockWarehouseOut(who);
		assertEquals("上海", WarehouseOUT.getDestination());
		assertEquals(true,WarehouseOUT.saveInfo());
	}
	
	@Test
	public void testCheckInventory(){
		WarehouseInVO whi = new WarehouseInVO("", "", "", "1232143244", "","", "", 0, 0, 0,null);
		MockWarehouseIn WarehouseIN1 =new MockWarehouseIn(whi);
		assertEquals("1232143244", WarehouseIN1.getBar());
		assertEquals(true,WarehouseIN1.check());
	}
	@Test
	public void testShowInventory(){
		InventoryVO it = new InventoryVO(0, 0, null, null, 'A', 0, 0, 0, "上海", null);
		MockInventory  inventory=new MockInventory(it);
		assertEquals("上海", inventory.getDestination());
		assertEquals(true,inventory.saveInfo());
		assertEquals(true,inventory.show());
 	}
	
	
	
}
