package main.presentation.financeui;

public class FinanceuiControl {
	
	private BalancePanel balancePanel;
	private CostListPanel costListPanel;
	private EarnListPanel earnListPanel;
	private StatisticsListPanel statisticsListPanel;
	private ModifyPassWordPanel modifyPassWordPanel;
	public void select(Financeui ui){
		switch(ui){
		case Balanceui:
			balancePanel = new BalancePanel();
			balancePanel.init();
			break;
		case CostListui:
			costListPanel = new CostListPanel();
			costListPanel.init();
			break;
		case EarnListui:
			earnListPanel = new EarnListPanel();
			earnListPanel.init();
			break;
		case StatisticsListui:
			statisticsListPanel = new StatisticsListPanel();
			statisticsListPanel.init();
			break;
		case ModifyPassWordui:
			modifyPassWordPanel = new ModifyPassWordPanel();
			modifyPassWordPanel.init();
		default:
			break;
		}
	}

}
