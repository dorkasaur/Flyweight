import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * A concrete ABall that uses a shared flyweight to determine its behavior.
 */
public class Ball extends ABall
	implements Observer
{
  private BallFlyweight flyweight;


	public Ball(BallFlyweight fly, Point p, Point v)
	{
    this.flyweight=fly;
	  location = p;
	  velocity = v;
	}
	
  public int getRadius()
  {
    return flyweight.getRadius();
  }

  public void setRadius(int r)
  {
    flyweight.setRadius(r);
  }

  public Color getColor()
  {
    return flyweight.getColor();
  }

  public void setColor(Color c)
  {
    flyweight.setColor(c);
  }

	public void update(Observable o, Object g)
	{
    flyweight.update((Graphics)g,this);
	}

	protected void paint(Graphics g)
	{
    flyweight.paint(g,location);
	}
}