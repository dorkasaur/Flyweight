import java.awt.*;

/**
 * The flyweight class that determines a Ball's radius, color, and update strategy.   This is a shared flyweight, so all balls share the same radius, color and update strategy.
 */
public class BallFlyweight extends ABall
{
	protected int radius;
	protected Color color;
	protected Container container;
  protected AStrategy strategy;

  public BallFlyweight(int r, Color col, Container c, AStrategy a)
  {
    this.radius=r;
    this.color=col;
    this.container=c;
    this.strategy=a;
  }

  public int getRadius()
  {
    return radius;
  }
  public void setRadius(int r)
  {
    this.radius=r;
  }
  public Color getColor()
  {
    return color;
  }
  public void setColor(Color c)
  {
    this.color=c;
  }
  public Container getContainer()
  {
    return container;
  }
  public AStrategy getStrategy()
  {
    return strategy;
  }

  public void update(Graphics g, final Ball b)
  {
 	  move(b);
    ABall ab = new ABall()
  	{
      public int getRadius()
      {
        return BallFlyweight.this.getRadius();
      }
      public void setRadius(int r)
      {
        BallFlyweight.this.setRadius(r);
      }
      public Color getColor()
      {
        return BallFlyweight.this.getColor();
      }
      public void setColor(Color c)
      {
        BallFlyweight.this.setColor(c);
      }
      public Point getVelocity()
      {
        return b.getVelocity();
      }

      public void setVelocity(Point v)
      {
        b.setVelocity(v);
      }

      public Point getLocation()
      {
        return b.getLocation();
      }

      public void setLocation(Point l)
      {
        b.setLocation(l);
      }
  	};

    strategy.doAction(ab);

    paint(g,b.getLocation());
  }

	protected void move (Ball b)
	{
	  Point loc=b.getLocation();
	  Point vel=b.getVelocity();
	  
	  loc.translate (vel.x, vel.y);
	  if (loc.x-radius < 0)
	  {
      loc.x = radius;
      vel.x = -vel.x;
    }
    else if(loc.x+radius > container.getWidth())
    {
      loc.x = container.getWidth()-radius;
      vel.x = -vel.x;
    }
    if (loc.y-radius < 0)
    {
      loc.y = radius;
      vel.y = -vel.y;
    }
    else if(loc.y+radius > container.getHeight())
    {
      loc.y = container.getHeight()-radius;
      vel.y = -vel.y;
    }
    b.setLocation(loc);
    b.setVelocity(vel);
  }

	protected void paint(Graphics g, Point loc)
	{
		g.setColor(color);
		g.fillOval(loc.x-radius, loc.y-radius, 2*radius, 2*radius);
	}

	/**
	 * @param strategy 
	 */
	public void setStrategy(AStrategy strategy)
	{
		this.strategy = strategy;
	}
}