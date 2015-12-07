package main.presentation.guestui;

public class GuestuiController{
	private SearchPanel search;
	private HistoryPanel history;
	private AboutUsPanel aboutUs;
	public void select(Guestui ui){
		switch(ui){
		case Search:
			search=new SearchPanel();
			search.init();
			break;
		case ShowHistory:
			history=new HistoryPanel();
			history.init();
			break;
		case AboutUs:
			aboutUs=new AboutUsPanel();
			aboutUs.init();
			break;
		default:
			break;
		}
	}
}
