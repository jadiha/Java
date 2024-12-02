import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.print.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Animator extends Frame {
    static final int DEFAULT_XSIZE = 400;
    static final int DEFAULT_YSIZE = 300;
    private int xSize, ySize;
    private long lastTime = 0;
    private Vector items = new Vector();
    private Vector keysPressed = new Vector();
    WindowCanvas canvas;
    
    public Animator() {
		this(DEFAULT_XSIZE, DEFAULT_YSIZE);
    }

    public Animator(int newXSize, int newYSize) {
		super("Animator");
		xSize = newXSize;
		ySize = newYSize;
		canvas = new WindowCanvas(xSize, ySize);
		Panel controlPanel = new Panel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints cn = new GridBagConstraints();
		Label label1 = new Label("   ");
		Label label2 = new Label("   ");
		controlPanel.setBackground(Color.lightGray);
		controlPanel.setLayout(gb);
		cn.insets = new Insets(4, 4, 4, 4);
	
		add(controlPanel, "North");
		add(canvas, "South");
		pack();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screen.width - getSize().width, 0);
		show();
		canvas.requestFocus();
    }

    public int getXSize() {
		return xSize;
    }

    public int getYSize() {
		return ySize;
    }

    public void add(Circle item) {
		items.add(item);
    }

    public void delay(int delayTime) {
		long currentTime = System.currentTimeMillis();
		
		if (currentTime - lastTime >= delayTime) {
	    	lastTime = currentTime;
	    	return;
		}
		delayTime = delayTime - (int)(currentTime - lastTime);
		try {
	    	Thread.sleep(delayTime);
	    }
		catch (InterruptedException e) {
	    }
		lastTime = System.currentTimeMillis();
    }

    public void draw() {
		Graphics g = canvas.offscreen.getGraphics();
		g.clearRect(0, 0, xSize, ySize);

		for (int counter = 0 ; counter < items.size() ; counter++) {
	    	Circle item = (Circle)items.elementAt(counter);
			double x = item.getX();
			double y = item.getY();
			double direction = item.getDirection();
			double speed = item.getSpeed();
			x += Math.cos(Math.toRadians(direction)) * speed;
			y -= Math.sin(Math.toRadians(direction)) * speed;
			boolean inBounds;
			do {
		    	inBounds = true;
			    if (x < 0) {
					x = -x;
					if (direction <= 180)
					    direction = 180 - direction;
					else
					    direction = 540 - direction;
					inBounds = false;
			    } 
			    if (x > xSize) {
					x = xSize - (x - xSize);
					if (direction <= 180)
					    direction = 180 - direction;
					else
					    direction = 540 - direction;
					inBounds = false;
			    }
			    if (y < 0) {
					y = -y;
					direction = 360 - direction;
					inBounds = false;
			    }
			    if (y > ySize) {
					y = ySize - (y - ySize);
					direction = 360 - direction;
					inBounds = false;
			    }
			} while (!inBounds);
			item.setLocation(x, y);
			item.setDirection(direction);
			item.paint(g, (int)Math.round(x), (int)Math.round(y));
		}
		canvas.repaint();
    }

    class WindowCanvas extends Canvas {
		int xSize, ySize;
		Image offscreen;

		public WindowCanvas(int xSize, int ySize) {
		    this.xSize = xSize;
		    this.ySize = ySize;
		    setSize(xSize, ySize);
		}

		public void addNotify() {
		    super.addNotify();
		    offscreen = createImage(xSize, ySize);
		}

		public void paint(Graphics g) {
	    	update(g);
		}

		public void update(Graphics g) {
	    	Rectangle r = g.getClipBounds();
	    	g.drawImage(offscreen, r.x, r.y, r.x + r.width, r.y + r.width, r.x, r.y, r.x + r.width, r.y + r.width, null, null);
		}

		public void drawWindowToGraphics(Graphics g) {
	    	g.drawImage(offscreen, 0, 0, null);
		}

		public void drawWindowToGraphics(Graphics g, int width, int height) {
	    	g.drawImage(offscreen, 0, 0, null);
		}

		public int getMargin() {
	    	return 0;
		}
    }

    class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
	    	e.getWindow().dispose();
	    	System.exit(0);
		}
    }
}



