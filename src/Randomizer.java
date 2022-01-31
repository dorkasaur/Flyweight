import java.awt.*;

/**
 * A utility class to create various random values.
 */
public class Randomizer
{

  /**
	 * Generates a random location point subject to the constraint that 0<=X<=maxX and 0<=Y<=maxY.
	 */
	public Point randomLoc( Rectangle rect)
  {
    return (new Point( randomInt(0, rect.width), randomInt(0, rect.height)));
  }

  /**
	 * Returns a random integer greater than or equal to min and less than or equal to max.
	 */
	public int randomInt(int min, int max)
  {
    return ((int)(Math.random()*(max-min)+min));
  }

  /**
	 * Returns a random velocity (as a Point) subject to the constraint that the absolute value of the vleocity (speed) is less than maxV.
	 */
	public Point randomVel( Rectangle rect)
  {
    return (new Point (randomInt(-rect.width, rect.width), randomInt(-rect.height, rect.height)));
  }

  public Color randomColor()
  {
    return (new Color(randomInt(0,255),randomInt(0,255),randomInt(0,255)));
  }

}

