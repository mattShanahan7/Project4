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
	
	final int WIDTH = 780;
	final int HEIGHT = 750;

	boolean barrierUp = true;
	

	public Ball()
	{
		radius = 100; 
		diameter = radius * 2;
		// Center of Call
		X = radius + (int) (Math.random() * WIDTH);
		Y = radius + (int) (Math.random() * HEIGHT);
		// Direction (Speed)
		dx = (int) (Math.ceil(Math.random() * 30));
		dy = (int) (Math.ceil(Math.random() * 30));
		
		
		//this.start();

	}

	public void move()
	{
		if (barrierUp)
		{
			X += dx;
			Y += dy;
			
			if (X - radius < 0)
			{
				dx = -dx;
				X = radius;
			}
			else if (X + radius > (WIDTH / 2) && X < (WIDTH / 2) )
			{
				dx = -dx;
				X = (WIDTH / 2) - radius;
			}
			else if (X - radius < (WIDTH / 2) && X > (WIDTH / 2) )
			{
				dx = -dx;
				X = (WIDTH / 2) + radius;
			}
		}
		else
		{
			X += dx;
			Y += dy;
			
			if (X - radius < 0)
			{
				dx = -dx;
				X = radius;
			}
			else if (X + radius > (WIDTH / 2) && X < (WIDTH / 2) && (Y < 300 || Y > 500) )
			{
				dx = -dx;
				X = (WIDTH / 2) - radius;
			}
			else if (X - radius < (WIDTH / 2) && X > (WIDTH / 2) && (Y < 300 || Y > 500) )
			{
				dx = -dx;
				X = (WIDTH / 2) + radius;
			}
			
		}
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
		
<<<<<<< HEAD
	//	System.out.println(X + ", " + Y);
=======
		//System.out.println(X + ", " + Y);
>>>>>>> 2c30600552acd24e3e320294def6525c0c2cd651
	}
	
	
	  public void paint(Graphics g) 
	  {
		    g.setColor(Color.white);
		    g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
	  }
	
}
