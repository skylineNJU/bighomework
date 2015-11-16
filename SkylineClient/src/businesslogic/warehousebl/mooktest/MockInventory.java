package businesslogic.warehousebl.mooktest;

import vo.InventoryVO;
import businesslogic.warehousebl.Inventory;

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
