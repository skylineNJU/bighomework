package main.presentation.loadui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;

public class IntermLoadingui {
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private CreateCar ccr;
	private CreatePlane cpl;
	private CreateTrain ctr;
	
	public IntermLoadingui() {
		super();
		panel=MainController.getWritepanel();
		panel.setLayout(null);
		tabbedPane=new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSize(panel.getWidth()/6*5+43,panel.getHeight()/6*5);
		tabbedPane.setLocation(panel.getWidth()/18,panel.getHeight()/12);
		panel.add(tabbedPane);
		cpl=new CreatePlane(tabbedPane, panel);
		new PlaneLoadingui(cpl, tabbedPane,(WritePanel) panel);
		ccr=new CreateCar(tabbedPane, panel);
		new CarLoadingui(ccr, tabbedPane,(WritePanel)panel);
		ctr=new CreateTrain(tabbedPane, panel);
		new TrainLoadingui(ctr, tabbedPane, (WritePanel) panel);
		tabbedPane.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
}
