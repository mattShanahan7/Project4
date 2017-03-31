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
	
	final int WIDTH = 800;
	final int HEIGHT = 760;

	boolean barrierUp = true;
	
	boolean isRed;
	

	public Ball()
	{
		//isRed = redFlag;
		
		//Setting variables that are the same for both red and blue balls
		radius = 40; 
		diameter = radius * 2;
		Y = radius + (int) (Math.random() * HEIGHT);
		X = 400;
		dx = 4;
		dy = 4;
		
		/*
		if (isRed)
		{
			//Move ball to right side of the barrier
			X = radius + (WIDTH / 2) + (int)(Math.random() * (WIDTH / 2) );
			System.out.println(X + " red ball position");
			//Direction (Speed)
			dx = 7;
			dy = 7;
			
		}
		else
		{
			X = (int)(Math.random() * (WIDTH / 2) ) - radius;
			System.out.println(X + " blue ball position");
			//Speed
			dx = 3;
			dy = 3;
		}
		*/
		//radius = 40; 
		//diameter = radius * 2;
		// Center of Call
		//X = radius + (int) (Math.random() * WIDTH);
		//Y = radius + (int) (Math.random() * HEIGHT);
		// Direction (Speed)
		//dx = (int) (Math.ceil(Math.random() * 10));
		//dy = (int) (Math.ceil(Math.random() * 10));
		
		
		//this.start();

	}
	
	public void setLeft()
	{
		X = (int)(Math.random() * (WIDTH / 2) ) - radius;
	}
	
	public void setRight()
	{
		X = radius + (WIDTH / 2) + (int)(Math.random() * (WIDTH / 2) );
	}
	
	public void setRed(boolean red)
	{
		isRed = red;

		if (isRed)
		{
			dx = 7;
			dy = 7;
			
		}
		else
		{
			dx = 3;
			dy = 3;
		}

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
				X = 400 - radius;
			}
			else if (X - radius < (WIDTH / 2) && X > (WIDTH / 2) )
			{
				dx = -dx;
				X = 400 + radius;
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
			else if (X + radius > (WIDTH / 2) && X < (WIDTH / 2) && (Y - radius < 300 || Y + radius > 500) )
			{
				dx = -dx;
				X = (WIDTH / 2) - radius;
			}
			else if (X - radius < (WIDTH / 2) && X > (WIDTH / 2) && (Y - radius < 300 || Y + radius > 500) )
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
		
		//System.out.println(X + ", " + Y);
	}
	
	
	  public void paint(Graphics g) 
	  {
		  if (isRed)
		  {
			  //System.out.println("Red flag is on");
			  g.setColor(Color.RED);
			  g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
		  }
		  else
		  {
			  g.setColor(Color.BLUE);
			  g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
		  }
	  }
	
}