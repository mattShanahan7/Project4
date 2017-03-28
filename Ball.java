import java.awt.Color;
import java.awt.Graphics;

public class Ball{


	// Ball Size
	float radius; 
	float diameter;

	// Center of Call
	float X;
	float Y;

	// Direction (Speed)
	float dx;
	float dy;
	
	final int WIDTH = 790;
	final int HEIGHT = 760;

	

	public Ball()
	{
		radius = 40; 
		diameter = radius * 2;
		// Center of Call
		X = radius + (int) (Math.random() * WIDTH);
		Y = radius + (int) (Math.random() * HEIGHT);
		// Direction (Speed)
		dx = (int) (Math.ceil(Math.random() * 10));
		dy = (int) (Math.ceil(Math.random() * 10));
		
		
		//this.start();

	}

	public void move()
	{
		X += dx;
		Y += dy;
		if (X - radius < 0) {
			dx = -dx; 
			X = radius; 
		} else if (X + radius > WIDTH) {
			dx = -dx;
			X = WIDTH - radius;
		}

		if (Y - radius < 0) {
			dy = -dy;
			Y = radius;
		} else if (Y + radius > HEIGHT) {
			dy = -dy;
			Y = HEIGHT - radius;
		}
		
		System.out.println(X + ", " + Y);
	}
	
	
	  public void paint(Graphics g) 
	  {
		    g.setColor(Color.BLUE);
		    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
	  }
	
}