/*
 * Written by Xiaoyi Liu 03/29/2019
 */
public class Node {
	Node left;
	Node right;
	double side1, side2,radius;
	String shapeType;
	double area;
	
	//Constructor
	public Node()
	{
		left = null;
		right = null;
		shapeType = " ";
		area = 0;
		side1= side2=radius=0;
	}
	public Node (double a, String st, double s1, double s2, double r)
	{
		left = null;
		right = null;
		area =a;
		shapeType = st;
		side1= s1;
		side2 = s2;
		radius =r;
	}
	public void setLeft(Node n)
	{
		left =n;
	}
	public void setRight(Node n)
	{
		right = n;
	}
	public Node getLeft()
	{
		return left;
	}
	public Node getRight()
	{
		return right;
	}
	public void setData(double d)
	{
		area =d;
	}
	public double getArea()
	{
		return area;
	}
	public String getShapeType() {
		return shapeType;
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getRadius() {
		return radius;
	}
	
	public boolean isEqual(Node node1) {
		if (node1.getShapeType().equals(shapeType)
				&& node1.getArea() == area) {
			return true;
		} else {
			return false;
		}
	}
	
	public void copyData(Node node) {
		area = node.getArea();
		shapeType = node.getShapeType();
		side1 = node.getSide1();
		side2 = node.getSide2();
		radius = node.getRadius();
	}
}