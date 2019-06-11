/*
 * Written By Xiaoyi Liu 04/10/2019
 */
public class Cylinder {

	static double pi = 3.14;
	double baseRadius = 0;
	double height = 0;
	double volume = 0;
	
	public Cylinder(double r, double h) {
		baseRadius = r;
		height = h;
		volume = pi*r*r*h;
	}
	
	public double getVolume() {
		return volume;
	}
}

