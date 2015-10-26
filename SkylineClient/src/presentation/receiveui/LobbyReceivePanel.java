package presentation.receiveui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.receivebl.ReceiveController;

@SuppressWarnings("serial")
public class LobbyReceivePanel extends JPanel{
	JTextField[] feild=new JTextField[5];
	JButton button[]=new JButton[3];
	ReceiveController contro=new ReceiveController();
	public LobbyReceivePanel(){
		this.setLayout(null);
		for(int x=0;x<5;x++){
			feild[x]=new JTextField();
			feild[x].setSize(200, 40);
			feild[x].setLocation(200,45*x+50);
			this.add(feild[x]);
		}
		button[0]=new JButton("保存");
		button[1]=new JButton("提交");
		button[2]=new JButton("返回");
		
		button[0].setBounds(50,400,100,20);
		button[1].setBounds(200,400,100,20);
		button[2].setBounds(350,400,100,20);
		
		button[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int condition=0;
				switch(feild[3].getText()){
				case "完好":
					condition=1;
					}
				contro.createNewLobbyReception(feild[0].getText(),feild[1].getText(),feild[2].getText(),condition);
			}
		});
		for(int x=0;x<3;x++){
			this.add(button[x]);
		}
		
	}
	
	
}
