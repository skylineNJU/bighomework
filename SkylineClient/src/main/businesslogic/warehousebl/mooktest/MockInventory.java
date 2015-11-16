package main.businesslogic.warehousebl.mooktest;

import main.vo.InventoryVO;
import main.businesslogic.warehousebl.Inventory;

public class MockInventory extends Inventory{

	public MockInventory(String Code) {
		super(Code);
		// TODO Auto-generated constructor stub
	}

	public MockInventory(InventoryVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
	}

}
