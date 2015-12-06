package main.presentation.loadui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import main.presentation.mainui.MainController;
import main.presentation.mainui.WritePanel;

public class IntermLoadingui {
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private PlaneLoadingui planeUI;
	private CarLoadingui carUI;
	private TrainLoadingui trainUI;
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
		planeUI=new PlaneLoadingui(cpl, tabbedPane,(WritePanel) panel);
		ccr=new CreateCar(tabbedPane, panel);
		carUI=new CarLoadingui(ccr, tabbedPane,(WritePanel)panel);
		ctr=new CreateTrain(tabbedPane, panel);
		trainUI=new TrainLoadingui(ctr, tabbedPane, (WritePanel) panel);
	}
	
}
