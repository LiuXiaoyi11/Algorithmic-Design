import java.util.*;

import org.w3c.dom.css.Rect;

import java.applet.*;
import java.awt.*;
public class SierpenskiCarpet extends Applet{
	private Image display;
	private Graphics drawingArea;
	public void init() {
		thid.setSize(600,600);
		int height = getSize().height;
		int width = getSize().width;
		
	}
	public void paint(Graphics g) {
		
	}
	Queue<Rect> rectQ = new LInkedList<Rect>();
	public static final int PIXEL_LMT = 3;
	public void drawGasket( int x, int y, int side, Graphics g) {
		int sub = side/3;
		if(sub < PIXEL_LMT)
		{
			// Top squares
			drawGasket(x,y,sub, g);//left
			drawGasket(x+sub,g);
			drawGasket (x+sub*2, y, sub, g);
			//Middle squares
			drawGasket(x, y+sub, sub, g);
			drawGaket(x+sub, y+sub*2, sub, g);
			drawGaket(x+sub*2, y+sub*2, sub, g);			
		}
		rectQ.add(new Rect(x+sub,y+sub,sub,sub))
		
		
	}
	public void drawRQ()

}
