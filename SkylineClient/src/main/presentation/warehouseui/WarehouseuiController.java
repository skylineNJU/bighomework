package main.presentation.warehouseui;

public class WarehouseuiController {
	private AddWarehouseInReceiptPanel addWarehouseInReceipt;
	private AddWarehouseOutReceiptPanel addWarehouseOutReceipt;
	private CheckInventoryPanel checkInventory;
	private ShowInventoryPanel showInventory;
	private EmployeeInforPanel employeeInfor;
	public void select(Warehouseui ui){
		switch(ui){
		case AddWarehouseInReceipt:
			addWarehouseInReceipt=new AddWarehouseInReceiptPanel();
			addWarehouseInReceipt.init();
			break;
		case AddWarehouseOutReceipt:
			addWarehouseOutReceipt=new AddWarehouseOutReceiptPanel();
			addWarehouseOutReceipt.init();
			break;
		case CheckInventory:
			checkInventory=new CheckInventoryPanel();
			checkInventory.init();
			break;
		case ShowInventory:
			showInventory=new ShowInventoryPanel();
			showInventory.init();
			break;
		case EmployeeInfor:
			employeeInfor=new EmployeeInforPanel();
			employeeInfor.init();
			break;
		default:
			break;
		}
	}
}
