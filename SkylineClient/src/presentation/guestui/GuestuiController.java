package presentation.guestui;

public class GuestuiController{
	private SearchPanel search;
	private HistoryPanel history;
	public void select(Guestui ui){
		switch(ui){
		case Search:
			search=new SearchPanel();
			search.init();
			break;
		case ShowHistory:
			history=new HistoryPanel();
			history.init();
		default:
			break;
		}
	}
}
