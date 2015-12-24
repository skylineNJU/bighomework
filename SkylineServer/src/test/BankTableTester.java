package test;

import main.po.BankAccountTableCreater;

public class BankTableTester {
	public static void main(String[] args){
		BankAccountTableCreater creater=new BankAccountTableCreater(3);
		creater.createTable();
		creater.writeTable(2);
	}
}
