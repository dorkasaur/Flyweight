import java.awt.*;

/**
 * An abstract Ball class that contains a location and a velocity.
 */
public abstract class ABall
{
	protected Point location;
	protected Point velocity;

	public void setVelocity(Point v)
  {
    velocity=v;
  }

	public Point getLocation()
  {
    return location;
  }

	public Point getVelocity()
  {
    return velocity;
  }

	public void setLocation(Point l)
  {
    this.location=l;
  }

	public abstract int getRadius();

	public abstract void setRadius(int r);

	public abstract Color getColor();

	public abstract void setColor(Color c);
}

