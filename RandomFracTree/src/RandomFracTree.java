import java.util.*;
import java.applet.*;
import java.awt.*;
public class RandomFracTree extends Applet {
	private Image display;
	private Graphics drawingArea;
	public void init() {
		this.setSize(600,600);
		int height = getSize().height;
		int width = getSize().width;
		display = createImage(width, height);
		drawingArea = display.getGraphics();
		//TODO recursive call
		drawTree(0,height/2, width, height, drawingArea);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run()
			{
				drawLQ(drawingArea);
			}
		},50,100);
		
	}
	public void paint(Graphics g)
	{
		g.drawImage(display,0,0,null);
		
	}
	private class Line{
		int x1, y1, x2, y2;
		public Line(int aX1, int aY1, int aX2, int aY2) {
			x1 = aX1;
			y1 = aY1;
			x2 = aX2;
			y2 = aY2;
		}
	}
	Queue<Line> lines = new LinkedList<Line>();
	public void drawTree(int leftX, int leftY, int horiSize, int vertSize, Graphics g)
	{
		if (g == null)
			return;
		if (leftX > getSize().width || vertSize/4 <=0)
		{
			return;
		}
		int newLeft = leftX +horiSize/4;
		if(newLeft <= 0)
				newLeft = 1;
		Random r = new Random();
		int topY = leftY - r.nextInt(vertSize/2);
		int btmY =  leftY + r.nextInt(vertSize/2);
		lines.add(new Line (leftX, leftY, newLeft, topY));
		drawTree(newLeft, topY, horiSize*3/4, vertSize/2, g);
		lines.add(new Line (leftX, leftY, newLeft, btmY));
		drawTree(newLeft, btmY, horiSize*3/4, vertSize/2, g);
		
		
	}
	public void drawLQ(Graphics g)
	{
		if(lines.isEmpty()) {
			return;
		}
		Line l = lines.remove();
		g.drawLine(l.x1, l.y1, l.x2, l.y2);
		repaint();
	}
}
















