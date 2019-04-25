package main;

public class Road {
	private String startPt;
	private String endPt;
	private String rdName;
	private double dist;
	
	public Road(String startPt, String endPt, String rdName, double dist) {
		this.startPt = startPt;
		this.endPt = endPt;
		this.rdName = rdName;
		this.dist = dist;
	}
}
