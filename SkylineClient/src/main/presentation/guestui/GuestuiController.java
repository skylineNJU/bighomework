package main.presentation.guestui;

public class GuestuiController{
	private SearchPanel search;
	private AboutUsPanel aboutUs;
	public void select(Guestui ui){
		switch(ui){
		case Search:
			search=new SearchPanel();
			search.init();
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
