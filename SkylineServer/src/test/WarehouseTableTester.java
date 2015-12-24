package test;

import main.po.WarehouseTableCreater;

public class WarehouseTableTester {
	public static void main(String[] args){
		WarehouseTableCreater creater=new WarehouseTableCreater(1);
		creater.createTable();
	}
}
