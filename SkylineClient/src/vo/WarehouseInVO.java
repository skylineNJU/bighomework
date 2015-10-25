package vo;

public class WarehouseInVO extends ReceiptVO {

// TODO Auto-generated constructor stub
	String bar;
	String destination;
	char area;
	int row;
	int shelf;
	int position;
	
	public WarehouseInVO(String id,String da,String co,String a,String c,char d,int e,int f,int g){
		super(id, da, co);
		bar = a;
		destination = c;
		area = d;
		row = e;
		shelf = f;
		position = g;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public char getArea() {
		return area;
	}

	public void setArea(char area) {
		this.area = area;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getShelf() {
		return shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getBar() {
		return bar;
	}
	
}
