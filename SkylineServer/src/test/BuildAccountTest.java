package test;

import main.po.BuildAccountPO;

public class BuildAccountTest {
	public static void main(String[] args){
		BuildAccountPO ba=new BuildAccountPO();
		ba.addAccount("¶¹³Ë·ç","2015/5/2",2);
		ba.writeIntoDatabase();
	}
}
