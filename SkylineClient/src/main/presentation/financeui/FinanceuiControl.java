package main.presentation.financeui;

public class FinanceuiControl {
	
	private BalancePanel balancePanel;
	private CostListPanel costListPanel;
	private EarnListPanel earnListPanel;
	private LobbyEarnPanel lobbyEarnPanel;
	private StatisticsListPanel statisticsListPanel;
	private FeeStrategyPanel feeStrategy;
	private SalaryPanel salaryPanel;
	
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
		case LobbyEarnui:
			lobbyEarnPanel = new LobbyEarnPanel();
			lobbyEarnPanel.init();
			break;
		case FeeStrategyui:
			feeStrategy = new FeeStrategyPanel();
			feeStrategy.init();
			break;
		case SalaryStrategyui:
			salaryPanel = new SalaryPanel();
			salaryPanel.init();
			break;
		default:
			break;
		}
	}

}
