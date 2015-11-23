package main.vo;

public class TrainLoadingVO {
	private String loadingDate;//װ������
	private String trainNum;//��ת�������˱��
	private String trainTourNum;//���κ�
	private String departure;//������
	private String destination;//�����
	private String monitor;//��װԱ
	private String store;//Ѻ��Ա
	private String shipment;//װ����������
	private double freight;//�˷�

	public TrainLoadingVO(String id, String da, String co, String a, String b, String c, String d,
			String e, String f,String g,String h, double i) {
		super();
		this.loadingDate=a;
		this.trainNum=b;
		this.trainTourNum=c;
		this.departure=d;
		this.destination=e;
		this.monitor=f;
		this.store=g;
		this.shipment=h;
		this.freight=i;
		// TODO Auto-generated constructor stub
	}
	
	public boolean writeTrainLoadingInfo(TrainLoadingVO vl){
		this.loadingDate=vl.getLoadingDate();
		this.trainNum=vl.getCarNum();
		this.trainTourNum=vl.getCarTourNum();
		this.departure=vl.getDeparture();
		this.destination=vl.getDestination();
		this.monitor=vl.getMonitor();
		this.store=vl.getGuard();
		this.shipment=vl.getShipment();
		this.freight=vl.getFreight();
		return true;
	}

	public String getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(String loadingDate) {
		this.loadingDate = loadingDate;
	}

	public String getCarNum() {
		return trainNum;
	}

	public void setCarNum(String carNum) {
		this.trainNum = carNum;
	}

	public String getCarTourNum() {
		return trainTourNum;
	}

	public void setCarTourNum(String carTourNum) {
		this.trainTourNum = carTourNum;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getGuard() {
		return store;
	}

	public void setGuard(String guard) {
		this.store = guard;
	}

	public String getShipment() {
		return shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}


}
