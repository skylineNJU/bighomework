package main.vo;

import java.util.ArrayList;

public class DistanceVO {
	
	String[] city;//��ʾ������
	private double[][] distance;

	public DistanceVO(String[] city,double[][] distance) {
		this.city = city;
		this.distance = distance;
	}

	public String[] getCity() {
		return city;
	}

	public void setCity(String[] city) {
		this.city = city;
	}

	public double[][] getDistance() {
		return distance;
	}

	public void setDistance(double[][] distance) {
		this.distance = distance;
	}
}
